package org.firstinspires.ftc.teamcode.subsystems.elevator;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.systemcontrol.ControlMode;

public class Elevator extends SubsystemBase {

    private final DcMotor rightMotor;
    private final DcMotor leftMotor;
    private final PIDController pidController;
    private ElevatorState currentState;
    private ElevatorState lastState;
    private ControlMode currentControlMode;
    private int scoreTicks;

    public Elevator(HardwareMap hardwareMap) {
        this.rightMotor = hardwareMap.dcMotor.get(ElevatorConstants.RIGHT_MOTOR_ID);
        this.leftMotor = hardwareMap.dcMotor.get(ElevatorConstants.LEFT_MOTOR_ID);
        this.pidController = ElevatorConstants.PID_CONTROLLER;
        this.scoreTicks = ElevatorConstants.DEFAULT_SCORE_TICKS;
        this.currentState = ElevatorState.INTAKE;
        this.lastState = currentState;
        this.currentControlMode = ControlMode.PID_CONTROL;

        configRightMotor();
        configLeftMotor();
        configPidController();
    }

    private void configRightMotor() {
        rightMotor.resetDeviceConfigurationForOpMode();
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    private void configLeftMotor() {
        leftMotor.resetDeviceConfigurationForOpMode();
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    private void configPidController() {
        pidController.setTolerance(ElevatorConstants.POSITION_TOLERANCE_TICKS, ElevatorConstants.VELOCITY_DEADBAND_TICKS_PER_SECOND);
    }


    protected void startHumanControl() {
        currentControlMode = ControlMode.HUMAN_CONTROL;
    }

    protected void endHumanControl() {
        scoreTicks = rightMotor.getCurrentPosition();
        currentState = ElevatorState.STAND_IN_PLACE;
        currentControlMode = ControlMode.PID_CONTROL;
    }

    protected void setPower(double power) {
        rightMotor.setPower(power);
        leftMotor.setPower(power);
    }

    protected void setState(ElevatorState targetState) {
        lastState = currentState;
        currentState = targetState;
        updateTargetByState();
    }

    private void updateTargetByState() {
        switch (currentState) {
            case SCORE:
                pidController.setSetPoint(scoreTicks);
                break;
            case CLIMB:
                pidController.setSetPoint(ElevatorConstants.CLIMB_TICKS);
                break;
            case INTAKE:
                pidController.setSetPoint(ElevatorConstants.INTAKE_TICKS);
                break;
            case IDLE:
                pidController.setSetPoint(ElevatorConstants.IDLE_TICKS);
                break;
            case STAND_IN_PLACE:
                pidController.setSetPoint(rightMotor.getCurrentPosition());
                break;
        }
    }

    public boolean isAtState() {
        return pidController.atSetPoint() || currentControlMode == ControlMode.HUMAN_CONTROL;
    }

    @Override
    public void periodic() {
        if (currentControlMode == ControlMode.PID_CONTROL) {
            double power = pidController.calculate(rightMotor.getCurrentPosition());
            setPower(power);
        }
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Elevator current state: ", currentState);
        telemetry.addData("Elevator last state: ", lastState);
        telemetry.addData("Elevator control mode: ", currentControlMode);
        telemetry.addData("Elevator right motor position: ", rightMotor.getCurrentPosition());
        telemetry.addData("Elevator left motor position: ", leftMotor.getCurrentPosition());
        telemetry.addData("Elevator right motor power: ", rightMotor.getPower());
        telemetry.addData("Elevator left motor power: ", leftMotor.getPower());
        telemetry.addData("Elevator pid set point: ", pidController.getSetPoint());
        telemetry.addData("Elevator pid error: ", pidController.getPositionError());
    }

}
