package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Vector2d;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

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

    public Rotation2d getRotation2d() {
        return imu.getRotation2d();
    }

    protected void fieldCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        fieldCentricDrive(strafeSpeed, forwardSpeed, turnSpeed, imu.getRotation2d().getRadians());
    }

    protected void fieldCentricDrive(double strafeSpeed, double forwardSpeed, double turnSpeed, double gyroAngle) {

        strafeSpeed = Range.clip(strafeSpeed, ChassisConstants.MIN_SPEED_POSSIBLE_VALUE, ChassisConstants.MAX_SPEED_POSSIBLE_VALUE);
        forwardSpeed = Range.clip(forwardSpeed, ChassisConstants.MIN_SPEED_POSSIBLE_VALUE, ChassisConstants.MAX_SPEED_POSSIBLE_VALUE);
        turnSpeed = Range.clip(turnSpeed, ChassisConstants.MIN_SPEED_POSSIBLE_VALUE, ChassisConstants.MAX_SPEED_POSSIBLE_VALUE);

        Vector2d input = new Vector2d(strafeSpeed, forwardSpeed);
        input = input.rotateBy(-gyroAngle);

        double theta = input.angle();

        double[] wheelSpeeds = new double[4];

        wheelSpeeds[ChassisConstants.FRONT_LEFT_INDEX] = Math.sin(theta + Math.PI / 4);;
        wheelSpeeds[ChassisConstants.FRONT_RIGHT_INDEX] = Math.sin(theta - Math.PI / 4);
        wheelSpeeds[ChassisConstants.BACK_LEFT_INDEX] = Math.sin(theta - Math.PI / 4);
        wheelSpeeds[ChassisConstants.BACK_RIGHT_INDEX] = Math.sin(theta + Math.PI / 4);

        normalize(wheelSpeeds, input.magnitude());

        wheelSpeeds[ChassisConstants.FRONT_LEFT_INDEX] += turnSpeed;
        wheelSpeeds[ChassisConstants.FRONT_RIGHT_INDEX] -= turnSpeed;
        wheelSpeeds[ChassisConstants.BACK_LEFT_INDEX] += turnSpeed;
        wheelSpeeds[ChassisConstants.BACK_RIGHT_INDEX] -= turnSpeed;

        normalize(wheelSpeeds);

        mecanumDrive.setMotorPowers(
                wheelSpeeds[ChassisConstants.FRONT_LEFT_INDEX],
                wheelSpeeds[ChassisConstants.BACK_LEFT_INDEX],
                -wheelSpeeds[ChassisConstants.BACK_RIGHT_INDEX],
                -wheelSpeeds[ChassisConstants.FRONT_RIGHT_INDEX]
        );

    }

    protected void normalize(double[] wheelSpeeds, double magnitude) {
        double maxMagnitude = Math.abs(wheelSpeeds[0]);
        for (int i = 1; i < wheelSpeeds.length; i++) {
            double temp = Math.abs(wheelSpeeds[i]);
            if (maxMagnitude < temp) {
                maxMagnitude = temp;
            }
        }
        for (int i = 0; i < wheelSpeeds.length; i++) {
            wheelSpeeds[i] = (wheelSpeeds[i] / maxMagnitude) * magnitude;
        }

    }

    protected void normalize(double[] wheelSpeeds) {
        double maxMagnitude = Math.abs(wheelSpeeds[0]);
        for (int i = 1; i < wheelSpeeds.length; i++) {
            double temp = Math.abs(wheelSpeeds[i]);
            if (maxMagnitude < temp) {
                maxMagnitude = temp;
            }
        }
        if (maxMagnitude > ChassisConstants.MAX_SPEED_POSSIBLE_VALUE) {
            for (int i = 0; i < wheelSpeeds.length; i++) {
                wheelSpeeds[i] = (wheelSpeeds[i] / maxMagnitude);
            }
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
