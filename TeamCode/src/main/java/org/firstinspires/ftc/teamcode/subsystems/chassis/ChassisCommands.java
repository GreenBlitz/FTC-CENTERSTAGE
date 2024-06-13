package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import java.util.function.Supplier;

public class ChassisCommands {

    public static Command getFieldCentricDrive(Supplier<Double> strafeSpeedSupplier, Supplier<Double> forwardSpeedSupplier, Supplier<Double> thetaSupplier) {
        return new RunCommand(
                () -> {
                    double strafeSpeed = strafeSpeedSupplier.get();
                    double forwardSpeed = forwardSpeedSupplier.get();
                    double theta = thetaSupplier.get();
                    MecanumChassis.getInstance().fieldCentricDrive(strafeSpeed, forwardSpeed, theta);
                },
                MecanumChassis.getInstance()
        );
    }

    public static Command getResetHeading() {
        return new InstantCommand(() -> MecanumChassis.getInstance().resetHeading(), MecanumChassis.getInstance());
    }
}
