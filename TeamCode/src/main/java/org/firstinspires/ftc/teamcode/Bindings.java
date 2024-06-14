package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.wrist.WristCommands;
import org.firstinspires.ftc.teamcode.subsystems.wrist.WristState;

public class Bindings {

    private static GamepadEx MAIN_GAMEPAD;
    private static GamepadEx SECOND_GAMEPAD;

    public static void wristBindings(Gamepad gamepad1, Gamepad gamepad2){
        MAIN_GAMEPAD = new GamepadEx(gamepad1);
        SECOND_GAMEPAD = new GamepadEx(gamepad2);

        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.B).whenPressed(WristCommands.moveToStateCommand(WristState.SCORE));
        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.X).whenPressed(WristCommands.moveToStateCommand(WristState.INTAKE));
    }

}
