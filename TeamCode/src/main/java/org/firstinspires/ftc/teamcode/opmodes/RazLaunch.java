package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;
import org.firstinspires.ftc.teamcode.subsystems.launcher.LauncherCommands;

@TeleOp(name = "Raz Launch")
public class RazLaunch extends OpMode {

    @Override
    public void init() {
        RobotHardwareMap.init(hardwareMap);

    }

    @Override
    public void loop() {

        if (gamepad1.dpad_up){
            LauncherCommands.launchCommand();
        }

        if (gamepad1.x){
            Launcher.getInstance().launch();
        }

    }
}
