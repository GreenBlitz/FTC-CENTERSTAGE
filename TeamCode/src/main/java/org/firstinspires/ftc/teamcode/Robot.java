package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.arm.Arm;
import org.firstinspires.ftc.teamcode.subsystems.claw.Claw;
import org.firstinspires.ftc.teamcode.subsystems.elevator.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.wrist.Wrist;
import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;
import org.firstinspires.ftc.teamcode.subsystems.chassis.MecanumChassis;

public class Robot {

    private static Robot instance;

    public static void init(HardwareMap hardwareMap) {
        getInstance().initSubsystems(hardwareMap);
    }

    public static Robot getInstance() {
        if (instance == null) {
            instance = new Robot();
        }
        return instance;
    }


    private StateMotionPlanner stateMotionPlanner;
    private RobotState currentState;
    private Arm arm;
    private MecanumChassis chassis;
    private Claw claw;
    private Elevator elevator;
    private Launcher launcher;
    private Wrist wrist;

    private void initSubsystems(HardwareMap hardwareMap) {
            this.currentState = RobotState.DRIVE;
            this.stateMotionPlanner = new StateMotionPlanner(currentState);

            this.arm = new Arm(hardwareMap);
            this.chassis = new MecanumChassis(hardwareMap);
            this.claw = new Claw(hardwareMap);
            this.elevator = new Elevator(hardwareMap);
            this.launcher = new Launcher(hardwareMap);
            this.wrist = new Wrist(hardwareMap);
    }

    public SequentialCommandGroup setState(RobotState robotState) {
        currentState = robotState;
        switch (robotState) {
            case SCORE:
                return StateCommands.scoreState();
            case INTAKE:
                return StateCommands.intakeState();
            case CLIMB:
                return StateCommands.climbState();
            case DRIVE:
            default:
                return StateCommands.driveState();
        }
    }

    public Command setLeftState() {
        return setState(stateMotionPlanner.getLeftState());
    }

    public Command setRightState() {
        return setState(stateMotionPlanner.getRightState());
    }

    public RobotState getCurrentState() {
        return currentState;
    }

    public Arm getArm() {
        return arm;
    }

    public MecanumChassis getChassis() {
        return chassis;
    }

    public Claw getClaw() {
        return claw;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public Launcher getLauncher() {
        return launcher;
    }

    public Wrist getWrist() {
        return wrist;
    }

}
