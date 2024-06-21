package org.firstinspires.ftc.teamcode.utils;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.FieldConstants;
import org.firstinspires.ftc.teamcode.FieldStartingLocation;
import org.firstinspires.ftc.teamcode.Robot;

public class AutoUtil {

    public static Pose2d getAssignedYellowPose() {
        if(Robot.getInstance().getAlliance() == Alliance.RED) {
            return getRedAssignedYellowPose();
        }
        else {
            return getBlueAssignedYellowPose();
        }
    }

    private static Pose2d getRedAssignedYellowPose() {
        switch (Robot.getInstance().getVision().getPropLocation()) {
            case LEFT:
                return FieldConstants.BACKDROP_RED_LEFT;
            case CENTER:
                return FieldConstants.BACKDROP_RED_CENTER;
            default:
                return FieldConstants.BACKDROP_RED_RIGHT;
        }
    }

    private static Pose2d getBlueAssignedYellowPose() {
        switch (Robot.getInstance().getVision().getPropLocation()) {
            case LEFT:
                return FieldConstants.BACKDROP_BLUE_LEFT;
            case CENTER:
                return FieldConstants.BACKDROP_BLUE_CENTER;
            default:
                return FieldConstants.BACKDROP_BLUE_RIGHT;
        }
    }

    public static Pose2d getAssignedPurplePos() {
        if(Robot.getInstance().getFieldStartingLocation() == FieldStartingLocation.FAR) {
            return getFarAssignedPurplePos();
        }
        else {
            return getCloseAssignedPurplePos();
        }
    }

    private static Pose2d getFarAssignedPurplePos() {
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

    private static Pose2d getCloseAssignedPurplePos() {
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
