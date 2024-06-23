package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.FieldStartingLocation;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.roadrunner.trajectorysequence.TrajectorySequence;

@Autonomous(name = "DefaultGil")
public  class DefaultGil extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
//        Robot.getInstance().setAlliance(getAlliance());
//        Robot.getInstance().setFieldStartingLocation(getFieldStartingLocation());
        Robot.init(hardwareMap);
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Pose2d startPose = new Pose2d(0, 0, 0);

        drive.setPoseEstimate(new Pose2d(10, 60, Math.PI/2));

        TrajectorySequence trajSeq = drive.trajectorySequenceBuilder(new Pose2d(10, 60, Math.PI/2))
                .lineTo(new Vector2d(10, 40))
                .turn(Math.toRadians(-45))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .lineTo(new Vector2d(50, 40))
//                .lineToLinearHeading(new Pose2d(40, 35, 0))
//                .lineToLinearHeading(new Pose2d(50,  40))
                .addTemporalMarker(() -> {})
                .waitSeconds(0.5)
                .build();

        waitForStart();

        if (!isStopRequested())
            drive.followTrajectorySequence(trajSeq);
    }

//    public abstract Alliance getAlliance();
//    public abstract FieldStartingLocation getFieldStartingLocation();
//    public abstract void run() throws InterruptedException;

}
