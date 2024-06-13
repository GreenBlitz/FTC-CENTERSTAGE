package org.firstinspires.ftc.teamcode.subsystems.arm;

public enum ArmState {

    PICK_UP(-2350),
    STARTING(0),
    STOP(187),
    SCORE(100);

    public final int ticks;

    ArmState(int angle){
        this.ticks = angle;
    }

}
