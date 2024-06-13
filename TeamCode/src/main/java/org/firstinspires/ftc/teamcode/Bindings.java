package org.firstinspires.ftc.teamcode;


import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;
import org.firstinspires.ftc.teamcode.subsystems.launcher.LauncherCommands;


public class Bindings {

    private static GamepadEx MAIN_GAMEPAD;
    private static GamepadEx SECOND_GAMEPAD;


    public static void razLaunchBindings(Gamepad gamepad1, Gamepad gamepad2) {
        MAIN_GAMEPAD = new GamepadEx(gamepad1);
        SECOND_GAMEPAD = new GamepadEx(gamepad2);

        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.A).whenPressed(LauncherCommands.launchCommand());


    }

}
