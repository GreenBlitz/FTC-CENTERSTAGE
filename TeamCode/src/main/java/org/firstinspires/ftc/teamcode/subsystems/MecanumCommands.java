package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.FunctionalCommand;

import org.firstinspires.ftc.teamcode.RobotContainer;

import java.util.function.DoubleSupplier;

public class MecanumCommands {

    public static FunctionalCommand getFieldRelativeDriveCommand(DoubleSupplier xVel, DoubleSupplier yVel, DoubleSupplier theta){
        return new FunctionalCommand(
                () -> {},
                () -> RobotContainer.MECANUM.fieldCentricDrive(
                        xVel.getAsDouble(),
                        yVel.getAsDouble(),
                        theta.getAsDouble()
                ),
                interrupted -> {},
                () -> false,
                RobotContainer.MECANUM
        );
    }

}
