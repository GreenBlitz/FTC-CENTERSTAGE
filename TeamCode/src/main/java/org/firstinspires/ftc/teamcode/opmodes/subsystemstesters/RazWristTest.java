package org.firstinspires.ftc.teamcode.opmodes.subsystemstesters;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

@TeleOp(name = "Raz Wrist Test")
public class RazWristTest extends DefaultRaz {
    
    @Override
    public void initialize() {

    }

    @Override
    public Alliance setAlliance() {
        return Alliance.RED;
    }

    @Override
    public void execute() {
        Robot.getInstance().getWrist().telemetry(telemetry);
    }

    @Override
    public void configureBindings() {
        Bindings.razWristTest(gamepad2);
    }

}
