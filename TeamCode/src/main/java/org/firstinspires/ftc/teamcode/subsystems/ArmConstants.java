package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class ArmConstants {

    public static final String ARM_MOTOR_ID = "arm_motor";
    public static final int POSITION_TOLERANCE_TICKS = 15;
    public static final int VELOCITY_DEADBAND_TICKS_PER_SECOND = 10;

    private static final double KP = 1;
    private static final double KI = 0;
    private static final double KD = 0;
    private static final double KF = 0;
    protected static final PIDFCoefficients PID_COEFFICIENTS = new PIDFCoefficients(KP, KI, KD, KF);

}
