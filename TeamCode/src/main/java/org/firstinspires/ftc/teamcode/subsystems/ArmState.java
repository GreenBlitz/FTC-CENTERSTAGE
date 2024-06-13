package org.firstinspires.ftc.teamcode.subsystems;

public enum ArmState {

    PICK_UP(-1250),
    STARTING(0),
    STOP(187),
    SCORE(500);

    public final int ticks;

    ArmState(int angle){
        this.ticks = angle;
    }

}
