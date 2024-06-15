package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

@TeleOp(name = "Raz Drive Test")
public class RazDriveTest extends DefaultRaz {

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.getInstance().chassis.telemetry(telemetry);
    }

    @Override
    public void configureBindings() {
        Bindings.razDriveTestBindings(gamepad1);
    }
}
