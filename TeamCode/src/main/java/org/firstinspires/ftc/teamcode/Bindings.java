package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.claw.*;

public class Bindings {

    private static GamepadEx MAIN_GAMEPAD;
    private static GamepadEx SECOND_GAMEPAD;

    public static void razClawTestBindings(Gamepad gamepad1, Gamepad gamepad2) {
        MAIN_GAMEPAD = new GamepadEx(gamepad1);
        SECOND_GAMEPAD = new GamepadEx(gamepad2);

        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.B).whenPressed(ClawCommands.toggleRightFinger);
        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.X).whenPressed(ClawCommands.toggleLeftFinger);
        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.A).whenPressed(ClawCommands.openBothFingers);
        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ClawCommands.closeBothFingers);
    }

}
