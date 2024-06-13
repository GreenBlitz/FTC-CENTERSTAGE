package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.hardware.ServoEx;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class Wrist {

    private static Wrist instance;

    public static Wrist getInstance() {
        if (instance == null) {
            instance = new Wrist();
        }
        return instance;
    }

    private final ServoEx servoWrist;
    public WristState currentState;

    private Wrist(){
        servoWrist = RobotHardwareMap.getInstance().servoWrist;
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
