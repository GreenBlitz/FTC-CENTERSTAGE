package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumChassis extends SubsystemBase {

    private final MecanumDrive mecanumDrive;

    private final RevIMU imu;

    public MecanumChassis(HardwareMap hardwareMap) {
        Motor frontLeft = getChassisMotor(hardwareMap, ChassisConstants.FRONT_LEFT_ID);
        Motor frontRight = getChassisMotor(hardwareMap, ChassisConstants.FRONT_RIGHT_ID);
        Motor backLeft = getChassisMotor(hardwareMap, ChassisConstants.BACK_LEFT_ID);
        Motor backRight = getChassisMotor(hardwareMap, ChassisConstants.BACK_RIGHT_ID);

        this.mecanumDrive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        this.imu = new RevIMU(hardwareMap);
        imu.init();
    }

    private Motor getChassisMotor(HardwareMap hardwareMap, String id) {
        Motor chassisMotor = new Motor(hardwareMap, id);
        chassisMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        return chassisMotor;
    }

    protected void fieldCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        mecanumDrive.driveFieldCentric(strafeSpeed, forwardSpeed, turnSpeed, imu.getRotation2d().getDegrees());
    }

    protected void robotCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        mecanumDrive.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);
    }

    protected void stop() {
        mecanumDrive.stop();
    }

    public void resetHeading() {
        imu.reset();
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Robot/Chassis angle degrees: ", imu.getRotation2d().getDegrees());
    }

}