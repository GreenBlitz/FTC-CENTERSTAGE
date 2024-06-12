package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class MecanumChassis extends SubsystemBase {
    private static MecanumChassis instance;

    private static MecanumDrive mecanumDrive;

    private static RevIMU imu;

    public static MecanumChassis getInstance() {
        init();
        return instance;
    }

    public static void init() {
        if (instance == null) {
            instance = new MecanumChassis();
            initIMU();
        }
    }

    private MecanumChassis() {
        mecanumDrive = RobotHardwareMap.getInstance().mecanumDrive;
        imu = RobotHardwareMap.getInstance().imu;
    }

    public void fieldCentricDrive(double rightSpeed, double forwardSpeed, double theta) {
        mecanumDrive.driveFieldCentric(rightSpeed, forwardSpeed, theta, imu.getRotation2d().getDegrees());
    }

    public void robotCentricDrive(double rightSpeed, double forwardSpeed, double theta) {
        mecanumDrive.driveRobotCentric(rightSpeed, forwardSpeed, theta);
    }

    public void resetHeading() {
        imu.reset();
    }

    public static void initIMU() {
        imu.init();
    }

}
