package org.firstinspires.ftc.teamcode.subsystems.elevator;

import com.arcrobotics.ftclib.controller.PIDController;

public class ElevatorConstants {

    protected static final String RIGHT_MOTOR_ID = "motor1"; // todo- figure out if motor1 is right or left
    protected static final String LEFT_MOTOR_ID = "motor2"; // todo- same for motor2

    protected static final int PICK_UP_TICKS = 0; // todo- calibrate
    protected static final int DEFAULT_SCORE_TICKS = 0; // todo- calibrate
    protected static final int CLIMB_TICKS = 0; // todo- calibrate
    protected static final int MINIMUM_TICKS = 0; // todo- calibrate
    protected static final int MAXIMUM_TICKS = 0; // todo- calibrate

    protected static final int POSITION_TOLERANCE_TICKS = 15; //todo - calibrate better
    protected static final int VELOCITY_DEADBAND_TICKS_PER_SECOND = 10; //todo - calibrate better

    protected static final double KP = 0.01; //todo - calibrate better
    protected static final double KI = 0; //todo - calibrate better
    protected static final double KD = 0; //todo - calibrate better
    protected static final PIDController PID_CONTROLLER = new PIDController(KP, KI, KD); //todo - calibrate better

}
