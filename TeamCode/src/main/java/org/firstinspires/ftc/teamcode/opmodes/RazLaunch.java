package org.firstinspires.ftc.teamcode.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;


@TeleOp(name = "Raz Launch")
public class RazLaunch extends DefaultRaz {

    @Override
    public void configureBindings() {
        Bindings.razLaunchBindings(gamepad1, gamepad2);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }


}
