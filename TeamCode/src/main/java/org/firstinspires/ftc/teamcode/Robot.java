package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

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

    //add subsystems...
    private Elevator elevator;

    public void initSubsystems(HardwareMap hardwareMap) {
        // init all subsystems...
        this.elevator = new Elevator(hardwareMap);
    }

    public Elevator getElevator() {
        return elevator;
    }
}
