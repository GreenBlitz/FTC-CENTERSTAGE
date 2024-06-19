package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Robot;

public abstract class DefaultRaz extends OpMode {

    @Override
    public final void init() {
        Robot.getInstance().setAlliance(setAlliance());
        Robot.init(hardwareMap);
        configureBindings();
        initialize();
    }

    @Override
    public final void loop() {
        CommandScheduler.getInstance().run();
        execute();
    }

    public abstract void initialize();
    public abstract Alliance setAlliance();
    public abstract void execute();
    public abstract void configureBindings();

}

