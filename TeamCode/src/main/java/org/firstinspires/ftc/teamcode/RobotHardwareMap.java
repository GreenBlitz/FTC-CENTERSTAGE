package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.chassis.ChassisConstants;

public class RobotHardwareMap {

    private static RobotHardwareMap instance;


    public static void init(HardwareMap hardwareMap) {
        getInstance().initHardware(hardwareMap);
    }

    public static RobotHardwareMap getInstance() {
        if (instance == null) {
            instance = new RobotHardwareMap();
        }
        return instance;
    }


    //add hardware...
    public MecanumDrive mecanumDrive;
    public RevIMU imu;

    public void initHardware(HardwareMap hardwareMap) {
        // init all hardware...
        Motor frontLeft = new Motor(hardwareMap, ChassisConstants.FRONT_LEFT_ID);
        Motor frontRight = new Motor(hardwareMap, ChassisConstants.FRONT_RIGHT_ID);
        Motor backLeft = new Motor(hardwareMap, ChassisConstants.BACK_LEFT_ID);
        Motor backRight = new Motor(hardwareMap, ChassisConstants.BACK_RIGHT_ID);

        this.mecanumDrive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        this.imu = new RevIMU(hardwareMap);
    }


}