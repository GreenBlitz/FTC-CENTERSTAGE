package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Wrist extends SubsystemBase {

    private final Servo servo;
    private WristState currentState;
    private WristState lastState;

    public Wrist(HardwareMap hardwareMap) {
        this.servo = hardwareMap.servo.get(WristConstants.SERVO_HARDWARE_ID);
        this.currentState = WristState.INTAKE;
        this.lastState = currentState;
        setPosition(1);
    }

    private void setPosition(double position) {
        servo.setPosition(position);
    }

    private double getPosition() {
        return servo.getPosition();
    }

    protected void setState(WristState state) {
        currentState = state;
        setPosition(currentState.targetPosition);
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Wrist current state: ", currentState);
        telemetry.addData("Wrist last state: ", lastState);
        telemetry.addData("Wrist CurrentPosition: ", getPosition());
    }

}
