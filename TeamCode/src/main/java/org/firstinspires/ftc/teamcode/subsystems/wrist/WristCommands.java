package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.command.FunctionalCommand;
import com.arcrobotics.ftclib.command.Subsystem;

public class WristCommands {

    public static FunctionalCommand getMoveToPositionCommand(WristState state){
        return new FunctionalCommand(
                () -> Wrist.getInstance().setState(state),
                () -> {},
                interrupt -> Wrist.getInstance().stop(),
                () -> Wrist.getInstance().isAtTargetState(state),

        );
    }
}
