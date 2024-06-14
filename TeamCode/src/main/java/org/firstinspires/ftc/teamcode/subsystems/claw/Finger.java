package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.qualcomm.robotcore.hardware.Servo;

class Finger {

    private final double openPosition;
    private final double closePosition;
    private final Servo servo;
    private boolean isOpen;

    protected Finger(Servo fingerServo, double fingerOpenPosition, double fingerClosePosition) {
        this.servo = fingerServo;
        this.openPosition = fingerOpenPosition;
        this.closePosition = fingerClosePosition;
        isOpen = true;  // todo- remember to change it, the finger might be open, we don't know yet
    }

    protected Finger(Finger other) {
        this.servo = other.getServo();
        this.openPosition = other.getOpenPosition();
        this.closePosition = other.getClosePosition();
    }

    private void setPosition(double position) {
        servo.setPosition(position);
    }

    private Servo getServo() {
        return this.servo;
    }

    private double getOpenPosition() {
        return this.openPosition;
    }

    private double getClosePosition() {
        return this.closePosition;
    }

    protected boolean isOpen() {
        return isOpen;
    }

    protected void open() {
        setPosition(openPosition);
        isOpen = true;
    }

    protected void close() {
        setPosition(closePosition);
        isOpen = false;
    }

    protected void toggleClaw() {
        if (isOpen) {
            close();
        } else {
            open();
        }
    }
}