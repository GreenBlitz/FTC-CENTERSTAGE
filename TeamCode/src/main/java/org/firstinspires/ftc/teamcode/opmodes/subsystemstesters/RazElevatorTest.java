package org.firstinspires.ftc.teamcode.opmodes.subsystemstesters;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

@TeleOp(name = "Raz Elevator Test")
public class RazElevatorTest extends DefaultRaz {

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Robot.getInstance().getElevator().telemetry(telemetry);
    }

    @Override
    public void configureBindings() {
        Bindings.razElevatorTest(gamepad2);
    }

}
