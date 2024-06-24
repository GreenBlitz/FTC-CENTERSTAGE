package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.RobotState;

public abstract class DefaultRaz extends OpMode {

    @Override
    public final void init() {
        Robot.init(hardwareMap);
        Robot.getInstance().setState(RobotState.DRIVE).schedule();
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

