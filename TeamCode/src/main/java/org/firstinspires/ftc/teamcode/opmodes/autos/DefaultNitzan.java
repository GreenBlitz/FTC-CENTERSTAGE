package org.firstinspires.ftc.teamcode.opmodes.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.FieldStartingLocation;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.roadrunner.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.utils.AutoUtil;

public abstract class DefaultNitzan extends LinearOpMode {
    protected Pose2d currentPose;
    protected SampleMecanumDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {
        Robot.getInstance().setAlliance(getAlliance());
        Robot.getInstance().setFieldStartingLocation(getFieldStartingLocation());
        Robot.init(hardwareMap);
        this.currentPose = new Pose2d();
        this.drive = Robot.getInstance().getAutoChassis();
        run();
    }

    public abstract Alliance getAlliance();
    public abstract FieldStartingLocation getFieldStartingLocation();
    public abstract void run() throws InterruptedException;

    public TrajectorySequence close() {
        double allianceModifier = AutoUtil.getAllianceYModifier();

        TrajectorySequence trajectorySequence = drive.trajectorySequenceBuilder(currentPose)
                .lineToSplineHeading(AutoUtil.getAssignedPurplePose())
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .splineToLinearHeading(new Pose2d(25, 55 * allianceModifier), 0)
                .splineToSplineHeading(new Pose2d(40, 35 * allianceModifier, 0), 0)
                .lineToLinearHeading(AutoUtil.getAssignedYellowPose())
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .build();

        currentPose = AutoUtil.getAssignedYellowPose();
        return trajectorySequence;
    }

    public TrajectorySequence far() {
        double allianceModifier = AutoUtil.getAllianceYModifier();

        TrajectorySequence trajectorySequence = drive.trajectorySequenceBuilder(currentPose)
                .lineToSplineHeading(AutoUtil.getAssignedPurplePose())
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .strafeLeft(25)
                .lineToLinearHeading(new Pose2d(-55, 35 * allianceModifier, Math.PI))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .lineTo(new Vector2d(-55, 11 * allianceModifier))
                .lineTo(new Vector2d(20, 11 * allianceModifier))
                .lineToSplineHeading(new Pose2d(40, 25 * allianceModifier, 0))
                .lineToLinearHeading(AutoUtil.getAssignedYellowPose())
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .build();

        currentPose = AutoUtil.getAssignedYellowPose();
        return trajectorySequence;
    }

    public TrajectorySequence backdropToPixelPile() {
        double allianceModifier = AutoUtil.getAllianceYModifier();

        TrajectorySequence trajectorySequence = drive.trajectorySequenceBuilder(currentPose)
                .lineToSplineHeading(new Pose2d(20, 11 * allianceModifier, Math.PI))
                .lineTo(new Vector2d(-55, 11 * allianceModifier))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .lineTo(new Vector2d(20, 11 * allianceModifier))
                .lineToSplineHeading(new Pose2d(50, 35 * allianceModifier, 0))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .build();

        currentPose = new Pose2d(50, 35 * allianceModifier, 0);
        return trajectorySequence;
    }
}
