package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.arcrobotics.ftclib.command.FunctionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.subsystems.claw.Claw;

public class ClawCommands {
    public static InstantCommand toggleClawCommand = new InstantCommand(()-> Claw.getInstance().toggleBothClaws());
    public static InstantCommand toggleRightFingerCommand = new InstantCommand(()-> Claw.getInstance().rightFinger.toggleClaw());
    public static InstantCommand toggleLeftFingerCommand = new InstantCommand(()-> Claw.getInstance().leftFinger.toggleClaw());
    public static InstantCommand switchClawsCommand = new InstantCommand(()-> Claw.getInstance().switchClaws());


}