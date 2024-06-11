package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotHardwareMap {

    private static RobotHardwareMap instance;


    public static void init(HardwareMap hardwareMap) {
        getInstance().initHardware(hardwareMap);
    }

    public static RobotHardwareMap getInstance() {
        if (instance == null) {
            instance = new RobotHardwareMap();
        }
        return instance;
    }


    //add hardware...

    public void initHardware(HardwareMap hardwareMap) {
        // init all hardware...
    }


}
