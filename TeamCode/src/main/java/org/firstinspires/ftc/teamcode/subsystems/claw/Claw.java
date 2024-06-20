package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Claw extends SubsystemBase {

    private Finger rightFinger;
    private Finger leftFinger;
    protected boolean isUnlocked;

    public Claw(HardwareMap hardwareMap) {
        this.rightFinger = new Finger(hardwareMap.servo.get(ClawConstants.RIGHT_SERVO_ID), ClawConstants.RIGHT_GRIPPER_OPEN_POSITION, ClawConstants.RIGHT_GRIPPER_CLOSE_POSITION);
        this.leftFinger = new Finger(hardwareMap.servo.get(ClawConstants.LEFT_SERVO_ID), ClawConstants.LEFT_GRIPPER_OPEN_POSITION, ClawConstants.LEFT_GRIPPER_CLOSE_POSITION);
        isUnlocked = true;
    }

    public void openBothFingers() {
        rightFinger.open(isUnlocked);
        leftFinger.open(isUnlocked);
    }

    protected void closeBothFingers() {
        rightFinger.close(isUnlocked);
        leftFinger.close(isUnlocked);
    }

    public void toggleRightFinger() {
        rightFinger.toggleFinger(isUnlocked);
    }

    protected void toggleLeftFinger() {
        leftFinger.toggleFinger(isUnlocked);
    }

//    protected void testRightFinger(double change) {
//        rightFinger.setPosition(rightFinger.getPosition()+change);
//    }
//
//    protected void testLeftFinger(double change) {
//        leftFinger.setPosition(leftFinger.getPosition()+change);
//    }

    protected void lockFingers() {
        isUnlocked = true;
    }

    protected void unlockFingers() {
        isUnlocked = false;
    }

    protected void switchFingers() {
        Finger switchFinger = rightFinger;
        rightFinger = leftFinger;
        leftFinger = switchFinger;
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("RightFinger isOpen?: ", rightFinger.isOpen());
        telemetry.addData("LeftFinger isOpen?: ", leftFinger.isOpen());
        telemetry.addData("isLocked?: ", isUnlocked);

        telemetry.addData("RightFinger Position: ", rightFinger.getPosition());
        telemetry.addData("LeftFinger Position: ", leftFinger.getPosition());
    }

}