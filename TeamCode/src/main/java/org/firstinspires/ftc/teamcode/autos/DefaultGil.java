package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.FieldStartingLocation;
import org.firstinspires.ftc.teamcode.Robot;

public abstract class DefaultGil extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Robot.getInstance().setAlliance(setAlliance());
        Robot.getInstance().setFieldStartingLocation(setFieldStartingLocation());
        run();
    }

    public abstract Alliance setAlliance();
    public abstract FieldStartingLocation setFieldStartingLocation();
    public abstract void run() throws InterruptedException;

}
