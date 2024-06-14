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
    }

    protected Finger(Finger other) {
        this.servo = other.getServo();
        this.openPosition = other.getOpenPosition();
        this.closePosition = other.getClosePosition();
    }

    private void setPosition(double position) {
        servo.setPosition(position);
    }

    protected Servo getServo() {
        return this.servo;
    }

    protected double getOpenPosition() {
        return this.openPosition;
    }

    protected double getClosePosition() {
        return this.closePosition;
    }

    protected boolean isOpen() {
        return isOpen;
    }

    protected void openClaw() {
        setPosition(openPosition);
        isOpen = true;
    }

    protected void closeClaw() {
        setPosition(closePosition);
        isOpen = false;
    }

    protected void toggleClaw() {
        if (isOpen) {
            closeClaw();
        } else {
            openClaw();
        }
    }
}