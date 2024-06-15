package org.firstinspires.ftc.teamcode.opmodes.testers;

import org.firstinspires.ftc.teamcode.Bindings;
import org.firstinspires.ftc.teamcode.opmodes.DefaultRaz;

public class RazElevatorTest extends DefaultRaz {
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // todo - add telemetry
    }

    @Override
    public void configureBindings() {
        Bindings.razElevatorTest(gamepad1, gamepad2);
    }
}
