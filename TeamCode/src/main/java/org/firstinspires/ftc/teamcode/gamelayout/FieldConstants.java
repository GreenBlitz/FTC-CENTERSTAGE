package org.firstinspires.ftc.teamcode.gamelayout;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Translation2d;
import com.arcrobotics.ftclib.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Robot;

public class FieldConstants {

    public static final Pose2d FAR_RED_LEFT_POSE = new Pose2d(-40, -40, Math.toRadians(135));
    public static final Pose2d FAR_RED_CENTER_POSE = new Pose2d(-35, -35, Math.toRadians(90));
    public static final Pose2d FAR_RED_RIGHT_POSE = new Pose2d(-30, -40, Math.toRadians(45));
    public static final Pose2d FAR_BLUE_LEFT_POSE = new Pose2d(-40, 40, Math.toRadians(225));
    public static final Pose2d FAR_BLUE_CENTER_POSE = new Pose2d(-35, 35, Math.toRadians(270));
    public static final Pose2d FAR_BLUE_RIGHT_POSE = new Pose2d(-30, 40, Math.toRadians(315));
    public static final Pose2d CLOSE_RED_LEFT_POSE = new Pose2d(5, -40, Math.toRadians(135));
    public static final Pose2d CLOSE_RED_CENTER_POSE = new Pose2d(10, -35, Math.toRadians(90));
    public static final Pose2d CLOSE_RED_RIGHT_POSE = new Pose2d(15, -40, Math.toRadians(45));
    public static final Pose2d CLOSE_BLUE_LEFT_POSE = new Pose2d(15, 40, Math.toRadians(315));
    public static final Pose2d CLOSE_BLUE_CENTER_POSE = new Pose2d(10, 35, Math.toRadians(270));
    public static final Pose2d CLOSE_BLUE_RIGHT_POSE = new Pose2d(5, 40, Math.toRadians(225));

    public static final Pose2d RED_LEFT_BACKDROP_POSE = new Pose2d(50, -25, Math.toRadians(180));
    public static final Pose2d RED_CENTER_BACKDROP_POSE = new Pose2d(50, -35, Math.toRadians(180));
    public static final Pose2d RED_RIGHT_BACKDROP_POSE = new Pose2d(50, -45, Math.toRadians(180));
    public static final Pose2d BLUE_LEFT_BACKDROP_POSE = new Pose2d(50, 25, Math.toRadians(180));
    public static final Pose2d BLUE_CENTER_BACKDROP_POSE = new Pose2d(50, 35, Math.toRadians(180));
    public static final Pose2d BLUE_RIGHT_BACKDROP_POSE = new Pose2d(50, 45, Math.toRadians(180));

    public static final Pose2d FAR_RED_START = new Pose2d(-35, -60, Math.toRadians(90));
    public static final Pose2d CLOSE_RED_START = new Pose2d(10, -60, Math.toRadians(90));
    public static final Pose2d FAR_BLUE_START = new Pose2d(-35, 60, Math.toRadians(270));
    public static final Pose2d CLOSE_BLUE_START = new Pose2d(10, 60, Math.toRadians(270));

    public static final Vector2d PRE_PURPLE_BLUE_CLOSE = new Translation2d(12, 48);
    public static final Vector2d PRE_PURPLE_BLUE_FAR = new Translation2d(-12, 48);
    public static final Vector2d PRE_PURPLE_RED_CLOSE = new Translation2d(12, -48);
    public static final Vector2d PRE_PURPLE_RED_FAR = new Translation2d(-12, -48);

    public static final Vector2d AFTER_PURPLE_BLUE_CLOSE = new Translation2d(12, 55);
    public static final Vector2d AFTER_PURPLE_BLUE_FAR = new Translation2d(-12, 55);
    public static final Vector2d AFTER_PURPLE_RED_CLOSE = new Translation2d(12, -55);
    public static final Vector2d AFTER_PURPLE_RED_FAR = new Translation2d(-12, -55);

    private static final Rotation2d BOARD_ANGLE = Rotation2d.fromDegrees(-90);

    public static Rotation2d getBoardAngle() {
        return Robot.getInstance().getAlliance() == Alliance.RED ? BOARD_ANGLE.unaryMinus() : BOARD_ANGLE;
    }

}
