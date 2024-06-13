package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

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

    public void setPosition(double position) {
        fingerServo.setPosition(position);
    }

    public void reverseClawDirection() {
        fingerServo.setDirection(Servo.Direction.REVERSE);
    }

    public void openClaw() {
        setPosition(fingerOpenPosition);
        isOpen = true;
    }

    public void closeClaw(
    ) {
        reverseClawDirection();
        setPosition(fingerClosePosition);
        isOpen = false;
    }

    public void toggleClaw() {
        if (isOpen == true) {
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
