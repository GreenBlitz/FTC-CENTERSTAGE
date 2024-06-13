package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;

public class Claw {
    public Finger rightFinger;
    public Finger leftFinger;
    public boolean isSwitched;

    public Claw(HardwareMap hardwareMap) {
        this.rightFinger = new Finger(hardwareMap.servo.get(ClawConstants.RIGHT_SERVO_ID), ClawConstants.RIGHT_GRIPPER_OPEN, ClawConstants.RIGHT_GRIPPER_CLOSE);
        this.leftFinger = new Finger(hardwareMap.servo.get(ClawConstants.LEFT_SERVO_ID), ClawConstants.LEFT_GRIPPER_OPEN, ClawConstants.LEFT_GRIPPER_CLOSE);
        this.isSwitched = false;
    }

    public void openBothClaws() {
        rightFinger.openClaw();
        leftFinger.openClaw();
    }

    public void closeBothClaws() {
        rightFinger.closeClaw();
        leftFinger.closeClaw();
    }

    public void toggleBothClaws() {
        rightFinger.toggleClaw();
        leftFinger.toggleClaw();
    }

    public void switchClaws() {
        Finger switchFinger = rightFinger;
        rightFinger = leftFinger;
        leftFinger = switchFinger;
    }
}