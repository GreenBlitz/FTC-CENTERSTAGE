package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class Launcher {
    private static Launcher instance;
    boolean isLaunched = false;

    public static Launcher getInstance() {
        if (instance == null) {
            instance = new Launcher();
        }
        return instance;
    }

    protected void setPower(double power) {
        RobotHardwareMap.getInstance().servoLauncher.setPower(power);
    }

    public void launch() {
        setPower(LauncherConstants.LAUNCH_POWER);
        isLaunched = true;
    }

    protected boolean isLaunched() {
//        return RobotHardwareMap.getInstance().servoLauncher.getDistance() > LauncherConstants.MIN_DISTANCE_FOR_LAUNCH; // check tomorrow WHAT_WE_USE
    return isLaunched;
    }

//    public double getDistance() {
//        return RobotHardwareMap.getInstance().servoLauncher.getDistance(); // check tomorrow WHAT_WE_USE
//    }

    protected void stop() {
        setPower(0);
    }


}



































































