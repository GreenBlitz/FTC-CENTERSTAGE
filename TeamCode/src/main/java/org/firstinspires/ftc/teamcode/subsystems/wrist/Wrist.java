package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Wrist extends SubsystemBase {

    private final Servo wristServo;
    private WristState currentTargetState;

    public Wrist(HardwareMap hardwareMap){
        this.wristServo = hardwareMap.servo.get(WristConstants.SERVO_HARDWARE_NAME);
        currentTargetState = WristState.INTAKE;
    }

    private void setPosition(double position){
        wristServo.setPosition(position);
    }

    private double getPosition(){
        return wristServo.getPosition();
    }

    public void setState(WristState state){
        currentTargetState = state;
        setPosition(currentTargetState.targetPosition);
    }

    public boolean isAtTargetState(WristState targetState){
        return Math.abs(targetState.targetPosition - getPosition()) < WristConstants.POSITION_TOLERANCE;
    }

    public void telemetry (Telemetry telemetry){
        telemetry.addData("Wrist isAtTargetState?:", isAtTargetState(currentTargetState));
        telemetry.addData("Wrist TargetState:", currentTargetState);
    }

}
