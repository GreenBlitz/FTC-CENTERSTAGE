package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.RobotHardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;
import org.firstinspires.ftc.teamcode.subsystems.launcher.LauncherCommands;


@TeleOp(name = "Raz Launch")
public class RazLaunch extends OpMode {

    @Override
    public void init() {
        RobotHardwareMap.init(hardwareMap);
        Bindings.razLaunchBindings(gamepad1, gamepad2);
    }

    @Override
    public void loop() {
        CommandScheduler.getInstance().run();
    }
}
