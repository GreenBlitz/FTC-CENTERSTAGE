package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.arm.ArmCommands;
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmState;

public class Bindings {

    private static GamepadEx MAIN_GAMEPAD;
    private static GamepadEx SECOND_GAMEPAD;

    public static void razArmBindings(Gamepad gamepad1, Gamepad gamepad2) {
        MAIN_GAMEPAD = new GamepadEx(gamepad1);

        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(ArmCommands.goToState(ArmState.STOP));
        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(ArmCommands.goToState(ArmState.SCORE));
        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(ArmCommands.goToState(ArmState.STARTING));
        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(ArmCommands.goToState(ArmState.PICK_UP));
    }

}
