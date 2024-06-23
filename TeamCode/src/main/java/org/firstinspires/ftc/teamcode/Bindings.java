package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.gamelayout.FieldConstants;
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

    public static void teleopDuoBindings(Gamepad gamepad1, Gamepad gamepad2) {
        mainDriver(gamepad1);
        secondDriver(gamepad2);
    }

    private static void mainDriver(Gamepad gamepad) {
        mainGamepad = new GamepadWrapper(gamepad);

        // Launcher
        mainGamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(LauncherCommands.launchPlane());

        // Chassis
        mainGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ChassisCommands.resetHeading());
        mainGamepad.getGamepadButton(GamepadKeys.Button.A).whileHeld(ChassisCommands.rotateToAngle(FieldConstants.getBoardAngle()));
        Robot.getInstance().getChassis().setDefaultCommand(
                ChassisCommands.fieldCentricDrive(
                        () -> -GamepadFunctions.getDeadZonedSensitiveValue(mainGamepad.getLeftX()),
                        () -> -GamepadFunctions.getDeadZonedSensitiveValue(mainGamepad.getLeftY()),
                        () -> -GamepadFunctions.getDeadZonedSensitiveValue(mainGamepad.getRightX())
                )
        );
    }

    private static void secondDriver(Gamepad gamepad) {
        secondGamepad = new GamepadWrapper(gamepad);

        // State Change:
        secondGamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(
                Robot.getInstance().setState(() -> RobotState.SCORE));
        secondGamepad.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(
                Robot.getInstance().setState(() -> RobotState.DRIVE));
        secondGamepad.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(
                Robot.getInstance().setState(() -> RobotState.PRE_INTAKE));
        secondGamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(
                Robot.getInstance().setState(() -> RobotState.INTAKE));

        // Elevator:
        secondGamepad.getTriggerAsButton(GamepadKeys.Trigger.LEFT_TRIGGER).whenActive(
                ElevatorCommands.humanControl(() -> {
                            double triggerValue = secondGamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER);
                            return GamepadFunctions.getDeadZonedValue(triggerValue);
                        }
                )
        );
        secondGamepad.getTriggerAsButton(GamepadKeys.Trigger.RIGHT_TRIGGER).whenActive(
                ElevatorCommands.humanControl(() -> {
                            double triggerValue = -secondGamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER);
                            return GamepadFunctions.getDeadZonedValue(triggerValue);
                        }
                )
        );

        // Climb
        secondGamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(Robot.getInstance().setState(() -> RobotState.CLIMB));
        secondGamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(ArmCommands.goToState(ArmState.INTAKE));

        // Claw
        secondGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(ClawCommands.toggleRightFinger());
        secondGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(ClawCommands.toggleLeftFinger());
        secondGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(ClawCommands.openBothFingers());
        secondGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ClawCommands.closeBothFingers());

        // Emergency Wrist Calibration
        secondGamepad.getGamepadButton(GamepadKeys.Button.RIGHT_STICK_BUTTON).whenPressed(WristCommands.addToOffset());
        secondGamepad.getGamepadButton(GamepadKeys.Button.LEFT_STICK_BUTTON).whenPressed(WristCommands.reduceFromOffset());
    }


    public static void razClimbTest(Gamepad gamepad1, Gamepad gamepad2) {
        razChassisTest(gamepad1);
        secondGamepad = new GamepadWrapper(gamepad2);

        secondGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(Robot.getInstance().setState(() -> RobotState.CLIMB));
        secondGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(ArmCommands.goToState(ArmState.INTAKE));
    }

    public static void razMotionPlannerTest(Gamepad gamepad) {
        secondGamepad = new GamepadWrapper(gamepad);

        secondGamepad.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(() ->
                Robot.getInstance().setLeftState().schedule());
        secondGamepad.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(() ->
                Robot.getInstance().setRightState().schedule());
    }

    public static void razRobotStateTest(Gamepad gamepad) {
        mainGamepad = new GamepadWrapper(gamepad);

        mainGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(Robot.getInstance().setState(() -> RobotState.SCORE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(Robot.getInstance().setState(() -> RobotState.INTAKE));
        mainGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(Robot.getInstance().setState(() -> RobotState.CLIMB));
        mainGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(Robot.getInstance().setState(() -> RobotState.DRIVE));
    }

    public static void razClawTest(Gamepad gamepad) {
        mainGamepad = new GamepadWrapper(gamepad);

        mainGamepad.getGamepadButton(GamepadKeys.Button.B).whenPressed(ClawCommands.toggleRightFinger());
        mainGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(ClawCommands.toggleLeftFinger());
        mainGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(ClawCommands.openBothFingers());
        mainGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(ClawCommands.closeBothFingers());

        mainGamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(ClawCommands.lockFingers());
        mainGamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(ClawCommands.unlockFingers());
        mainGamepad.getGamepadButton(GamepadKeys.Button.RIGHT_STICK_BUTTON).whenPressed(ClawCommands.switchFingers()
        );


        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(ClawCommands.testRightFinger(0.01));
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(ClawCommands.testRightFinger(-0.01));

        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(ClawCommands.testLeftFinger(0.01));
        mainGamepad.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(ClawCommands.testLeftFinger(-0.01));
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
        mainGamepad.getGamepadButton(GamepadKeys.Button.A).whileHeld(ChassisCommands.rotateToAngle(FieldConstants.getBoardAngle()));
    }

}
