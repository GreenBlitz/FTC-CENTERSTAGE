package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;
import org.firstinspires.ftc.teamcode.subsystems.launcher.LauncherCommands;

@TeleOp(name = "Raz Launch")
public class RazLaunch extends OpMode {

    @Override
    public void init() {
        System.out.println(new CRServo(hardwareMap, "launcher_servo").get());
        RobotHardwareMap.init(hardwareMap);
    }

    @Override
    public void loop() {
        Launcher.getInstance().launch();

        if (gamepad1.dpad_up){
            LauncherCommands.launchCommand();
        }

        if (gamepad1.cross){
            Launcher.getInstance().launch();
        }

    }
}
