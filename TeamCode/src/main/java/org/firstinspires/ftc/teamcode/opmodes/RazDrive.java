package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Mecanum;

@TeleOp(name = "Raz Drive")
public class RazDrive extends OpMode {

    private Mecanum MECANUM;

    @Override
    public void init() {
        MECANUM = new Mecanum(hardwareMap);
        MECANUM.initIMU();
    }

    @Override
    public void loop() {
        double x = gamepad1.left_stick_x;
        double y = -gamepad1.left_stick_y;
        double rx = gamepad1.right_stick_x;

        if (gamepad1.dpad_up){
            MECANUM.resetHeading();
        }

        MECANUM.fieldCentricDrive(x,y,rx);
    }
}
