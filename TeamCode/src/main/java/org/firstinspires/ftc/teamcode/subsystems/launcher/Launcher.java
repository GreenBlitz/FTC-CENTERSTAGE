package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.hardware.ServoEx;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class Launcher { // todo - do CRServo
    private static Launcher instance;

    public static Launcher getInstance() {
        if (instance == null) {
            instance = new Launcher();
        }
        return instance;
    }

    private ServoEx servoLauncher;

    private Launcher() {
        ServoEx servoLauncher = RobotHardwareMap.getInstance().servoLauncher;
        servoLauncher.setPosition(LauncherConstants.START_POSITION_DEGREES);
    }

    // void launch
    // double getPos
    // boolean didLaunch

    protected void rotateByAngle(double degrees) {
        servoLauncher.rotateByAngle(degrees); // check tomorrow WHAT_WE_USE
    }

    protected void rotateToPosition(int position) {
        servoLauncher.rotateBy(position); // check tomorrow whatweuse
    }

    protected double getAngle() {
        return servoLauncher.getAngle(); // check tomorrow whatWeUse
    }

    protected void stop() {
        servoLauncher.rotateBy(0);
    }

    protected boolean isLaunched() {
        return getAngle() > LauncherConstants.MIN_DEGREES_FOR_LAUNCH;
    }

}



































































