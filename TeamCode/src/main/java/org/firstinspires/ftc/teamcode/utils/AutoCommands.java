package org.firstinspires.ftc.teamcode.utils;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.RobotState;
import org.firstinspires.ftc.teamcode.subsystems.claw.ClawCommands;

public class AutoCommands {

    public static Command scoreAutonomous(Boolean isAtRightFinger, RobotState robotState) {
        Command clawCommand;
        clawCommand = isAtRightFinger ? ClawCommands.toggleRightFinger() : ClawCommands.toggleLeftFinger();
        return new SequentialCommandGroup(
                Robot.getInstance().setState(robotState),
                clawCommand
        );
    }

    public static Command scoreYellow(boolean isAtRightFinger) {
        return scoreAutonomous(isAtRightFinger, RobotState.SCORE);
    }

    public static Command placePurple(boolean isAtRightFinger) {
        return scoreAutonomous(isAtRightFinger, RobotState.PRE_INTAKE);
    }

}