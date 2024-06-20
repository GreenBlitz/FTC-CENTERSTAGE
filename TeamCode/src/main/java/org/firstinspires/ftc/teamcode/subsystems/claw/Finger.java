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

    protected void setPosition(double position, boolean isLocked) {
        if (isLocked) {
            servo.setPosition(position);
            isOpen = !isOpen;
        }
    }

    protected double getPosition() {
        return servo.getPosition();
    }

    protected boolean isOpen() {
        return isOpen;
    }

    protected void open(boolean isUnlocked) {
            setPosition(openPosition, isUnlocked);
    }

    protected void close(boolean isUnlocked) {
            setPosition(closePosition, isUnlocked);
    }

    protected void toggleFinger(boolean isUnlocked) {
        if (isOpen) {
            close(isUnlocked);
        } else {
            open(isUnlocked);
        }
    }
}