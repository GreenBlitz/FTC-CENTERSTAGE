package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.Subsystem;

import org.checkerframework.checker.units.qual.C;
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmCommands;
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmState;
import org.firstinspires.ftc.teamcode.subsystems.claw.ClawCommands;
import org.firstinspires.ftc.teamcode.subsystems.wrist.WristCommands;
import org.firstinspires.ftc.teamcode.subsystems.wrist.WristState;

import java.util.Set;

public class AutonomousCommands {

    public static Command scoreAutonomous(Boolean isAtRightClaw, ArmState armState, WristState wristState){
        Command command;

        if (isAtRightClaw){
            command = ClawCommands.toggleRightFinger();
        } else {
            command = ClawCommands.toggleLeftFinger();
        }
        return new SequentialCommandGroup(
                new ParallelCommandGroup(
                        ArmCommands.goToState(armState),
                        WristCommands.moveToState(wristState)
                ),
                command
        );
    }

}
