package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public abstract class DefaultRaz extends OpMode {
    @Override
    public void init() {
        RobotHardwareMap.init(hardwareMap);
        configureBindings();
    }

    @Override
    public void loop() {
        CommandScheduler.getInstance().run();
    }

    public abstract void configureBindings();
}
