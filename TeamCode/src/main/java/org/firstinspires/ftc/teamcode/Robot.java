package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;
import org.firstinspires.ftc.teamcode.subsystems.elevator.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.arm.Arm;
import org.firstinspires.ftc.teamcode.subsystems.chassis.MecanumChassis;

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

    private MecanumChassis chassis;
    private Arm arm;
    private Elevator elevator;
    private Launcher launcher;

    public void initSubsystems(HardwareMap hardwareMap) {
        this.chassis = new MecanumChassis(hardwareMap);
        this.arm = new Arm(hardwareMap);
        this.elevator = new Elevator(hardwareMap);
        this.launcher = new Launcher(hardwareMap);
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

    public MecanumChassis getChassis() {
        return chassis;
    }
}
