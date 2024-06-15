package org.firstinspires.ftc.teamcode.opmodes;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.Robot;

public class RazLauncherTest extends DefaultRaz {
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Robot.getInstance().launcher.telemetry(telemetry);
    }

    @Override
    public void configureBindings() {
        Bindings.razLauncherTestBindings(gamepad1,gamepad2);
    }
}