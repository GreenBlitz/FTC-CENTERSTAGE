package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.gamelayout.Field;
import org.firstinspires.ftc.teamcode.gamepads.GamepadFunctions;
import org.firstinspires.ftc.teamcode.gamepads.GamepadWrapper;
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmCommands;
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmState;
import org.firstinspires.ftc.teamcode.subsystems.claw.ClawCommands;
import org.firstinspires.ftc.teamcode.subsystems.wrist.WristCommands;
import org.firstinspires.ftc.teamcode.subsystems.wrist.WristState;
import org.firstinspires.ftc.teamcode.subsystems.chassis.ChassisCommands;
import org.firstinspires.ftc.teamcode.subsystems.launcher.LauncherCommands;
import org.firstinspires.ftc.teamcode.subsystems.elevator.ElevatorCommands;
import org.firstinspires.ftc.teamcode.subsystems.elevator.ElevatorState;

public class Bindings {

    private static GamepadWrapper mainGamepad;
    private static GamepadWrapper secondGamepad;

    public static void razRobotStateTest(Gamepad gamepad){
        mainGamepad = new GamepadWrapper(gamepad);

        mainGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(Robot.getInstance().setState(RobotState.SCORE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(Robot.getInstance().setState(RobotState.INTAKE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(Robot.getInstance().setState(RobotState.CLIMB));
        mainGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(Robot.getInstance().setState(RobotState.DRIVE));
    }

    public static void razClawTest(Gamepad gamepad) {
        mainGamepad = new GamepadWrapper(gamepad);

        mainGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(ClawCommands.toggleRightFinger());
        mainGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(ClawCommands.toggleLeftFinger());
        mainGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(ClawCommands.openBothFingers());
        mainGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ClawCommands.closeBothFingers());
    }

    public static void razLauncherTest(Gamepad gamepad) {
        mainGamepad = new GamepadWrapper(gamepad);

        mainGamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(LauncherCommands.launchPlane());
    }

    public static void razArmTest(Gamepad gamepad) {
        mainGamepad = new GamepadWrapper(gamepad);

        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(ArmCommands.goToState(ArmState.SCORE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(ArmCommands.goToState(ArmState.INTAKE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(ArmCommands.goToState(ArmState.STARTING));
        mainGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ArmCommands.goToState(ArmState.IDLE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(ArmCommands.goToState(ArmState.STAND_IN_PLACE));
    }

    public static void razElevatorTest(Gamepad gamepad) {
        mainGamepad = new GamepadWrapper(gamepad);

        mainGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(ElevatorCommands.goToState(ElevatorState.SCORE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ElevatorCommands.goToState(ElevatorState.CLIMB));
        mainGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(ElevatorCommands.goToState(ElevatorState.INTAKE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(ElevatorCommands.goToState(ElevatorState.IDLE));
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
    }

    public static void razWristTest(Gamepad gamepad) {
        mainGamepad = new GamepadWrapper(gamepad);

        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(WristCommands.moveToState(WristState.SCORE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(WristCommands.moveToState(WristState.INTAKE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(WristCommands.moveToState(WristState.IDLE));
    }

    public static void razChassisTest(Gamepad gamepad) {
        mainGamepad = new GamepadWrapper(gamepad);

        Robot.getInstance().getChassis().setDefaultCommand(
                ChassisCommands.fieldCentricDrive(
                        () -> -GamepadFunctions.getDeadZonedSensitiveValue(mainGamepad.getLeftX()),
                        () -> -GamepadFunctions.getDeadZonedSensitiveValue(mainGamepad.getLeftY()),
                        () -> -GamepadFunctions.getDeadZonedSensitiveValue(mainGamepad.getRightX())
                )
        );
        mainGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ChassisCommands.resetHeading());
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(ChassisCommands.stop());
        mainGamepad.getGamepadButton(GamepadKeys.Button.A).whileHeld(ChassisCommands.rotateToAngle(Field.getBoardAngle()));
    }

}
