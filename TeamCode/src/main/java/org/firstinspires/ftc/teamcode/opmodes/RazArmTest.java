package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "RazArm")
public class RazArmTest extends DefaultRaz {
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Robot.getInstance().ARM.telemetry(telemetry);
    }

    @Override
    public void configureBindings() {
        Bindings.razArmBindings(gamepad1, gamepad2);
    }
}
