package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.arm.Arm;

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

    // add subsystems...
    private Arm arm;

    public void initSubsystems(HardwareMap hardwareMap) {
        // init all subsystems...
        this.arm = new Arm(hardwareMap);
    }

    public Arm getArm() {
        return arm;
    }

}
