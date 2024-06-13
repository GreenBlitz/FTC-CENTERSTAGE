package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumChassis extends SubsystemBase {

    private final MecanumDrive mecanumDrive;

    private final RevIMU imu;

    public MecanumChassis(HardwareMap hardwareMap) {
        Motor frontLeft = new Motor(hardwareMap, ChassisConstants.FRONT_LEFT_ID);
        Motor frontRight = new Motor(hardwareMap, ChassisConstants.FRONT_RIGHT_ID);
        Motor backLeft = new Motor(hardwareMap, ChassisConstants.BACK_LEFT_ID);
        Motor backRight = new Motor(hardwareMap, ChassisConstants.BACK_RIGHT_ID);

        this.mecanumDrive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        this.imu = new RevIMU(hardwareMap);
        imu.init();
    }

    public void fieldCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        mecanumDrive.driveFieldCentric(strafeSpeed, forwardSpeed, turnSpeed, imu.getRotation2d().getDegrees());
    }

    public void robotCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        mecanumDrive.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);
    }

    public void resetHeading() {
        imu.reset();
    }

}
