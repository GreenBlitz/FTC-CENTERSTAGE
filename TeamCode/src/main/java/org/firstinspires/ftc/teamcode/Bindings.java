package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.arm.ArmCommands;
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmState;
import org.firstinspires.ftc.teamcode.gamepads.GamepadWrapper;

public class Bindings {

    private static GamepadWrapper mainGamepad;
    private static GamepadWrapper secondGamepad;

    public static void razArmTestBindings(Gamepad gamepad1, Gamepad gamepad2) {
        mainGamepad = new GamepadWrapper(gamepad1);

        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(ArmCommands.goToState(ArmState.SCORE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(ArmCommands.goToState(ArmState.INTAKE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(ArmCommands.goToState(ArmState.STARTING));
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(ArmCommands.goToState(ArmState.STAND_IN_PLACE));
    }

}
