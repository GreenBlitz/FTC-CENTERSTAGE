package org.firstinspires.ftc.teamcode.subsystems.wrist;

public enum WristState {

    INTAKE(0),
    CLIMB(50),
    SCORE(100);

    public final double positionDegrees;
    WristState(double positionDegrees){
        this.positionDegrees = positionDegrees;
    }

}
