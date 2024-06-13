package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.qualcomm.robotcore.hardware.Servo;

class Finger {
    private final double fingerOpenPosition;
    private final double fingerClosePosition;
    private final Servo fingerServo;
    private boolean isOpen;

    protected Finger(Servo fingerServo, double fingerOpenPosition, double fingerClosePosition) {
        this.fingerServo = fingerServo;
        this.fingerOpenPosition = fingerOpenPosition;
        this.fingerClosePosition = fingerClosePosition;
    }

    private void setPosition(double position) {
        fingerServo.setPosition(position);
    }

    protected void openClaw() {
        setPosition(fingerOpenPosition);
        isOpen = true;
    }

    protected void closeClaw() {
        setPosition(fingerClosePosition);
        isOpen = false;
    }

    protected void toggleClaw() {
        if (isOpen) {
            closeClaw();
        } else {
            openClaw();
        }
    }

    public boolean isOpen() {
        return isOpen;
    }
}
