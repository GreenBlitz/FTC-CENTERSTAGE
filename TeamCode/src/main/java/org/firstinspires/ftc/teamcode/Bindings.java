package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.chassis.ChassisCommands;
import org.firstinspires.ftc.teamcode.subsystems.chassis.MecanumChassis;

public class Bindings {

    private static GamepadEx MAIN_GAMEPAD;
    private static GamepadEx SECOND_GAMEPAD;

    public static void razDriveBindings(Gamepad gamepad1, Gamepad gamepad2) {
        MAIN_GAMEPAD = new GamepadEx(gamepad1);
        SECOND_GAMEPAD = new GamepadEx(gamepad2);


        MecanumChassis.getInstance().setDefaultCommand(ChassisCommands.getFieldCentricDrive(() -> -MAIN_GAMEPAD.getLeftX(), () -> -MAIN_GAMEPAD.getLeftY(), () -> -MAIN_GAMEPAD.getRightX()));
        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ChassisCommands.getResetHeading());
    }

}
