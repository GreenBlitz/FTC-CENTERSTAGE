package org.firstinspires.ftc.teamcode.gamelayout;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Robot;

public class FieldConstants {

    public static final Pose2d FAR_RED_LEFT_POSE = null;
    public static final Pose2d FAR_RED_CENTER_POSE = null;
    public static final Pose2d FAR_RED_RIGHT_POSE = null;
    public static final Pose2d FAR_BLUE_LEFT_POSE = null;
    public static final Pose2d FAR_BLUE_CENTER_POSE = null;
    public static final Pose2d FAR_BLUE_RIGHT_POSE = null;
    public static final Pose2d CLOSE_RED_LEFT_POSE = null;
    public static final Pose2d CLOSE_RED_CENTER_POSE = null;
    public static final Pose2d CLOSE_RED_RIGHT_POSE = null;
    public static final Pose2d CLOSE_BLUE_LEFT_POSE = null;
    public static final Pose2d CLOSE_BLUE_CENTER_POSE = null;
    public static final Pose2d CLOSE_BLUE_RIGHT_POSE = null;

    public static final Pose2d BACKDROP_RED_LEFT_POSE = null;
    public static final Pose2d BACKDROP_RED_CENTER_POSE = null;
    public static final Pose2d BACKDROP_RED_RIGHT_POSE = null;
    public static final Pose2d BACKDROP_BLUE_LEFT_POSE = null;
    public static final Pose2d BACKDROP_BLUE_CENTER_POSE = null;
    public static final Pose2d BACKDROP_BLUE_RIGHT_POSE = null;

    private static final Rotation2d BOARD_ANGLE = Rotation2d.fromDegrees(90);

    public static Rotation2d getBoardAngle() {
        return Robot.getInstance().getAlliance() == Alliance.RED ? BOARD_ANGLE.unaryMinus() : BOARD_ANGLE;
    }

}
