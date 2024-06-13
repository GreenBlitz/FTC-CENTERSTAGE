package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.qualcomm.robotcore.hardware.Servo;

public class Finger {
    public boolean isOpen;
    private double fingerOpenPosition;
    private double fingerClosePosition;
    private Servo fingerServo;

    public Finger(Servo fingerServo, double fingerOpenPosition, double fingerClosePosition) {
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

    public void toggleClaw() {
        if (isOpen) {
            closeClaw();
        } else {
            openClaw();
        }
    }

    public void switchServo(Servo fingerServo, double fingerOpenPosition, double fingerClosePosition) {
        this.fingerServo = fingerServo;
        this.fingerOpenPosition = fingerOpenPosition;
        this.fingerClosePosition = fingerClosePosition;
    }
}
