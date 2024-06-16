package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.wrist.Wrist;
import org.firstinspires.ftc.teamcode.subsystems.elevator.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.arm.Arm;

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

    private Wrist WRIST;
    private Arm arm;
    private Elevator elevator;

    public void initSubsystems(HardwareMap hardwareMap) {
        this.WRIST = new Wrist(hardwareMap);
        this.arm = new Arm(hardwareMap);
        this.elevator = new Elevator(hardwareMap);
    }

    public Wrist getWrist(){
        return WRIST;
    }

    public Arm getArm() {
        return arm;
    }

    public Elevator getElevator() {
        return elevator;
    }

}
