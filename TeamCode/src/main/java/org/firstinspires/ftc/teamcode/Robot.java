package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.chassis.ChassisConstants;

public class Robot {

    private static Robot instance;

    public static void init(HardwareMap hardwareMap) {
        getInstance().initSubsystems(hardwareMap);
    }

    public static Robot getInstance() {
        if (instance == null) {
            instance = new Robot();
        }
        return instance;
    }

    //add subsystems...
    public RevIMU imu;
    public Motor frontLeft;
    public Motor frontRight;
    public Motor backLeft;
    public Motor backRight;

    public void initSubsystems(HardwareMap hardwareMap) {
        // init all subsystems...
        frontLeft = new Motor(hardwareMap, ChassisConstants.FRONT_LEFT_ID);
        frontRight = new Motor(hardwareMap, ChassisConstants.FRONT_RIGHT_ID);
        backLeft = new Motor(hardwareMap, ChassisConstants.BACK_LEFT_ID);
        backRight = new Motor(hardwareMap, ChassisConstants.BACK_RIGHT_ID);
        this.imu = new RevIMU(hardwareMap);
    }

}
