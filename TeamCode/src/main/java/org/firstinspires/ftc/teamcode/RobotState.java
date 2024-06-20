package org.firstinspires.ftc.teamcode;

public enum RobotState {

    CLIMB(3),
    SCORE(2),
    DRIVE(1),
    INTAKE(0);

    public final int index;

    RobotState(int index) {
        this.index = index;
    }

}
