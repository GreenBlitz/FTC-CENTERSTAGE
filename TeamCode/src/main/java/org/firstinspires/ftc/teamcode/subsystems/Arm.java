package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class Arm extends SubsystemBase {

    private static Arm instance;

    public static Arm getInstance() {
        if (instance == null) {
            instance = new Arm();
        }
        return instance;
    }

    private final DcMotorEx motor;
    private ArmState currentState;
    private double currentOutput;

    private Arm() {
        this.motor = RobotHardwareMap.getInstance().armMotor;
        this.currentState = ArmState.STARTING;
        this.currentOutput = 0;

        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setTargetPositionTolerance(ArmConstants.POSITION_TOLERANCE_TICKS);
        motor.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, new PIDFCoefficients(ArmConstants.KP, 0.0, 0.0, 0.0));
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setState(ArmState targetState) {
        currentState = targetState;
        if (targetState == ArmState.STOP) {
            motor.setTargetPosition(motor.getCurrentPosition());
        } else {
            motor.setTargetPosition(targetState.ticks);
        }
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        currentOutput = motor.getPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION).p;
    }

    public void setPower(double power) {
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        currentOutput = power;
    }

    public boolean isAtState() {
        return Math.abs(motor.getTargetPosition() - motor.getCurrentPosition()) < ArmConstants.POSITION_TOLERANCE_TICKS;
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
