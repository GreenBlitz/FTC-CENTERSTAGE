package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;

@TeleOp(name = "RazDrive")
public class RazDrive extends DefaultRaz {

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
    }

    @Override
    public void configureBindings() {
        Bindings.razDriveBindings(gamepad1, gamepad2);
    }
}
