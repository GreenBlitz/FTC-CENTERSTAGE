package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.FunctionalCommand;
import org.firstinspires.ftc.teamcode.Robot;

public class LauncherCommands {

    public static Command openLauncher() {
        return new FunctionalCommand(
                () -> Robot.getInstance().launcher.open(),
                () -> {},
                interrupt -> {},
                () -> Robot.getInstance().launcher.isOpen(),
                Robot.getInstance().launcher
        );
    }
}
