package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

@TeleOp(name = "Raz")
public class Raz extends OpMode {

    @Override
    public void init() {
        RobotHardwareMap.init(hardwareMap);
    }

    @Override
    public void loop() {
        CommandScheduler.getInstance().run();
    }
}
