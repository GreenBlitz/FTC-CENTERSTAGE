package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot;

public class Claw {

    private Finger rightFinger;
    private Finger leftFinger;

    public Claw(HardwareMap hardwareMap) {
        this.rightFinger = new Finger(hardwareMap.servo.get(ClawConstants.RIGHT_SERVO_ID), ClawConstants.RIGHT_GRIPPER_OPEN, ClawConstants.RIGHT_GRIPPER_CLOSE);
        this.leftFinger = new Finger(hardwareMap.servo.get(ClawConstants.LEFT_SERVO_ID), ClawConstants.LEFT_GRIPPER_OPEN, ClawConstants.LEFT_GRIPPER_CLOSE);
    }

    public void openBothClaws() {
        rightFinger.openClaw();
        leftFinger.openClaw();
    }

    public void closeBothClaws() {
        rightFinger.closeClaw();
        leftFinger.closeClaw();
    }

    public void toggleRightClaw() {
        rightFinger.toggleClaw();
    }

    public void toggleLeftClaw() {
        leftFinger.toggleClaw();
    }

    public void switchClaws() {
        Finger switchFinger = rightFinger;
        rightFinger = leftFinger;
        leftFinger = switchFinger;
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("RightClaw isOpen?:", rightFinger.isOpen());
        telemetry.addData("LeftClaw isOpen?:", leftFinger.isOpen());
    }
}