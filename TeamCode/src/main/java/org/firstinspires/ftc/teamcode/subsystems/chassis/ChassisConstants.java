package org.firstinspires.ftc.teamcode.subsystems.chassis;

import com.arcrobotics.ftclib.controller.PIDController;

public class ChassisConstants {

    public static final String FRONT_LEFT_ID = "fl";
    public static final String FRONT_RIGHT_ID = "fr";
    public static final String BACK_LEFT_ID = "bl";
    public static final String BACK_RIGHT_ID = "br";

    protected static final double ANGLE_TOLERANCE = 5;
    protected static final PIDController PID_CONTROLLER = new PIDController(0.01, 0, 0);

}
