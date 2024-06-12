package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public abstract class DefaultRaz extends OpMode {

    @Override
    public final void init() {
        RobotHardwareMap.init(hardwareMap);
        configureBindings();
        initialize();
    }

    @Override
    public final void loop() {
        CommandScheduler.getInstance().run();
        execute();
    }


    public abstract void initialize();
    public abstract void execute();
    public abstract void configureBindings();


}
