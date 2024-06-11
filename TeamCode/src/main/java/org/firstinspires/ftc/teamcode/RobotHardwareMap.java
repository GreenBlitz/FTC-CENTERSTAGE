package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;
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
        servoLauncher = new SimpleServo(
                hardwareMap, LauncherConstants.SERVO_HARDWARE_NAME, LauncherConstants.MIN_DEGREE, LauncherConstants.MAX_DEGREE
        );
    }


}
