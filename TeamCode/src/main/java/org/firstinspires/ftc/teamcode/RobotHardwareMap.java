package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.launcher.LauncherConstants;

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
    public CRServo servoLauncher;
    public void initHardware(HardwareMap hardwareMap) {
        // init all hardware...
        servoLauncher  = new CRServo(hardwareMap, LauncherConstants.SERVO_HARDWARE_NAME);
    }


}
