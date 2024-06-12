package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.RobotHardwareMap;

@TeleOp(name = "Raz")
public class Raz extends DefaultRaz {

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
