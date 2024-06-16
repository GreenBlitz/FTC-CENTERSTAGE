package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.arm.Arm;
import org.firstinspires.ftc.teamcode.subsystems.claw.Claw;
import org.firstinspires.ftc.teamcode.subsystems.elevator.Elevator;

public class Robot {

    private static Robot instance;

    public static void init(HardwareMap hardwareMap) {
        getInstance().initSubsystems(hardwareMap);
    }

    public static Robot getInstance() {
        if (instance == null) {
            instance = new Robot();
        }
        return instance;
    }

    private Arm arm;
    private Elevator elevator;
    private Claw claw;

    public void initSubsystems(HardwareMap hardwareMap) {
        this.arm = new Arm(hardwareMap);
        this.elevator = new Elevator(hardwareMap);
        this.claw = new Claw(hardwareMap);
    }

    public Arm getArm() {
        return arm;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public Claw getClaw() {
        return claw;
    }
}
