package org.firstinspires.ftc.teamcode.subsystems.wrist;

public enum WristState {

    SCORE(WristConstants.SCORE_POSITION),
    IDLE(WristConstants.IDLE_POSITION),
    INTAKE(WristConstants.INTAKE_POSITION),
    SCORE_TWO_PIXELS(WristConstants.SCORE_TWO_PIXELS_POSITION);

    public final double targetPosition;
    WristState(double targetPosition){
        this.targetPosition = targetPosition;
    }

}
