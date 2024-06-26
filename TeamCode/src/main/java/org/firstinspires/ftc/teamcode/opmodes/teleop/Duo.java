package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.RobotState;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

@TeleOp(name = "Duo")
public class Duo extends DefaultRaz {

    @Override
    public void initialize() {
        Robot.getInstance().getElevator().configDirections();
    }

    @Override
    public void execute() {

    }

    @Override
    public void configureBindings() {
        Bindings.teleopDuoBindings(gamepad1, gamepad2);
    }

}
