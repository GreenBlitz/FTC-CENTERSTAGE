package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot;

public class ClawCommands {

    public static final Command openBothFingers = new InstantCommand(() -> Robot.getInstance().claw.openBothFingers());
    public static final Command closeBothFingers = new InstantCommand(() -> Robot.getInstance().claw.closeBothFingers());
    public static final Command toggleRightFinger = new InstantCommand(() -> Robot.getInstance().claw.toggleRightFinger());
    public static final Command toggleLeftFinger = new InstantCommand(() -> Robot.getInstance().claw.toggleLeftFinger());
    public static final Command switchClaws = new InstantCommand(() -> Robot.getInstance().claw.switchFingers());

}