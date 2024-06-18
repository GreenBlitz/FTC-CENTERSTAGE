package org.firstinspires.ftc.teamcode.subsystems.arm;

import com.arcrobotics.ftclib.controller.PIDController;

class ArmConstants {

    protected static final String ARM_MOTOR_ID = "arm_motor";

    protected static final int SCORE_TICKS = 100;
    protected static final int INTAKE_TICKS = -2020;
    protected static final int IDLE_TICKS = -1900;
    protected static final int STARTING_TICKS = 0;

    protected static final int POSITION_TOLERANCE_TICKS = 4;
    protected static final int VELOCITY_DEADBAND_TICKS_PER_SECOND = 4;

    protected static final double KP = 0.01;
    protected static final double KI = 0;
    protected static final double KD = 0;

    protected static final PIDController PID_CONTROLLER = new PIDController(KP, KI, KD);

}
