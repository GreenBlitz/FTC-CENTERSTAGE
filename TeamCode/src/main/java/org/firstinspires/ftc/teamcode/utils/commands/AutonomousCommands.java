package org.firstinspires.ftc.teamcode.utils.commands;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.arm.ArmCommands;
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmState;
import org.firstinspires.ftc.teamcode.subsystems.claw.ClawCommands;
import org.firstinspires.ftc.teamcode.subsystems.wrist.WristCommands;
import org.firstinspires.ftc.teamcode.subsystems.wrist.WristState;

public class AutonomousCommands {

    public static Command scoreYellow(boolean isAtRightClaw) {
        return scoreAutonomous(isAtRightClaw, ArmState.SCORE, WristState.SCORE);
    }

    public static Command scorePurple(boolean isAtRightClaw) {
        return scoreAutonomous(isAtRightClaw, ArmState.INTAKE, WristState.INTAKE);
    }

    public static Command scoreAutonomous(boolean isAtRightClaw, ArmState armState, WristState wristState) {
        Command clawCommand;

        clawCommand = isAtRightClaw ? ClawCommands.toggleRightFinger() : ClawCommands.toggleLeftFinger();

        return new SequentialCommandGroup(
                new ParallelCommandGroup(
                        ArmCommands.goToState(armState),
                        WristCommands.moveToState(wristState)
                ),
                clawCommand
        );
    }

}
