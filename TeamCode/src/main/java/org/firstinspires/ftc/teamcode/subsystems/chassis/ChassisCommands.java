package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.Gamepad;

public class ChassisCommands {

    public static Command getMoveByGamepad(GamepadEx usedGamepad) {
        return new RunCommand(
                () -> {
                    double strafeSpeed = usedGamepad.getLeftX();
                    double forwardSpeed = -usedGamepad.getLeftY();
                    double theta = usedGamepad.getRightX();
                    MecanumChassis.getInstance().fieldCentricDrive(strafeSpeed, forwardSpeed, theta);
                },
                MecanumChassis.getInstance()
        );
    }

    public static Command getResetHeading() {
        return new InstantCommand(() -> MecanumChassis.getInstance().resetHeading(), MecanumChassis.getInstance());
    }
}
