package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist extends SubsystemBase {

    private final Servo wristServo;
    private WristState currentState;

    public Wrist(HardwareMap hardwareMap){
        this.wristServo = hardwareMap.servo.get(WristConstants.SERVO_HARDWARE_NAME);
    }

    public void setState(WristState state){
        currentState = state;
        wristServo.setPosition(currentState.targetPosition);
    }

    public boolean isAtTargetState(WristState targetState){
        return Math.abs(targetState.targetPosition - wristServo.getPosition()) < WristConstants.POSITION_TOLERANCE;
    }

    public void stop(){
        wristServo.setPosition(wristServo.getPosition());
    }

}
