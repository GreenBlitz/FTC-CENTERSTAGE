package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;

import org.firstinspires.ftc.teamcode.Robot;

public class MecanumChassis extends SubsystemBase {
    private static MecanumChassis instance;

    private final MecanumDrive mecanumDrive;

    private final RevIMU imu;

    public static MecanumChassis getInstance() {
        init();
        return instance;
    }

    public static void init() {
        if (instance == null) {
            instance = new MecanumChassis();
            instance.initIMU();
        }
    }

    private MecanumChassis() {
        mecanumDrive = new MecanumDrive(Robot.getInstance().frontLeft, Robot.getInstance().frontRight, Robot.getInstance().backLeft, Robot.getInstance().backRight);
        imu = Robot.getInstance().imu;
    }

    public void fieldCentricDrive(double strafeSpeed, double forwardSpeed, double theta) {
        mecanumDrive.driveFieldCentric(strafeSpeed, forwardSpeed, theta, imu.getRotation2d().getDegrees());
    }

    public void robotCentricDrive(double strafeSpeed, double forwardSpeed, double theta) {
        mecanumDrive.driveRobotCentric(strafeSpeed, forwardSpeed, theta);
    }

    public void resetHeading() {
        imu.reset();
    }

    public void initIMU() {
        imu.init();
    }

}
