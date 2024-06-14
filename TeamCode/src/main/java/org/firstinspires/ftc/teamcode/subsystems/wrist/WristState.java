package org.firstinspires.ftc.teamcode.subsystems.wrist;

public enum WristState {

    INTAKE(WristConstants.INTAKE_POSITION),
    SCORE(WristConstants.SCORE_POSITION);

    public final double positionZeroToOne;
    WristState(double positionZeroToOne){
        this.positionZeroToOne = positionZeroToOne;
    }

}
