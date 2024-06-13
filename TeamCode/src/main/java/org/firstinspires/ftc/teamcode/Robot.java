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
    public MecanumChassis MECHANUM_CHASSIS;

    public void initSubsystems(HardwareMap hardwareMap) {
        // init all subsystems...
        MECHANUM_CHASSIS = new MecanumChassis(hardwareMap);
    }

}
