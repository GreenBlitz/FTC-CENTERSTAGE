package org.firstinspires.ftc.teamcode;


import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.subsystems.MecanumCommands;

public class Bindings {

    public static void razBindings(GamepadEx gamepad) {
        RobotContainer.MECANUM.setDefaultCommand(
                MecanumCommands.getFieldRelativeDriveCommand(
                        gamepad::getLeftY,
                        () -> -gamepad.getLeftX(),
                        () -> -gamepad.getRightX()
                )
        );
        gamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(RobotContainer.MECANUM::resetHeading);

    }

}
