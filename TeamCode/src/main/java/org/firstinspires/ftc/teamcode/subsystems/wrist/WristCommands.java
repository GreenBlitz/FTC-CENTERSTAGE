package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.FunctionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;

public class WristCommands {

    public static Command getMoveToPositionCommand(WristState position){

        return new FunctionalCommand(
                () -> Wrist.getInstance().setState(position),
                () -> {},
                interrupt -> Wrist.getInstance().stop(),
                () -> Wrist.getInstance().isAtTargetPosition(position),
                null
        );
    }
}
