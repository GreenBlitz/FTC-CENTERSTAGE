package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.command.Command;

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


    public static void rotateByAngle(double degrees) {
        RobotHardwareMap.getInstance().servoLauncher.rotateByAngle(degrees);
    }

    public static Command resetPosition() {
        setPosition(0);
        return null;
    }

    public static Command launch() {
        setPosition(LauncherConstants.POSITION_FOR_LAUNCH);
        return null;
    }

    protected boolean isLaunched() {
        return RobotHardwareMap.getInstance().servoLauncher.getPosition() > LauncherConstants.MIN_POSITION_FOR_LAUNCH;
    }
}