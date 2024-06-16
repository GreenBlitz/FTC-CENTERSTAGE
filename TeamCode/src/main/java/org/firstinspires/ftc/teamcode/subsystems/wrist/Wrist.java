package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Wrist extends SubsystemBase {

    private final Servo servo;
    private WristState targetState;

    public Wrist(HardwareMap hardwareMap){
        this.servo = hardwareMap.servo.get(WristConstants.SERVO_HARDWARE_NAME);
        this.targetState = WristState.INTAKE;
    }

    private void setPosition(double position){
        servo.setPosition(position);
    }

    private double getPosition(){
        return servo.getPosition();
    }

    protected void setState(WristState state){
        targetState = state;
        setPosition(targetState.targetPosition);
    }

    public void telemetry (Telemetry telemetry){
        telemetry.addData("Wrist TargetState: ", targetState);
        telemetry.addData("Wrist CurrentPosition: ", getPosition());
    }

}
