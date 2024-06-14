package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Wrist extends SubsystemBase {

    private final ServoEx servoWrist;
    private WristState currentState;

    public Wrist(HardwareMap hardwareMap){
        this.servoWrist = new SimpleServo(
                hardwareMap,
                WristConstants.SERVO_HARDWARE_NAME,
                WristConstants.MIN_DEGREE,
                WristConstants.MAX_DEGREE
        );
    }

    public void setState(WristState state){
        currentState = state;
        servoWrist.turnToAngle(currentState.positionDegrees);
    }

    public boolean isAtTargetState(WristState targetState){
        return Math.abs(targetState.positionDegrees - servoWrist.getAngle()) < WristConstants.POSITION_TOLERANCE_DEGREES;
    }

    public void stop(){
        servoWrist.turnToAngle(servoWrist.getAngle());
    }

}
