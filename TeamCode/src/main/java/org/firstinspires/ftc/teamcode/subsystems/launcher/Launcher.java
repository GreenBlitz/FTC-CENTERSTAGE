package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Launcher extends SubsystemBase {
    private SimpleServo servo;

    public Launcher(HardwareMap hardwareMap) {
        this.servo = new SimpleServo(hardwareMap,
                LauncherConstants.SERVO_ID,
                LauncherConstants.MIN_ANGLE,
                LauncherConstants.MAX_ANGLE
        );
    }

    private double getPosition() {
        return servo.getPosition();
    }

    protected void launchPlane() {
        servo.setPosition(LauncherConstants.RELEASED_POSITION);
    }

    public boolean isFullyReleased() {
        return getPosition() == LauncherConstants.RELEASED_POSITION;
    }

    public boolean isClosed() {
        return getPosition() == LauncherConstants.CLOSED_POSITION;
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("launcher servo currentPos: ", getPosition());
        telemetry.addData("is launcher fully released: ", isFullyReleased());
        telemetry.addData("is launcher closed: ", isClosed());
    }
}