package org.firstinspires.ftc.teamcode.opmodes.testers;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Raz Launch")
public class RazLauncherTest extends DefaultRaz {
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Robot.getInstance().getLauncher().telemetry(telemetry);
    }

    @Override
    public void configureBindings() {
        Bindings.razLauncherTestBindings(gamepad1,gamepad2);
    }
}