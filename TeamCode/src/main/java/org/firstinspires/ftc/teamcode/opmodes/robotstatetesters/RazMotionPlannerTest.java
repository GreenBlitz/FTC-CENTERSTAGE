package org.firstinspires.ftc.teamcode.opmodes.robotstatetesters;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

@TeleOp(name = "Raz Motion Planner Test")
public class RazMotionPlannerTest extends DefaultRaz {

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        telemetry.addData("index", Robot.getInstance().getStateMotionPlanner().getRobotStateIndex());
        telemetry.addData("state", Robot.getInstance().getCurrentState());
    }

    @Override
    public void configureBindings() {
        Bindings.razMotionPlannerTest(gamepad2);
    }

}
