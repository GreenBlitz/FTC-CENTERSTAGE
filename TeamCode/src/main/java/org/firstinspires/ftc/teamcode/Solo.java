package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "Solo")
public class Solo extends CommandOpMode {

    @Override
    public void initialize() {
        hardwareMap.get(DcMotorEx.class, "bl").setPower(0.5);
    }
}
