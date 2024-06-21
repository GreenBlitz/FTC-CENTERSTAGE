package org.firstinspires.ftc.teamcode.utils;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.FieldConstants;
import org.firstinspires.ftc.teamcode.FieldLocation;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.vision.Vision;

public class AutoUtil {

    private static AutoUtil instance;

    private AutoUtil() {

    }

    public static AutoUtil getInstance() {
        if(instance == null) {
            instance = new AutoUtil();
        }
        return instance;
    }

    public Pose2d getAssignedYellowPose() {
        if(Robot.getInstance().getAlliance() == Alliance.RED) {
            return getRedAssignedYellowPose();
        }
        else {
            return getBlueAssignedYellowPose();
        }
    }

    private Pose2d getRedAssignedYellowPose() {
        switch (Robot.getInstance().getVision().getPropLocation()) {
            case LEFT:
                return FieldConstants.BACKDROP_RED_LEFT;
            case CENTER:
                return FieldConstants.BACKDROP_RED_CENTER;
            default:
                return FieldConstants.BACKDROP_RED_RIGHT;
        }
    }

    private Pose2d getBlueAssignedYellowPose() {
        switch (Robot.getInstance().getVision().getPropLocation()) {
            case LEFT:
                return FieldConstants.BACKDROP_BLUE_LEFT;
            case CENTER:
                return FieldConstants.BACKDROP_BLUE_CENTER;
            default:
                return FieldConstants.BACKDROP_BLUE_RIGHT;
        }
    }

    public Pose2d getAssignedPurplePos() {
        if(Robot.getInstance().getFieldLocation() == FieldLocation.FAR) {
            return getFarAssignedPurplePos();
        }
        else {
            return getCloseAssignedPurplePos();
        }
    }

    private Pose2d getFarAssignedPurplePos() {
        if(Robot.getInstance().getAlliance() == Alliance.RED) {
            switch (Robot.getInstance().getVision().getPropLocation()) {
                case LEFT:
                    return FieldConstants.FAR_RED_LEFT_POS;
                case CENTER:
                    return FieldConstants.FAR_RED_CENTER_POS;
                default:
                    return FieldConstants.FAR_RED_RIGHT_POS;
            }
        }
        else {
            switch (Robot.getInstance().getVision().getPropLocation()) {
                case LEFT:
                    return FieldConstants.FAR_BLUE_LEFT_POS;
                case CENTER:
                    return FieldConstants.FAR_BLUE_CENTER_POS;
                default:
                    return FieldConstants.FAR_BLUE_RIGHT_POS;
            }
        }
    }

    private Pose2d getCloseAssignedPurplePos() {
        if(Robot.getInstance().getAlliance() == Alliance.RED) {
            switch (Robot.getInstance().getVision().getPropLocation()) {
                case LEFT:
                    return FieldConstants.CLOSE_RED_LEFT_POS;
                case CENTER:
                    return FieldConstants.CLOSE_RED_CENTER_POS;
                default:
                    return FieldConstants.CLOSE_RED_RIGHT_POS;
            }
        }
        else {
            switch (Robot.getInstance().getVision().getPropLocation()) {
                case LEFT:
                    return FieldConstants.CLOSE_BLUE_LEFT_POS;
                case CENTER:
                    return FieldConstants.CLOSE_BLUE_CENTER_POS;
                default:
                    return FieldConstants.CLOSE_BLUE_RIGHT_POS;
            }
        }
    }

}
