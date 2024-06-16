package org.firstinspires.ftc.teamcode.subsystems.wrist;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot;

public class WristCommands {

    public static InstantCommand moveToState(WristState state){
        return new InstantCommand(() -> Robot.getInstance().getWrist().setState(state), Robot.getInstance().getWrist());
    }

}
