package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.FunctionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot;

public class ArmCommands {

    public static FunctionalCommand goToState(ArmState armState) {
        return new FunctionalCommand(
                () -> Robot.getInstance().ARM.setState(armState),
                () -> {},
                interrupt -> {},
                () -> Robot.getInstance().ARM.isAtState(),
                Robot.getInstance().ARM
        );
    }

    public static InstantCommand setPower(double power) {
        return new InstantCommand(() -> Robot.getInstance().ARM.setPower(power));
    }

}
