package org.firstinspires.ftc.teamcode.opmodes.functionstesters;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

@TeleOp(name = "Raz Climb Test")
public class RazClimbTest extends DefaultRaz {

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void configureBindings() {
        Bindings.razClimbTest(gamepad1, gamepad2);
    }

}
