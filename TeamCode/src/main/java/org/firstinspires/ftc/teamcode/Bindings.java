package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.gamepads.GamepadWrapper;
import org.firstinspires.ftc.teamcode.subsystems.launcher.LauncherCommands;

public class Bindings {

    private static GamepadWrapper mainGamepad;
    private static GamepadWrapper secondGamepad;

    public static void razLauncherTestBindings(Gamepad gamepad1, Gamepad gamepad2) {
        mainGamepad = new GamepadWrapper(gamepad1);
        mainGamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(LauncherCommands.launchPlane());
    }
}
