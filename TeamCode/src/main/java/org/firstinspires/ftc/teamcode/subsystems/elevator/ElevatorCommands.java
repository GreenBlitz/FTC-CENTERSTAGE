package org.firstinspires.ftc.teamcode.subsystems.elevator;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.FunctionalCommand;

import org.firstinspires.ftc.teamcode.Robot;

import java.util.function.Supplier;

public class ElevatorCommands {

    public static Command goToState(ElevatorState elevatorState) {
        return new FunctionalCommand(
                () -> Robot.getInstance().getElevator().setState(elevatorState),
                () -> {},
                interrupt -> Robot.getInstance().getElevator().setState(ElevatorState.STAND_IN_PLACE),
                () -> Robot.getInstance().getElevator().isAtState(),
                Robot.getInstance().getElevator()
        );
    }

    public static Command humanControl(Supplier<Double> triggerValue) {
        return new FunctionalCommand(
                () -> Robot.getInstance().getElevator().startHumanControl(),
                () -> Robot.getInstance().getElevator().setPower(triggerValue.get()),
                interrupt -> Robot.getInstance().getElevator().endHumanControl(),
                () -> false,
                Robot.getInstance().getElevator()
        );
    }

}
