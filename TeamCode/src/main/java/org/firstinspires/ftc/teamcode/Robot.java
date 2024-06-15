package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;

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


    private Launcher launcher;

    public void initSubsystems(HardwareMap hardwareMap) {
        this.launcher = new Launcher(hardwareMap);
    }

    public Launcher getLauncher() {
        return launcher;
    }

}
