package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.motors.CRServo;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class Launcher { // todo - do CRServo
    private static Launcher instance;

    public static Launcher getInstance() {
        if (instance == null) {
            instance = new Launcher();
        }
        return instance;
    }

    private CRServo servoLauncher;

    public Launcher() {
//        CRServo servoLauncher = RobotHardwareMap.getInstance().servoLauncher;
        servoLauncher.resetEncoder();
    }

    protected void setPower(double power) {
        servoLauncher.set(power);
    }

    public void launch() {
        setPower(LauncherConstants.LAUNCH_POWER);
    }


    protected boolean isLaunched() {
        return servoLauncher.getDistance() > LauncherConstants.MIN_DISTANCE_FOR_LAUNCH; // check tomorrow WHAT_WE_USE
    }

    protected void stop() {
        servoLauncher.stop();
    }


}



































































