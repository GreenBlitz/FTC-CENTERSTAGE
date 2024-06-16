package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.geometry.Rotation2d;

import org.firstinspires.ftc.teamcode.Robot;

import java.util.function.Supplier;

public class ChassisCommands {

    public static Command fieldCentricDrive(Supplier<Double> strafeSpeedSupplier, Supplier<Double> forwardSpeedSupplier, Supplier<Double> turnSpeedSupplier, Supplier<Rotation2d> gyroAngleSupplier) {
        return new RunCommand(
                () -> {
                    double strafeSpeed = strafeSpeedSupplier.get();
                    double forwardSpeed = forwardSpeedSupplier.get();
                    double turnSpeed = turnSpeedSupplier.get();
                    double gyroAngle = gyroAngleSupplier.get().getDegrees();
                    Robot.getInstance().getChassis().fieldCentricDrive(strafeSpeed, forwardSpeed, turnSpeed, gyroAngle);
                },
                Robot.getInstance().getChassis()
        );
    }

    public static Command stop() {
        return new InstantCommand(() -> Robot.getInstance().getChassis().stop());
    }

    public static Command resetHeading() {
        return new InstantCommand(() -> Robot.getInstance().getChassis().resetHeading(), Robot.getInstance().getChassis());
    }
}
