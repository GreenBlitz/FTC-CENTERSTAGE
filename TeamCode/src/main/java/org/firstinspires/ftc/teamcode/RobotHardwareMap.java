package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.ArmConstants;

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
    public DcMotorEx armMotor;

    public void initHardware(HardwareMap hardwareMap) {
        // init all hardware...
            this.armMotor = hardwareMap.get(DcMotorEx.class, ArmConstants.ARM_MOTOR_ID);
    }


}
