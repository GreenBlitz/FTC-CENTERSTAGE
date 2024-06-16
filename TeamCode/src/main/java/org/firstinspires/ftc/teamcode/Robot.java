package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.chassis.MecanumChassis;

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

    //add subsystems...
    private MecanumChassis chassis;

    public void initSubsystems(HardwareMap hardwareMap) {
        // init all subsystems...
        this.chassis = new MecanumChassis(hardwareMap);
    }

    public MecanumChassis getChassis() {
        return chassis;
    }
}
