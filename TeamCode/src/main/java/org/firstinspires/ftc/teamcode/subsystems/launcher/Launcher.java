package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class Launcher {
    private static Launcher instance;

    public static Launcher getInstance() {
        if (instance == null) {
            instance = new Launcher();
            resetPosition();
        }
        return instance;
    }


    protected static void setPosition(double position) {
        RobotHardwareMap.getInstance().servoLauncher.setPosition(position);
    }

    protected static void resetPosition() {
        setPosition(0);
    }

    public void launch() {
        setPosition(LauncherConstants.MAXIMUM_ANGLE);
    }

    protected boolean isLaunched() {
        return RobotHardwareMap.getInstance().servoLauncher.getAngle() > LauncherConstants.MIN_DISTANCE_FOR_LAUNCH;
    }
}



































































