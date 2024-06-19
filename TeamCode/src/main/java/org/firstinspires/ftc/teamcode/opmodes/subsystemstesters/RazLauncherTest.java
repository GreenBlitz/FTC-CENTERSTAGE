package org.firstinspires.ftc.teamcode.opmodes.subsystemstesters;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Raz Launch Test")
public class RazLauncherTest extends DefaultRaz {

    @Override
    public void initialize() {

    }

    @Override
    public Alliance setAlliance() {
        return Alliance.RED;
    }

    @Override
    public void execute() {
        Robot.getInstance().getLauncher().telemetry(telemetry);
    }

    @Override
    public void configureBindings() {
        Bindings.razLauncherTest(gamepad1);
    }

}