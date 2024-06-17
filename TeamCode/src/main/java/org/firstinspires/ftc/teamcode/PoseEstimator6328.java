package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Transform2d;
import com.arcrobotics.ftclib.geometry.Translation2d;
import com.arcrobotics.ftclib.geometry.Twist2d;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveKinematics;

import org.ejml.simple.SimpleMatrix;

import java.util.NoSuchElementException;
import java.util.Optional;

public class PoseEstimator6328 {

    private static final double POSE_BUFFER_SIZE_SECONDS = 2.0;

    private static PoseEstimator6328 instance;

    public static PoseEstimator6328 getInstance() {
        if (instance == null) {
            instance = new PoseEstimator6328();
        }
        return instance;
    }

    // Pose Estimation Members
    private Pose2d odometryPose = new Pose2d();
    private Pose2d estimatedPose = new Pose2d();
    private final TimeInterpolatableBuffer<Pose2d> poseBuffer = TimeInterpolatableBuffer.createBuffer(POSE_BUFFER_SIZE_SECONDS);
    private final SimpleMatrix qStdDevs = new SimpleMatrix(3, 1);
    // Odometry
    private final MecanumDriveKinematics kinematics;
    private MecanumDriveWheelPositions lastWheelPositions =
            new MecanumDriveWheelPositions(
                    new MecanumModulePosition[]{
                            new MecanumModulePosition(),
                            new MecanumModulePosition(),
                            new MecanumModulePosition(),
                            new MecanumModulePosition()
                    });
    private Rotation2d lastGyroAngle = new Rotation2d();
    private boolean isFirstOdometryUpdate = true;

    private PoseEstimator6328() {
        for (int i = 0; i < 3; ++i) {
            qStdDevs.set(i, 0, Math.pow(PoseEstimatorConstants.ODOMETRY_STANDARD_DEVIATIONS.get(i, 0), 2));
        }
        kinematics = ChassisConstants.KINEMATICS;
    }

    /**
     * Add odometry observation
     */
    public void addOdometryObservation(MecanumDriveWheelPositions wheelPositions, Rotation2d gyroAngle, double timestamp) {
        // Set the created values to starting values
        if (isFirstOdometryUpdate) {//todo - make it happen once
            lastWheelPositions = Robot.getInstance().getChassis().getMecanumWheelSpeeds(0);
            lastGyroAngle = Robot.getInstance().getChassis().getOdometryYawUpdates()[0];
            isFirstOdometryUpdate = false;
        }

        Twist2d twist = kinematics.toT(lastWheelPositions, wheelPositions);

        lastWheelPositions = wheelPositions;
        // Check gyro connected
        if (gyroAngle != null) {
            // Update theta for twist if gyro connected
            twist = new Twist2d(twist.dx, twist.dy, gyroAngle.minus(lastGyroAngle).getRadians());
            lastGyroAngle = gyroAngle;
        }
        // Add twist to odometry pose
        odometryPose = odometryPose.exp(twist);
        // Add pose to buffer at timestamp
        poseBuffer.addSample(timestamp, odometryPose);
        // Calculate diff from last odometry pose and add onto pose estimate
        estimatedPose = estimatedPose.exp(twist);
    }

    public void addVisionObservation(Pose2d visionPose, double timestamp, SimpleMatrix stdDevs) {
        // If measurement is old enough to be outside the pose buffer's timespan, skip.
        try {
            if (poseBuffer.getInternalBuffer().lastKey() - POSE_BUFFER_SIZE_SECONDS > timestamp) {
                return;
            }
        }
        catch (NoSuchElementException ex) {
            return;
        }
        // Get odometry based pose at timestamp
        Optional<Pose2d> sample = poseBuffer.getSample(timestamp);
        if (sample.isPresent()) {
            // exit if not there
            return;
        }

        // sample --> odometryPose transform and backwards of that
        Transform2d sampleToOdometryTransform = new Transform2d(sample.get(), odometryPose);
        Transform2d odometryToSampleTransform = new Transform2d(odometryPose, sample.get());
        // get old estimate by applying odometryToSample Transform
        Pose2d estimateAtTime = estimatedPose.plus(odometryToSampleTransform);

        // Calculate 3 x 3 vision matrix
        double[] r = new double[3];
        for (int i = 0; i < 3; ++i) {
            r[i] = stdDevs.get(i, 0) * stdDevs.get(i, 0);
        }
        // Solve for closed form Kalman gain for continuous Kalman filter with A = 0
        // and C = I. See wpimath/algorithms.md.
        double[] visionK = new double[3];
        for (int row = 0; row < 3; ++row) {
            double stdDev = qStdDevs.get(row, 0);
            if (stdDev == 0.0) {
                visionK[row] = 0.0;
            }
            else {
                visionK[row] = stdDev / (stdDev + Math.sqrt(stdDev * r[row]));
            }
        }
        // difference between estimate and vision pose
        Transform2d transform = new Transform2d(estimateAtTime, visionPose);
        // scale transform by visionK
        double[] kTimesTransform = {visionK[0] * transform.getTranslation().getX(), visionK[1] * transform.getTranslation().getY(), visionK[2] * transform.getRotation().getDegrees()};
        Transform2d scaledTransform = new Transform2d(
                new Translation2d(
                        kTimesTransform[0],
                        kTimesTransform[1]
                ),
                Rotation2d.fromDegrees(kTimesTransform[2])
        );

        // Recalculate current estimate by applying scaled transform to old estimate
        // then replaying odometry data
        estimatedPose = estimateAtTime.plus(scaledTransform).plus(sampleToOdometryTransform);
    }

    /**
     * Reset estimated pose and odometry pose to pose <br>
     * Clear pose buffer
     */
    public void resetPose(Pose2d initialPose) {
        estimatedPose = initialPose;
        lastGyroAngle = initialPose.getRotation();
        odometryPose = initialPose;
        poseBuffer.clear();
    }

    public Pose2d getEstimatedPose() {
        return estimatedPose;
    }

    public Pose2d getOdometryPose() {
        return odometryPose;
    }

    public void setOdometryStandardDeviations(double x, double y, double rotation) {
        double[] newQStdDevs = {x, y, rotation};
        for (int i = 0; i < 3; ++i) {
            qStdDevs.set(i, 0, Math.pow(newQStdDevs[i], 2));
        }
    }

}
