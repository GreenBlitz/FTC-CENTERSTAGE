package org.firstinspires.ftc.teamcode.opmodes.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcontroller.external.samples.BasicOpMode_Iterative;
import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.FieldStartingLocation;
import org.firstinspires.ftc.teamcode.R;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.RobotState;
import org.firstinspires.ftc.teamcode.gamelayout.FieldConstants;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;
import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.roadrunner.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.subsystems.claw.ClawCommands;

@Autonomous(name = "Herman")
public class HermanAuto extends DefaultRaz {

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
        while (Robot.getInstance().getVision().getPropLocation() == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        drive.setPoseEstimate(FieldConstants.CLOSE_RED_START);
        Robot.getInstance().setPropLocation(Robot.getInstance().getVision().getPropLocation());
        TrajectorySequence trajSeq = drive.trajectorySequenceBuilder(FieldConstants.CLOSE_RED_START)
                .forward(25)
//                .lineTo(FieldConstants.PRE_PURPLE_RED_CLOSE)
                .turn(Math.toRadians(Robot.getInstance().getPropLocation().angle))
                .addTemporalMarker(() -> Robot.getInstance().setState(RobotState.PRE_INTAKE).schedule())
                .waitSeconds(2)
                .addTemporalMarker(() -> Robot.getInstance().getClaw().openRight())
                .waitSeconds(0.5)
                .addTemporalMarker(() -> Robot.getInstance().setState(RobotState.DRIVE).schedule())
                .waitSeconds(1)
                .turn(Math.toRadians(45))
                .build();

        drive.followTrajectorySequence(trajSeq);
    }

    @Override
    public void configureBindings() {

    }
}
