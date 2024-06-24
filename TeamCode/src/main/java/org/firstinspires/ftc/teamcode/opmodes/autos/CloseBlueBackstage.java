package org.firstinspires.ftc.teamcode.opmodes.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.FieldStartingLocation;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.RobotState;
import org.firstinspires.ftc.teamcode.gamelayout.FieldConstants;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;
import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.roadrunner.trajectorysequence.TrajectorySequence;

@Autonomous(name = "CloseBlueBackstage")
public class CloseBlueBackstage extends DefaultRaz {

    private SampleMecanumDrive drive;
    private Pose2d startPose;
    private boolean isExe = false;

    @Override
    public void execute() {
        if (!isExe) {
            isExe = true;
            executeCool();
        }
    }

    public Alliance getAlliance() {
        return Alliance.RED;
    }

    public FieldStartingLocation getFieldStartingLocation() {
        return FieldStartingLocation.CLOSE;
    }

    @Override
    public void initialize() {
        // init all
        Robot.getInstance().setAlliance(getAlliance());
        Robot.getInstance().setFieldStartingLocation(getFieldStartingLocation());
        // start drive system
        drive = new SampleMecanumDrive(hardwareMap);
        startPose = new Pose2d(0, 0, 0);
    }

    public void executeCool() {
        drive.setPoseEstimate(FieldConstants.CLOSE_RED_START);

        TrajectorySequence trajSeq = drive.trajectorySequenceBuilder(FieldConstants.CLOSE_RED_START)
                .strafeRight(45)
                .addTemporalMarker(() ->
                        Robot.getInstance().setState(RobotState.INTAKE)
                )
//                .setReversed(true)
                .build();

        drive.followTrajectorySequence(trajSeq);
    }

    @Override
    public void configureBindings() {

    }
}
