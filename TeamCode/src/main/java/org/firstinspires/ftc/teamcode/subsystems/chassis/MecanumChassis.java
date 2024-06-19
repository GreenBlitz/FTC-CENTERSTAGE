package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumChassis extends SubsystemBase {

    private final MecanumDrive mecanumDrive;

    private final RevIMU imu;

    private final PIDController pidController;

    private ChassisSpeeds currentSpeeds;

    public MecanumChassis(HardwareMap hardwareMap) {
        Motor frontLeft = getConfiguredChassisMotor(hardwareMap, ChassisConstants.FRONT_LEFT_ID);
        Motor frontRight = getConfiguredChassisMotor(hardwareMap, ChassisConstants.FRONT_RIGHT_ID);
        Motor backLeft = getConfiguredChassisMotor(hardwareMap, ChassisConstants.BACK_LEFT_ID);
        Motor backRight = getConfiguredChassisMotor(hardwareMap, ChassisConstants.BACK_RIGHT_ID);

        this.mecanumDrive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        this.imu = new RevIMU(hardwareMap);
        this.pidController = ChassisConstants.PID_CONTROLLER;
        this.currentSpeeds = new ChassisSpeeds();
        imu.init();
    }

    private Motor getConfiguredChassisMotor(HardwareMap hardwareMap, String id) {
        Motor chassisMotor = new Motor(hardwareMap, id);
        chassisMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        return chassisMotor;
    }

    protected void setRotateSetPoint(Rotation2d angle) {
        pidController.reset();
        pidController.setSetPoint(angle.getDegrees());
    }

    protected boolean isAtAngle(Rotation2d angle) {
        return Math.abs(imu.getRotation2d().getDegrees() - angle.getDegrees()) <= ChassisConstants.ANGLE_TOLERANCE;
    }

    private void angleRelativeDrive(double strafeSpeed, double forwardSpeed, double turnSpeed, Rotation2d angle) {
        currentSpeeds = new ChassisSpeeds(strafeSpeed, forwardSpeed, turnSpeed);
        mecanumDrive.driveFieldCentric(strafeSpeed, forwardSpeed, turnSpeed, angle.getDegrees());
    }

    protected void rotateToAngle() {
        fieldCentricDrive(0, 0, pidController.calculate(imu.getRotation2d().getDegrees()));
    }

    protected void fieldCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        angleRelativeDrive(strafeSpeed, forwardSpeed, turnSpeed, imu.getRotation2d());
    }

    protected void robotCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        angleRelativeDrive(strafeSpeed, forwardSpeed, turnSpeed, new Rotation2d());
    }

    protected void stop() {
        mecanumDrive.stop();
    }

    protected void resetHeading() {
        imu.reset();
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Robot/Chassis angle degrees: ", imu.getRotation2d().getDegrees());
        telemetry.addData("Robot/Chassis x velocity: ", currentSpeeds.vxMetersPerSecond);
        telemetry.addData("Robot/Chassis y velocity: ", currentSpeeds.vyMetersPerSecond);
        telemetry.addData("Robot/Chassis omega: ", currentSpeeds.omegaRadiansPerSecond);
    }

}