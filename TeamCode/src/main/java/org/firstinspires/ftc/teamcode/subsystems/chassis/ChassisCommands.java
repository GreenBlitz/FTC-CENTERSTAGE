package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.RunCommand;
import com.qualcomm.robotcore.hardware.Gamepad;

public class ChassisCommands {

    public static Command getMoveByGamepad(Gamepad usedGamepad) {
        double rightSpeed = usedGamepad.left_stick_x;
        double forwardSpeed = -usedGamepad.left_stick_y;
        double theta = usedGamepad.right_stick_x;

        return new RunCommand( () -> {
            if (usedGamepad.dpad_up) {
                MecanumChassis.getInstance().resetHeading();
            }

            MecanumChassis.getInstance().fieldCentricDrive(rightSpeed, forwardSpeed, theta);
        });
    }
}
