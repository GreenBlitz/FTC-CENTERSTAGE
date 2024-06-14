package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Claw extends SubsystemBase {

    private Finger rightFinger;
    private Finger leftFinger;

    public Claw(HardwareMap hardwareMap) {
        this.rightFinger = new Finger(hardwareMap.servo.get(ClawConstants.RIGHT_SERVO_ID), ClawConstants.RIGHT_GRIPPER_OPEN, ClawConstants.RIGHT_GRIPPER_CLOSE);
        this.leftFinger = new Finger(hardwareMap.servo.get(ClawConstants.LEFT_SERVO_ID), ClawConstants.LEFT_GRIPPER_OPEN, ClawConstants.LEFT_GRIPPER_CLOSE);
    }

    public void openBothFingers() {
        rightFinger.open();
        leftFinger.open();
    }

    public void closeBothFingers() {
        rightFinger.close();
        leftFinger.close();
    }

    public void toggleRightFinger() {
        rightFinger.toggleClaw();
    }

    public void toggleLeftFinger() {
        leftFinger.toggleClaw();
    }

    public void switchFingers() {
        Finger switchFinger = new Finger(rightFinger);
        rightFinger = leftFinger;
        leftFinger = switchFinger;
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("RightFinger isOpen?: ", rightFinger.isOpen());
        telemetry.addData("LeftFinger isOpen?: ", leftFinger.isOpen());
    }
}