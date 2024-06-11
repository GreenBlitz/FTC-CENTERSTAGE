package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Mecanum {

    private final MecanumDrive mecanumDrive;

    private final RevIMU imu;

    public Mecanum(HardwareMap hardwareMap) {
        Motor fl = new Motor(hardwareMap, "fl");
        Motor fr = new Motor(hardwareMap, "fr");
        Motor bl = new Motor(hardwareMap, "bl");
        Motor br = new Motor(hardwareMap, "br");

        this.mecanumDrive = new MecanumDrive(fl, fr, bl, br);
        this.imu = new RevIMU(hardwareMap);
    }

    public void fieldCentricDrive(double x, double y, double theta) {
        mecanumDrive.driveFieldCentric(x, y, theta, imu.getRotation2d().getDegrees());
    }

    public void robotCentricDrive(double x, double y, double theta) {
        mecanumDrive.driveRobotCentric(x, y, theta);
    }

    public void resetHeading(){
        imu.reset();
    }
    public void initIMU(){
        imu.init();
    }


}
