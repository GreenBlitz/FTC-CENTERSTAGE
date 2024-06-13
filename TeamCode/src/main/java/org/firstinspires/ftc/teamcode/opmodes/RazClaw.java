package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.RobotHardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.claw.Claw;

@TeleOp(name = "RazClaw")
public class RazClaw extends DefaultRaz {
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        telemetry.addData("RightClawState:", Claw.getInstance().rightFinger.isOpen);
        telemetry.addData("LeftClawState:", Claw.getInstance().leftFinger.isOpen);
        telemetry.addData("IsSwitched?:", Claw.getInstance().isSwitched);
        telemetry.update();
    }

    @Override
    public void configureBindings() {
        Bindings.razClawBindings(gamepad1, gamepad2);
    }


}