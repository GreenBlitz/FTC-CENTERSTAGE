package org.firstinspires.ftc.teamcode.subsystems.elevator;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ControlMode;

public class Elevator extends SubsystemBase {

    private final DcMotor rightMotor;
    private final DcMotor leftMotor;
    private final PIDController pidController;
    private ElevatorState currentState;
    private ControlMode currentControlMode;
    private int scoreTicks;

    public Elevator(HardwareMap hardwareMap) {
        this.rightMotor = hardwareMap.dcMotor.get(ElevatorConstants.RIGHT_MOTOR_ID);
        this.leftMotor = hardwareMap.dcMotor.get(ElevatorConstants.LEFT_MOTOR_ID);
        this.pidController = ElevatorConstants.PID_CONTROLLER;
        this.scoreTicks = ElevatorConstants.DEFAULT_SCORE_TICKS;
        this.currentState = ElevatorState.PICK_UP;
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
        currentState = targetState;
        updateTargetByState();
    }

    private void updateTargetByState() {
        switch (currentState) {
            case PICK_UP:
                pidController.setSetPoint(ElevatorConstants.PICK_UP_TICKS);
                break;
            case SCORE:
                pidController.setSetPoint(scoreTicks);
                break;
            case CLIMB:
                pidController.setSetPoint(ElevatorConstants.CLIMB_TICKS);
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

    // todo - telemetry

}
