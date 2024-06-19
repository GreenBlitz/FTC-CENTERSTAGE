package org.firstinspires.ftc.teamcode.opmodes.robotstatetesters;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

@TeleOp(name = "Raz Robot State Test")
public class RazRobotStateTest extends DefaultRaz {

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        telemetry.addData("Current Robot State: ", Robot.getInstance().getCurrentState());
    }

    @Override
    public void configureBindings() {
        Bindings.razRobotStateTest(gamepad1);
    }

}
