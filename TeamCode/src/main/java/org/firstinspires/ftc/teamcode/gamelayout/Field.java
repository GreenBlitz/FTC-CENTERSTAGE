package org.firstinspires.ftc.teamcode.gamelayout;

import com.arcrobotics.ftclib.geometry.Rotation2d;
import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Info;

public class Field {

    private static final Rotation2d BOARD_ANGLE = Rotation2d.fromDegrees(90);

    public static Rotation2d getBoardAngle() {
        return Info.alliance == Alliance.RED ? BOARD_ANGLE.unaryMinus() : BOARD_ANGLE;
    }

}
