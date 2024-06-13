package org.firstinspires.ftc.teamcode.subsystems.claw;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class Claw {
    private static Claw instance;
    public boolean isSwitched = false;

    public static Claw getInstance() {
        if (instance == null) {
            instance = new Claw();
        }
        return instance;
    }

    public Finger rightFinger = new Finger(RobotHardwareMap.getInstance().rightClaw, ClawConstants.RIGHT_GRIPPER_OPEN, ClawConstants.RIGHT_GRIPPER_CLOSE);
    public Finger leftFinger = new Finger(RobotHardwareMap.getInstance().leftClaw, ClawConstants.LEFT_GRIPPER_OPEN, ClawConstants.LEFT_GRIPPER_CLOSE);


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
        if (isSwitched == false){
            rightFinger.switchServo(RobotHardwareMap.getInstance().leftClaw, ClawConstants.LEFT_GRIPPER_OPEN, ClawConstants.LEFT_GRIPPER_CLOSE);
            leftFinger.switchServo(RobotHardwareMap.getInstance().rightClaw, ClawConstants.RIGHT_GRIPPER_OPEN, ClawConstants.RIGHT_GRIPPER_CLOSE);
            isSwitched = true;
        } else if(isSwitched == true) {
            rightFinger.switchServo(RobotHardwareMap.getInstance().rightClaw, ClawConstants.RIGHT_GRIPPER_OPEN, ClawConstants.RIGHT_GRIPPER_CLOSE);
            leftFinger.switchServo(RobotHardwareMap.getInstance().leftClaw, ClawConstants.LEFT_GRIPPER_OPEN, ClawConstants.LEFT_GRIPPER_CLOSE);
            isSwitched = false;
        }
    }
}