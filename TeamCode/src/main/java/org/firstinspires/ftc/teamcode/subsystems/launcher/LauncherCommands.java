package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot;

public class LauncherCommands {

    public static Command launchPlane() {
        return new InstantCommand(() -> Robot.getInstance().getLauncher().launchPlane(), Robot.getInstance().getLauncher());
    }

}
