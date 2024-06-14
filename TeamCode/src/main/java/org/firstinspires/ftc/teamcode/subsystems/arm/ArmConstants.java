package org.firstinspires.ftc.teamcode.subsystems.arm;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

class ArmConstants {

    protected static final String ARM_MOTOR_ID = "arm_motor";

    protected static final int SCORE_TICKS = 100;
    protected static final int PICK_UP_TICKS = -2350;
    protected static final int STARTING_TICKS = 0;

    protected static final int POSITION_TOLERANCE_TICKS = 15; //todo - calibrate better
    protected static final int VELOCITY_DEADBAND_TICKS_PER_SECOND = 10; //todo - calibrate better

    protected static final double KP = 0.01; //todo - calibrate better
    protected static final double KI = 0; //todo - calibrate better
    protected static final double KD = 0; //todo - calibrate better

    protected static final PIDController PID_CONTROLLER = new PIDController(KP, KI, KD); //todo - calibrate better

}
