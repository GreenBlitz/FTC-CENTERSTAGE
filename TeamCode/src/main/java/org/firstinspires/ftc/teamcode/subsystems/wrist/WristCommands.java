package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.command.FunctionalCommand;
import com.arcrobotics.ftclib.command.Subsystem;

import org.firstinspires.ftc.teamcode.R;
import org.firstinspires.ftc.teamcode.Robot;

public class WristCommands {

    public static FunctionalCommand moveToStateCommand(WristState state){
        return new FunctionalCommand(
                () -> Robot.getInstance().WRIST.setState(state),
                () -> {},
                interrupt -> {},
                () -> Robot.getInstance().WRIST.isAtTargetState(state),
                Robot.getInstance().WRIST
        );
    }

}
