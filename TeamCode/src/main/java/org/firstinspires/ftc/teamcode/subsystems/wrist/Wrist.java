package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Wrist extends SubsystemBase {

    private final Servo servo;
    private WristState currentState;
    private WristState lastState;
    private double servoOffset;

    public Wrist(HardwareMap hardwareMap) {
        this.servo = hardwareMap.servo.get(WristConstants.SERVO_HARDWARE_ID);
        this.currentState = WristState.INTAKE;
        this.lastState = currentState;
        this.servoOffset = 0;
        setPosition(1);
    }

    private void setPosition(double position) {
        servo.setPosition(position + servoOffset);
    }

    private double getPosition() {
        return servo.getPosition() - servoOffset;
    }

    protected void setState(WristState state) {
        currentState = state;
        setPosition(currentState.targetPosition);
    }

    protected WristState getCurrentState() {
        return currentState;
    }

    protected void addToOffset() {
        servoOffset += WristConstants.OFFSET_CHANGE;
        servoOffset = Math.min(WristConstants.MAX_OFFSET, servoOffset);
    }

    protected void reduceFromOffset() {
        servoOffset -= WristConstants.OFFSET_CHANGE;
        servoOffset = Math.max(WristConstants.MIN_OFFSET, servoOffset);
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Wrist current state: ", currentState);
        telemetry.addData("Wrist last state: ", lastState);
        telemetry.addData("Wrist CurrentPosition: ", getPosition());
    }

}
