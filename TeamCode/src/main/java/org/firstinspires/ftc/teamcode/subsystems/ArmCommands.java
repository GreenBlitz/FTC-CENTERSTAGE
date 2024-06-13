package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.FunctionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;

public class ArmCommands {

    public static FunctionalCommand goToState(ArmState armState) {
        return new FunctionalCommand(
                () -> Arm.getInstance().setState(armState),
                () -> {},
                interrupt -> {},
                () -> Arm.getInstance().isAtState(),
                Arm.getInstance()
        );
    }

    public static InstantCommand setPower(double power) {
        return new InstantCommand(
                () -> Arm.getInstance().setPower(power)
        );
    }

}
