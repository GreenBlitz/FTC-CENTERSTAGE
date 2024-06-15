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
        this.isOpen = ClawConstants.FINGER_IS_OPEN_AT_START;
    }

    private void setPosition(double position) {
        servo.setPosition(position);
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