package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive;

public class MecanumChassis extends SubsystemBase {

    private final SampleMecanumDrive mecanumDrive;

    private final RevIMU imu;

    public MecanumChassis(HardwareMap hardwareMap) {
        this.mecanumDrive = new SampleMecanumDrive(hardwareMap);
        this.imu = new RevIMU(hardwareMap);
        imu.init();
    }

    private Motor getChassisMotor(HardwareMap hardwareMap, String id) {
        Motor chassisMotor = new Motor(hardwareMap, id);
        chassisMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        return chassisMotor;
    }

    protected void fieldCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        fieldCentricDrive(strafeSpeed, forwardSpeed, turnSpeed, imu.getRotation2d().getRadians());
    }

    protected void fieldCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed, double gyroAngle) {
        Vector2D input = clampSpeedsByAngle(strafeSpeed, forwardSpeed, gyroAngle);

        strafeSpeed = Range.clip(input.getX(), ChassisConstants.MIN_SPEED_POSSIBLE_VALUE, ChassisConstants.MAX_SPEED_POSSIBLE_VALUE);
        forwardSpeed = Range.clip(input.getY(), ChassisConstants.MIN_SPEED_POSSIBLE_VALUE, ChassisConstants.MAX_SPEED_POSSIBLE_VALUE);
        turnSpeed = Range.clip(turnSpeed, ChassisConstants.MIN_SPEED_POSSIBLE_VALUE, ChassisConstants.MAX_SPEED_POSSIBLE_VALUE);

        double[] wheelSpeeds = new double[4];

        wheelSpeeds[ChassisConstants.FRONT_LEFT_INDEX] = forwardSpeed + strafeSpeed + turnSpeed;
        wheelSpeeds[ChassisConstants.FRONT_RIGHT_INDEX] = forwardSpeed - strafeSpeed - turnSpeed;
        wheelSpeeds[ChassisConstants.BACK_LEFT_INDEX] = forwardSpeed - strafeSpeed + turnSpeed;
        wheelSpeeds[ChassisConstants.BACK_RIGHT_INDEX] = forwardSpeed + strafeSpeed - turnSpeed;

        clampOutOfRangeSpeeds(wheelSpeeds);

        mecanumDrive.setMotorPowers(
                wheelSpeeds[ChassisConstants.FRONT_LEFT_INDEX],
                wheelSpeeds[ChassisConstants.BACK_LEFT_INDEX],
                wheelSpeeds[ChassisConstants.BACK_RIGHT_INDEX],
                wheelSpeeds[ChassisConstants.FRONT_RIGHT_INDEX]
        );

    }

    private Vector2D clampSpeedsByAngle(double strafeSpeed, double forwardSpeed, double gyroAngle) {
        return new Vector2D(
                strafeSpeed * Math.cos(gyroAngle) - forwardSpeed * Math.sin(gyroAngle),
                strafeSpeed * Math.sin(gyroAngle) + forwardSpeed * Math.cos(gyroAngle)
        );
    }

    private void clampOutOfRangeSpeeds(double[] wheelSpeeds) {
        double max = ChassisConstants.MAX_SPEED_POSSIBLE_VALUE;
        for (double wheelSpeed : wheelSpeeds)
            max = Math.max(max, Math.abs(wheelSpeed));

        if (max > ChassisConstants.MAX_SPEED_POSSIBLE_VALUE) {
            for (int i = 0; i < wheelSpeeds.length; i++)
                wheelSpeeds[i] /= max;
        }
    }

    protected void stop() {
        mecanumDrive.setMotorPowers(0, 0, 0, 0);
    }

    protected void resetHeading() {
        imu.reset();
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("Robot/Chassis angle degrees: ", imu.getRotation2d().getDegrees());
    }

}
