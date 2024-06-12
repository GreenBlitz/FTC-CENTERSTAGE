package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.chassis.ChassisCommands;
import org.firstinspires.ftc.teamcode.subsystems.chassis.MecanumChassis;

@TeleOp(name = "Raz")
public class Raz extends OpMode {

    @Override
    public void init() {
        MecanumChassis.getInstance().setDefaultCommand(ChassisCommands.getMoveByGamepad(gamepad1));
    }

    @Override
    public void loop() {

    }
}