package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.command.FunctionalCommand;

public class LauncherCommands {
    public static FunctionalCommand launchCommand() {
        return new FunctionalCommand(
                () -> {},
                () -> Launcher.getInstance().launch(),
                interrupt -> {},
                () -> Launcher.getInstance().isLaunched() //todo - test
        );
    }
}
