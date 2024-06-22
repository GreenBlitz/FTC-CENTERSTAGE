package org.firstinspires.ftc.teamcode.opmodes.subsystemstesters;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

@TeleOp(name = "Raz Vision Test")
public class RazVisionTest extends DefaultRaz {

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Robot.getInstance().getVision().telemetry(telemetry);
    }

    @Override
    public void configureBindings() {

    }

}
