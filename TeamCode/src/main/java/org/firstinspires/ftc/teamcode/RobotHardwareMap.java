package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.wrist.WristConstants;

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
    public ServoEx servoWrist;
    public void initHardware(HardwareMap hardwareMap) {
        // init all hardware...
        servoWrist = new SimpleServo(
                hardwareMap,
                WristConstants.SERVO_HARDWARE_NAME,
                WristConstants.MIN_DEGREE,
                WristConstants.MAX_DEGREE
        );
    }


}
