package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot;

public class ClawCommands {

    public static final InstantCommand openBothFingersCommand = new InstantCommand(()-> Robot.getInstance().CLAW.openBothClaws());
    public static final InstantCommand closeBothFingersCommand = new InstantCommand(()-> Robot.getInstance().CLAW.closeBothClaws());
    public static final InstantCommand toggleRightFingerCommand = new InstantCommand(()-> Robot.getInstance().CLAW.toggleRightClaw());
    public static final InstantCommand toggleLeftFingerCommand = new InstantCommand(()-> Robot.getInstance().CLAW.toggleLeftClaw());
    public static final InstantCommand switchClawsCommand = new InstantCommand(()-> Robot.getInstance().CLAW.switchClaws());

}