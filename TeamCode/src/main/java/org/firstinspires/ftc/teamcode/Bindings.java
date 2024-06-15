package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.claw.*;
import org.firstinspires.ftc.teamcode.gamepads.GamepadWrapper;

public class Bindings {

    private static GamepadWrapper mainGamepad;
    private static GamepadWrapper secondGamepad;

    public static void razClawTest(Gamepad gamepad1, Gamepad gamepad2) {
        mainGamepad = new GamepadWrapper(gamepad1);
        secondGamepad = new GamepadWrapper(gamepad2);

        mainGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(ClawCommands.toggleRightFinger);
        mainGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(ClawCommands.toggleLeftFinger);
        mainGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(ClawCommands.openBothFingers);
        mainGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ClawCommands.closeBothFingers);
    }

}
