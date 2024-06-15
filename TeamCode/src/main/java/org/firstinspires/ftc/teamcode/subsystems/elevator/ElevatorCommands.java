package org.firstinspires.ftc.teamcode.subsystems.elevator;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.FunctionalCommand;

import org.firstinspires.ftc.teamcode.Robot;

import java.util.function.Supplier;

public class ElevatorCommands {

    public static Command goToState(ElevatorState elevatorState) {
        return new FunctionalCommand(
                () -> Robot.getInstance().elevator.setState(elevatorState),
                () -> {},
                interrupt -> Robot.getInstance().elevator.setState(ElevatorState.STAND_IN_PLACE),
                () -> Robot.getInstance().elevator.isAtState(),
                Robot.getInstance().elevator
        );
    }

    public static Command humanControl(Supplier<Double> triggerValue) { //todo- ask herman to explain Supplier and generic object
        return new FunctionalCommand(
                () -> Robot.getInstance().elevator.startHumanControl(),
                () -> Robot.getInstance().elevator.setPower(triggerValue.get()),
                interrupt -> Robot.getInstance().elevator.endHumanControl(),
                () -> false,
                Robot.getInstance().elevator
        );
    }
}
