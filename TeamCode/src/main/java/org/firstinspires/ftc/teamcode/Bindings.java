package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.gamepads.GamepadWrapper;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.chassis.ChassisCommands;

public class Bindings {

    private static GamepadWrapper mainGamepad;
    private static GamepadWrapper secondGamepad;

    public static void razDriveTestBindings(Gamepad gamepad1) {
        mainGamepad = new GamepadWrapper(gamepad1);


        Robot.getInstance().getChassis().setDefaultCommand(
                ChassisCommands.fieldCentricDrive(
                        () -> mainGamepad.getLeftX(),
                        () -> mainGamepad.getLeftY(),
                        () -> mainGamepad.getRightX()
                )
        );
        mainGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ChassisCommands.resetHeading());
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(ChassisCommands.stop());
    }

}
