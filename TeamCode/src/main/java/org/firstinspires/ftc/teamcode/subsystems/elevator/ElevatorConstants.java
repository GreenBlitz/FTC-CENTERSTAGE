package org.firstinspires.ftc.teamcode.subsystems.elevator;

import com.arcrobotics.ftclib.controller.PIDController;

class ElevatorConstants {

    protected static final String RIGHT_MOTOR_ID = "motor2";
    protected static final String LEFT_MOTOR_ID = "motor1";

    protected static final int DEFAULT_SCORE_TICKS = 100;
    protected static final int CLIMB_TICKS = 2000;
    protected static final int INTAKE_TICKS = 0;

    protected static final int POSITION_TOLERANCE_TICKS = 4;
    protected static final int VELOCITY_DEADBAND_TICKS_PER_SECOND = 4;

    protected static final double KP = 0.05;
    protected static final double KI = 0;
    protected static final double KD = 0;
    protected static final PIDController PID_CONTROLLER = new PIDController(KP, KI, KD);

}
