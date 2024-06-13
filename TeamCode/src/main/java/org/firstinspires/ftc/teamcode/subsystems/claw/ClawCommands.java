package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.arcrobotics.ftclib.command.FunctionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.claw.Claw;

public class ClawCommands {
    public static final InstantCommand toggleClawCommand = new InstantCommand(()-> Robot.getInstance().CLAW.toggleBothClaws());
    public static final InstantCommand toggleRightFingerCommand = new InstantCommand(()-> Robot.getInstance().CLAW.rightFinger.toggleClaw());
    public static final InstantCommand toggleLeftFingerCommand = new InstantCommand(()-> Robot.getInstance().CLAW.leftFinger.toggleClaw());
    public static final InstantCommand switchClawsCommand = new InstantCommand(()-> Robot.getInstance().CLAW.switchClaws());


}