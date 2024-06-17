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

    private ChassisSpeeds a;

    public MecanumChassis(HardwareMap hardwareMap) {
        a = new ChassisSpeeds();
        Motor frontLeft = getConfiguredChassisMotor(hardwareMap, ChassisConstants.FRONT_LEFT_ID);
        Motor frontRight = getConfiguredChassisMotor(hardwareMap, ChassisConstants.FRONT_RIGHT_ID);
        Motor backLeft = getConfiguredChassisMotor(hardwareMap, ChassisConstants.BACK_LEFT_ID);
        Motor backRight = getConfiguredChassisMotor(hardwareMap, ChassisConstants.BACK_RIGHT_ID);

        this.mecanumDrive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        this.imu = new RevIMU(hardwareMap);
        this.pidController = new PIDController(0.01, 0, 0);
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

    protected void rotateToAngle() {
        fieldCentricDrive(0, 0, pidController.calculate(imu.getRotation2d().getDegrees()));
    }

    protected boolean isAtAngle(Rotation2d angle){
        return Math.abs(imu.getRotation2d().getDegrees() - angle.getDegrees()) <= 10;
    }

    protected void fieldCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        a = new ChassisSpeeds(strafeSpeed, forwardSpeed, turnSpeed);
        mecanumDrive.driveFieldCentric(strafeSpeed, forwardSpeed, turnSpeed, imu.getRotation2d().getDegrees());
    }

    protected void robotCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        mecanumDrive.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);
    }

    protected void stop() {
        mecanumDrive.stop();
    }

    protected void resetHeading() {
        imu.reset();
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Robot/Chassis angle degrees: ", imu.getRotation2d().getDegrees());
        telemetry.addData("Robot/Chassis angle vel: ", a.omegaRadiansPerSecond);
    }

}