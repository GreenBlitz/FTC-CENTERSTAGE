package org.firstinspires.ftc.teamcode.opmodes.testers;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

@TeleOp(name = "Wrist Test")
public class WristTest extends DefaultRaz {
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void configureBindings() {
        Bindings.wristBindings(gamepad1, gamepad2);
    }

}
