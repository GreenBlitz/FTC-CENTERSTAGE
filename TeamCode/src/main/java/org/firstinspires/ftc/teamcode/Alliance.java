package org.firstinspires.ftc.teamcode;

public enum Alliance {

    BLUE,
    RED;

    @Override
    public String toString() {
        if(this == Alliance.BLUE) {
            return "BLUE";
        }
        else {
            return "RED";
        }
    }

}
