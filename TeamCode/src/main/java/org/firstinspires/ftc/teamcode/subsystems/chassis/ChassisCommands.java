package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;

import org.firstinspires.ftc.teamcode.Robot;

import java.util.function.Supplier;

public class ChassisCommands {

    public static Command getFieldCentricDrive(Supplier<Double> strafeSpeedSupplier, Supplier<Double> forwardSpeedSupplier, Supplier<Double> turnSpeedSupplier) {
        return new RunCommand(
                () -> {
                    double strafeSpeed = strafeSpeedSupplier.get();
                    double forwardSpeed = forwardSpeedSupplier.get();
                    double turnSpeed = turnSpeedSupplier.get();
                    Robot.getInstance().chassis.fieldCentricDrive(strafeSpeed, forwardSpeed, turnSpeed);
                },
                Robot.getInstance().chassis
        );
    }

    public static Command getResetHeading() {
        return new InstantCommand(() -> Robot.getInstance().chassis.resetHeading(), Robot.getInstance().chassis);
    }
}
