package org.firstinspires.ftc.teamcode.subsystems.arm;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.FunctionalCommand;

import org.firstinspires.ftc.teamcode.Robot;

public class ArmCommands {

    public static Command goToState(ArmState armState) {
        return new FunctionalCommand(
                () -> Robot.getInstance().arm.setState(armState),
                () -> {},
                interrupt -> Robot.getInstance().arm.setState(ArmState.STAND_IN_PLACE),
                () -> Robot.getInstance().arm.isAtState(),
                Robot.getInstance().arm
        );
    }

}
