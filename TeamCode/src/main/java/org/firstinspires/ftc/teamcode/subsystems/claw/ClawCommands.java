package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot;

public class ClawCommands {

    public static final Command openBothFingers = new InstantCommand(() -> Robot.getInstance().getClaw().openBothFingers());
    public static final Command closeBothFingers = new InstantCommand(() -> Robot.getInstance().getClaw().closeBothFingers());
    public static final Command toggleRightFinger = new InstantCommand(() -> Robot.getInstance().getClaw().toggleRightFinger());
    public static final Command toggleLeftFinger = new InstantCommand(() -> Robot.getInstance().getClaw().toggleLeftFinger());
    public static final Command switchFingers = new InstantCommand(() -> Robot.getInstance().getClaw().switchFingers());

}