package org.firstinspires.ftc.teamcode.gamelayout;

import com.arcrobotics.ftclib.geometry.Rotation2d;
import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Robot;

public class FieldConstants {

    private static final Rotation2d BOARD_ANGLE = Rotation2d.fromDegrees(90);

    public static Rotation2d getBoardAngle() {
        return Robot.getInstance().getAlliance() == Alliance.RED ? BOARD_ANGLE.unaryMinus() : BOARD_ANGLE;
    }

}
