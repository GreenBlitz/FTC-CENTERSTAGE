package org.firstinspires.ftc.teamcode.subsystems.launcher;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;


public class Launcher extends SubsystemBase {

    private ServoEx servoLauncher;
    private static Launcher instance;


    public static Launcher getInstance() {
        if (instance == null) {
            instance = new Launcher();
        }
        return instance;
    }

    private Launcher() {
        servoLauncher = new SimpleServo(
                hardwareMap, LauncherConstants.SERVO_HARDWARE_NAME, LauncherConstants.MIN_DEGREE, LauncherConstants.MAX_DEGREE
        );
        servoLauncher.setPosition(LauncherConstants.START_POSITION_DEGREES);
    }

    @Override
    public void periodic() {
        printServoDegrees();
    }

    public void launch() {
        servoLauncher.rotateByAngle(LauncherConstants.DEGREES_FOR_LAUNCH);
    }

    public void printServoDegrees() {
        System.out.println("Degrees of Launcher Servo = " + servoLauncher.getAngle());
    }

//    public boolean isLaunched() {
//    }


}



































































