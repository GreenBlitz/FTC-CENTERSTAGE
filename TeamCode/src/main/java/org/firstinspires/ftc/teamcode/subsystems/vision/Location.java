package org.firstinspires.ftc.teamcode.subsystems.vision;

public enum Location {
    LEFT, CENTER, RIGHT,
    FAR, CLOSE;

    @Override
    public String toString() {
        if(this == Location.LEFT) {
            return "LEFT";
        }
        else if(this == Location.CENTER) {
            return "CENTER";
        }
        else if(this == Location.RIGHT) {
            return "RIGHT";
        }
        else if(this == Location.FAR) {
            return "FAR";
        }
        else {
            return "CLOSE";
        }
    }
}