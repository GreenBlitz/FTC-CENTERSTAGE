package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;
import org.firstinspires.ftc.teamcode.subsystems.elevator.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.arm.Arm;
import org.firstinspires.ftc.teamcode.subsystems.vision.Vision;

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


    private Arm arm;
    private Elevator elevator;
    private Launcher launcher;
    private Vision vision;

    public void initSubsystems(HardwareMap hardwareMap) {
        this.arm = new Arm(hardwareMap);
        this.elevator = new Elevator(hardwareMap);
        this.launcher = new Launcher(hardwareMap);
        this.vision = new Vision(hardwareMap);
    }


    public Arm getArm() {
        return arm;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public Launcher getLauncher() {
        return launcher;
    }
    public Vision getVision() {
        return vision;
    }

}
