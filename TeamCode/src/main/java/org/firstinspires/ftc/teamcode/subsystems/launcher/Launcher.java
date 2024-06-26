package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Launcher extends SubsystemBase {

    private final Servo servo;

    public Launcher(HardwareMap hardwareMap) {
        this.servo = hardwareMap.servo.get(LauncherConstants.SERVO_ID);
        servo.setPosition(LauncherConstants.HELD_POSITION);
    }

    private double getPosition() {
        return servo.getPosition();
    }

    protected void launchPlane() {
        servo.setPosition(LauncherConstants.LAUNCH_POSITION);
    }

    public boolean isPlaneLaunched() {
        return getPosition() == LauncherConstants.LAUNCH_POSITION;
    }

    public boolean isPlaneHeld() {
        return getPosition() == LauncherConstants.HELD_POSITION;
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("launcher position: ", getPosition());
        telemetry.addData("Is plane launched: ", isPlaneLaunched());
        telemetry.addData("Is plane held: ", isPlaneHeld());
    }

}
