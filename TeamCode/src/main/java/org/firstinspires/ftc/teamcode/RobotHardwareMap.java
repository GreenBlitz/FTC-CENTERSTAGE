package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

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
    public ServoEx servoLauncher;


    public void initHardware(HardwareMap hardwareMap) {
        // init all hardware...
       //  servoLauncher = hardwareMap.crservo.get(LauncherConstants.SERVO_HARDWARE_NAME);
        servoLauncher = new SimpleServo(hardwareMap, LauncherConstants.SERVO_HARDWARE_NAME,LauncherConstants.MINIMUM_ANGLE,LauncherConstants.MAXIMUM_ANGLE);
    }


}
