package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;

@TeleOp(name = "Raz Drive")
public class RazDrive extends OpMode {

    @Override
    public void init() {
        Bindings.razBindings(new GamepadEx(gamepad1));
    }

    @Override
    public void loop() {

    }
}
