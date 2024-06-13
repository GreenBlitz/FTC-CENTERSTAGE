package org.firstinspires.ftc.teamcode.opmodes;


import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.RobotHardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;


@TeleOp(name = "Raz Launch")
public class RazLaunch extends DefaultRaz {

    @Override
    public void configureBindings() {
        //    Bindings.razLaunchBindings(gamepad1, gamepad2);
        //        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.B).whenPressed(Launcher.rotateByAngle(45));
        //        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.X).whenPressed(Launcher.launch());
        //        MAIN_GAMEPAD.getGamepadButton(GamepadKeys.Button.Y).whenPressed(Launcher.resetPosition());
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        RobotHardwareMap.getInstance().servoLauncher.rotateByAngle(1);
    }


}
