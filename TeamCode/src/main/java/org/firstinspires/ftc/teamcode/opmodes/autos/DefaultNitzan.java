package org.firstinspires.ftc.teamcode.opmodes.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.FieldStartingLocation;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.roadrunner.trajectorysequence.TrajectorySequence;

public abstract class DefaultNitzan extends LinearOpMode {
    protected Pose2d startingPose = new Pose2d();
    protected SampleMecanumDrive drive = Robot.getInstance().getAutoChassis();

    @Override
    public void runOpMode() throws InterruptedException {
        Robot.getInstance().setAlliance(getAlliance());
        Robot.getInstance().setFieldStartingLocation(getFieldStartingLocation());
        Robot.init(hardwareMap);
        run();
    }

    public abstract Alliance getAlliance();
    public abstract FieldStartingLocation getFieldStartingLocation();
    public abstract void run() throws InterruptedException;

    public TrajectorySequence closeRed() {
        TrajectorySequence trajectorySequence = drive.trajectorySequenceBuilder(startingPose)
                .lineToSplineHeading(new Pose2d(14, -40, Math.toRadians(45)))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .splineToLinearHeading(new Pose2d(25, -55), 0)
                .splineToSplineHeading(new Pose2d(40, -35, 0), 0)
                .lineToLinearHeading(new Pose2d(50, -43))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .build();
        startingPose = new Pose2d(50, -43);
        return trajectorySequence;
    }

    public TrajectorySequence farRed() {
        TrajectorySequence trajectorySequence = drive.trajectorySequenceBuilder(startingPose)
                .lineToSplineHeading(new Pose2d(-38, -40, Math.toRadians(135)))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .strafeLeft(25)
                .lineToLinearHeading(new Pose2d(-55, -35, Math.PI))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .lineTo(new Vector2d(-55, -11))
                .lineTo(new Vector2d(20, -11))
                .lineToSplineHeading(new Pose2d(40, -25, 0))
                .lineToLinearHeading(new Pose2d(50, -43))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .build();
        startingPose = new Pose2d(50, -43);
        return trajectorySequence;
    }

    public TrajectorySequence redBackdropToPixelPile() {
        TrajectorySequence trajectorySequence = drive.trajectorySequenceBuilder(startingPose)
                .lineToSplineHeading(new Pose2d(20, -11, Math.PI))
                .lineTo(new Vector2d(-55, -11))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .lineTo(new Vector2d(20, -11))
                .lineToSplineHeading(new Pose2d(50, -35, 0))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .build();
        startingPose = new Pose2d(50, -35, 0);
        return trajectorySequence;
    }

    public TrajectorySequence blueBackdropToPixelPile() {
        TrajectorySequence trajectorySequence = drive.trajectorySequenceBuilder(startingPose)
                .lineToSplineHeading(new Pose2d(20, 11, Math.PI))
                .lineTo(new Vector2d(-55, 11))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .lineTo(new Vector2d(20, 11))
                .lineToSplineHeading(new Pose2d(50, 35, 0))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .build();
        startingPose = new Pose2d(50, -35, 0);
        return trajectorySequence;
    }
}
