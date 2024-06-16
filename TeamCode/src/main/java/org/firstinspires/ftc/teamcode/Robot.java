package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.wrist.Wrist;

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
    private Wrist WRIST;

    public void initSubsystems(HardwareMap hardwareMap) {
        // init all subsystems...
        this.WRIST = new Wrist(hardwareMap);
    }

    public Wrist getWrist(){
        return WRIST;
    }

}
