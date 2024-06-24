package org.firstinspires.ftc.teamcode;

public enum PropLocation {

    LEFT(-45),
    CENTER(0),
    RIGHT(45);

    public final int angle;

    PropLocation(int angle) {
        this.angle = angle;
    }

}