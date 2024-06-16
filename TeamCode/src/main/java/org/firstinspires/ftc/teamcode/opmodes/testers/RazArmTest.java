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
        Robot.getInstance().getArm().telemetry(telemetry);
    }

    @Override
    public void configureBindings() {
        Bindings.razArmTest(gamepad1, gamepad2);
    }

}
