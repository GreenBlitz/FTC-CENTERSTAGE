package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.gamepads.GamepadWrapper;
import org.firstinspires.ftc.teamcode.gamepads.GamepadFunctions;
import org.firstinspires.ftc.teamcode.subsystems.elevator.ElevatorCommands;
import org.firstinspires.ftc.teamcode.subsystems.elevator.ElevatorState;

public class Bindings {

    private static GamepadWrapper mainGamepad;
    private static GamepadWrapper secondGamepad;

    public static void razElevatorTest(Gamepad gamepad1, Gamepad gamepad2) {
        mainGamepad = new GamepadWrapper(gamepad1);

        mainGamepad.getTriggerAsButton(GamepadKeys.Trigger.LEFT_TRIGGER).whenActive(
                ElevatorCommands.humanControl(() -> {
                            double triggerValue = mainGamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER);
                            return GamepadFunctions.getDeadZonedValue(triggerValue);
                        }
                )
        );
        mainGamepad.getTriggerAsButton(GamepadKeys.Trigger.RIGHT_TRIGGER).whenActive(
                ElevatorCommands.humanControl(() -> {
                            double triggerValue = -mainGamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER);
                            return GamepadFunctions.getDeadZonedValue(triggerValue);
                        }
                )
        );
        mainGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(ElevatorCommands.goToState(ElevatorState.SCORE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ElevatorCommands.goToState(ElevatorState.CLIMB));
        mainGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(ElevatorCommands.goToState(ElevatorState.PICK_UP));
    }

}
