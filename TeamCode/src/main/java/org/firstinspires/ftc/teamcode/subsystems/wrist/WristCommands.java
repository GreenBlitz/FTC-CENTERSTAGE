package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Robot;

public class WristCommands {

    public static Command moveToState(WristState state){
        return new InstantCommand(() -> Robot.getInstance().getWrist().setState(state), Robot.getInstance().getWrist());
    }

    public static Command addToOffset() {
        return new SequentialCommandGroup(
                new InstantCommand(() -> Robot.getInstance().getWrist().addToOffset(), Robot.getInstance().getWrist()),
                moveToState(Robot.getInstance().getWrist().getCurrentState())
        );
    }

    public static Command reduceFromOffset() {
        return new SequentialCommandGroup(
                new InstantCommand(() -> Robot.getInstance().getWrist().reduceFromOffset(), Robot.getInstance().getWrist()),
                moveToState(Robot.getInstance().getWrist().getCurrentState())
        );
    }

}
