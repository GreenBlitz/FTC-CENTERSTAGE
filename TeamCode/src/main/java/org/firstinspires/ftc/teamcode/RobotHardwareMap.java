package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImpl;

import org.firstinspires.ftc.teamcode.subsystems.claw.ClawConstants;

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
    public Servo rightClaw;
    public Servo leftClaw;

    public void initHardware(HardwareMap hardwareMap) {
        // init all hardware...
        rightClaw = hardwareMap.servo.get(ClawConstants.RIGHT_SERVO_ID);
        leftClaw = hardwareMap.servo.get(ClawConstants.LEFT_SERVO_ID);
    }


}
