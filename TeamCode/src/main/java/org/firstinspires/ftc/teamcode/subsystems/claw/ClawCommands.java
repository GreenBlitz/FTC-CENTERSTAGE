package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot;

public class ClawCommands {

    public static Command openBothFingers() {
        return new InstantCommand(() -> Robot.getInstance().getClaw().openBothFingers());
    }

    public static Command closeBothFingers() {
        return new InstantCommand(() -> Robot.getInstance().getClaw().closeBothFingers());
    }

    public static Command toggleRightFinger() {
        return new InstantCommand(() -> Robot.getInstance().getClaw().toggleRightFinger());
    }

    public static Command toggleLeftFinger() {
        return new InstantCommand(() -> Robot.getInstance().getClaw().toggleLeftFinger());
    }

    public static Command switchFingers() {
        return new InstantCommand(() -> Robot.getInstance().getClaw().switchFingers());
    }

    public static Command lockFingers() {
        return new InstantCommand(() -> Robot.getInstance().getClaw().lockFingers());
    }

    public static Command unlockFingers() {
        return new InstantCommand(() -> Robot.getInstance().getClaw().unlockFingers());
    }

//    public static Command testRightFinger(double positionAdd) {
//        return new InstantCommand(() -> Robot.getInstance().getClaw().testRightFinger(positionAdd));
//    }
//
//    public static Command testLeftFinger(double positionAdd) {
//        return new InstantCommand(() -> Robot.getInstance().getClaw().testLeftFinger(positionAdd));
//    }
}