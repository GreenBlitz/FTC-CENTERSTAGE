package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.ArmCommands;
import org.firstinspires.ftc.teamcode.subsystems.ArmState;

import kotlin.jvm.Throws;

public class Bindings {

    private static GamepadEx MAIN_GAMEPAD;
    private static GamepadEx SECOND_GAMEPAD;

    public static void razArmBindings(Gamepad gamepad1, Gamepad gamepad2) {
        MAIN_GAMEPAD = new GamepadEx(gamepad1);

        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(ArmCommands.goToState(ArmState.STOP));
        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whileHeld(ArmCommands.goToState(ArmState.SCORE).andThen(
                new InstantCommand(() -> {
                    throw new RuntimeException();
                })
        ));
        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whileHeld(ArmCommands.goToState(ArmState.STARTING));
        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.DPAD_UP).whileHeld(ArmCommands.goToState(ArmState.PICK_UP));
    }

}
