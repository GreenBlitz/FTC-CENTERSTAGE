package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class Launcher {
    private static Launcher instance;

    public static Launcher getInstance() {
        if (instance == null) {
            instance = new Launcher();
        }
        return instance;
    }

    protected void setPower(double power) {
        RobotHardwareMap.getInstance().servoLauncher.set(power);
    }

    public void launch() {
        setPower(LauncherConstants.LAUNCH_POWER);
    }

    protected boolean isLaunched() {
        return RobotHardwareMap.getInstance().servoLauncher.atTargetPosition();

    }

    public double getDistance() {
        return RobotHardwareMap.getInstance().servoLauncher.getDistance(); // check tomorrow WHAT_WE_USE
    }

    protected void stop() {
        RobotHardwareMap.getInstance().servoLauncher.stop();
    }


}



































































