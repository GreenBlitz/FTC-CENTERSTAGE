package org.firstinspires.ftc.teamcode.subsystems.arm;

import com.arcrobotics.ftclib.command.FunctionalCommand;

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

}
