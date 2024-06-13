package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm extends SubsystemBase {
    private final DcMotorEx motor;
    private ArmState currentState;
    private double currentOutput;

    public Arm(HardwareMap hardwareMap) {
        this.motor = hardwareMap.get(DcMotorEx.class, ArmConstants.ARM_MOTOR_ID);
        this.currentState = ArmState.STARTING;
        this.currentOutput = 0;
        configMotor();
    }

    private void configMotor() {
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setTargetPositionTolerance(ArmConstants.POSITION_TOLERANCE_TICKS);
        motor.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, ArmConstants.PID_COEFFICIENTS);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setState(ArmState targetState) {
        currentState = targetState;
        setTargetPositionByState();

        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        currentOutput = motor.getPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION).p;
    }

    private void setTargetPositionByState() {
        if (currentState == ArmState.STOP) {
            motor.setTargetPosition(motor.getCurrentPosition());
        } else {
            motor.setTargetPosition(currentState.ticks);
        }
    }

    public void setPower(double power) {
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        currentOutput = power;
    }

    public boolean isAtState() {
        boolean isStopping = motor.getVelocity() <= ArmConstants.VELOCITY_DEADBAND_TICKS_PER_SECOND;
        boolean isAtPosition = Math.abs(motor.getTargetPosition() - motor.getCurrentPosition()) <= ArmConstants.POSITION_TOLERANCE_TICKS;
        return isAtPosition && isStopping;
    }

    @Override
    public void periodic() {
        if (motor.getMode() == DcMotor.RunMode.RUN_TO_POSITION) {
            double sign = Math.signum(motor.getTargetPosition() - motor.getCurrentPosition());
            double error = Math.abs(motor.getTargetPosition() - motor.getCurrentPosition());
            motor.setPower(sign * error * currentOutput);
        } else {
            motor.setPower(currentOutput);
        }
    }
}
