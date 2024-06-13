package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot;

public class ClawCommands {

    public static final InstantCommand openBothFingers = new InstantCommand(() -> Robot.getInstance().CLAW.openBothClaws());
    public static final InstantCommand closeBothFingers = new InstantCommand(() -> Robot.getInstance().CLAW.closeBothClaws());
    public static final InstantCommand toggleRightFinger = new InstantCommand(() -> Robot.getInstance().CLAW.toggleRightClaw());
    public static final InstantCommand toggleLeftFinger = new InstantCommand(() -> Robot.getInstance().CLAW.toggleLeftClaw());
    public static final InstantCommand switchClaws = new InstantCommand(() -> Robot.getInstance().CLAW.switchClaws());

}