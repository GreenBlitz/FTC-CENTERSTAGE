package org.firstinspires.ftc.teamcode.subsystems.arm;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm extends SubsystemBase {

    private final DcMotorEx motor;
    private final PIDController pidController;
    private ArmState currentState;

    public Arm(HardwareMap hardwareMap) {
        this.motor = hardwareMap.get(DcMotorEx.class, ArmConstants.ARM_MOTOR_ID);
        this.currentState = ArmState.STARTING;
        this.pidController = ArmConstants.PID_CONTROLLER;
        configMotor();
        configPidController();
    }

    private void configMotor() {
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    private void configPidController() {
        pidController.setTolerance(ArmConstants.POSITION_TOLERANCE_TICKS, ArmConstants.VELOCITY_DEADBAND_TICKS_PER_SECOND);
    }


    protected void setState(ArmState targetState) {
        currentState = targetState;
        updateTargetByState();
    }

    private void updateTargetByState() {
        if (currentState == ArmState.STOP) {
            pidController.setSetPoint(motor.getCurrentPosition());
        } else {
            pidController.setSetPoint(currentState.ticks);
        }
    }

    private void setPower(double power) {
        motor.setPower(power);
    }

    public boolean isAtState() {
        return pidController.atSetPoint();
    }

    @Override
    public void periodic() {
        double power = pidController.calculate(motor.getCurrentPosition());
        setPower(power);
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Current State", currentState);
        telemetry.addData("Is At State", isAtState());
        telemetry.addData("Current Position", motor.getCurrentPosition());
        telemetry.addData("Target Position", pidController.getSetPoint());
        telemetry.addData("Pid Position Error", pidController.getPositionError());
        telemetry.addData("Current Power", motor.getPower());
    }
}
