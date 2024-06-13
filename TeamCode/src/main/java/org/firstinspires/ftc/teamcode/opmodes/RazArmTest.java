package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;

@TeleOp(name = "RazArm")
public class RazArmTest extends DefaultRaz {
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void configureBindings() {
        Bindings.razArmBindings(gamepad1, gamepad2);
    }
}
