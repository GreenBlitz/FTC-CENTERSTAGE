package org.firstinspires.ftc.teamcode.opmodes.testers;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

@TeleOp(name = "Raz Arm Test")
public class RazArmTest extends DefaultRaz {
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Robot.getInstance().ARM.telemetry(telemetry);//todo - use dashboard
    }

    @Override
    public void configureBindings() {
        Bindings.razArmBindings(gamepad1, gamepad2);
    }
}
