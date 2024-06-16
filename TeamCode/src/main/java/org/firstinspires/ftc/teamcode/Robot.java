package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;
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

    public void initSubsystems(HardwareMap hardwareMap) {
        this.launcher = new Launcher(hardwareMap);
        this.arm = new Arm(hardwareMap);
        this.elevator = new Elevator(hardwareMap);
    }

    private Arm arm;
    private Elevator elevator;
    private Launcher launcher;

    public Arm getArm() {
        return arm;
    }

    public Elevator getElevator() {
        return elevator;
    }
    public Launcher getLauncher() {
        return launcher;
    }

}
