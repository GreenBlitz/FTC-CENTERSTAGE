package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.FieldStartingLocation;
import org.firstinspires.ftc.teamcode.Robot;

public abstract class DefaultGil extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Robot.getInstance().setAlliance(getAlliance());
        Robot.getInstance().setFieldStartingLocation(getFieldStartingLocation());
        Robot.init(hardwareMap);
        run();
    }

    public abstract Alliance getAlliance();
    public abstract FieldStartingLocation getFieldStartingLocation();
    public abstract void run() throws InterruptedException;

}
