package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Launcher extends SubsystemBase {
    private Servo servo;

    public Launcher(HardwareMap hardwareMap) {
        servo = hardwareMap.servo.get(LauncherConstants.SERVO_ID);
    }
    public double getPosition() {
        return servo.getPosition();
    }
    public void open() {
        servo.setPosition(LauncherConstants.OPEN_POSITION);
    }
    public boolean isOpen() {
        return Math.abs(getPosition() - LauncherConstants.OPEN_POSITION) < LauncherConstants.TOLERANCE;
    }
    public boolean isClosed() {
        return Math.abs(getPosition() - LauncherConstants.CLOSED_POSITION) < LauncherConstants.TOLERANCE;
    }
    public void telemetry(Telemetry telemetry) {
        telemetry.addData("launcher servo currentPos: ", getPosition());
        telemetry.addData("is launcher open: ", isOpen());
        telemetry.addData("is launcher closed: ", isClosed());
    }
}
