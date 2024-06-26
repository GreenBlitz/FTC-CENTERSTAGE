package org.firstinspires.ftc.teamcode.subsystems.arm;

public enum ArmState {

    SCORE(ArmConstants.SCORE_TICKS),
    INTAKE(ArmConstants.INTAKE_TICKS),
    CLIMB(ArmConstants.CLIMB_TICKS),
    IDLE(ArmConstants.IDLE_TICKS),
    STARTING(ArmConstants.STARTING_TICKS),
    STAND_IN_PLACE(777); // will not use number

    public final int ticks;

    ArmState(int ticks){
        this.ticks = ticks;
    }

}
