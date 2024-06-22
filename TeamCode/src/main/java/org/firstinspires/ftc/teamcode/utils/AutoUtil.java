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

    public static Pose2d getAssignedPurplePose() {
        if(Robot.getInstance().getFieldStartingLocation() == FieldStartingLocation.FAR) {
            return getFarAssignedPurplePose();
        }
        else {
            return getCloseAssignedPurplePose();
        }
    }

    private static Pose2d getFarAssignedPurplePose() {
        if(Robot.getInstance().getAlliance() == Alliance.RED) {
            switch (Robot.getInstance().getVision().getPropLocation()) {
                case LEFT:
                    return FieldConstants.FAR_RED_LEFT_POSE;
                case CENTER:
                    return FieldConstants.FAR_RED_CENTER_POSE;
                default:
                    return FieldConstants.FAR_RED_RIGHT_POSE;
            }
        }
        else {
            switch (Robot.getInstance().getVision().getPropLocation()) {
                case LEFT:
                    return FieldConstants.FAR_BLUE_LEFT_POSE;
                case CENTER:
                    return FieldConstants.FAR_BLUE_CENTER_POSE;
                default:
                    return FieldConstants.FAR_BLUE_RIGHT_POSE;
            }
        }
    }

    private static Pose2d getCloseAssignedPurplePose() {
        if(Robot.getInstance().getAlliance() == Alliance.RED) {
            switch (Robot.getInstance().getVision().getPropLocation()) {
                case LEFT:
                    return FieldConstants.CLOSE_RED_LEFT_POSE;
                case CENTER:
                    return FieldConstants.CLOSE_RED_CENTER_POSE;
                default:
                    return FieldConstants.CLOSE_RED_RIGHT_POSE;
            }
        }
        else {
            switch (Robot.getInstance().getVision().getPropLocation()) {
                case LEFT:
                    return FieldConstants.CLOSE_BLUE_LEFT_POSE;
                case CENTER:
                    return FieldConstants.CLOSE_BLUE_CENTER_POSE;
                default:
                    return FieldConstants.CLOSE_BLUE_RIGHT_POSE;
            }
        }
    }

    public static Pose2d getAssignedStartingPose() {
        if(Robot.getInstance().getFieldStartingLocation() == FieldStartingLocation.FAR) {
            return getFarAssignedStartingPose();
        }
        else {
            return getCloseAssignedStartingPose();
        }
    }

    private static Pose2d getFarAssignedStartingPose() {
        if (Robot.getInstance().getAlliance() == Alliance.RED) {
            return FieldConstants.FAR_RED_START;
        }
        else {
            return FieldConstants.FAR_BLUE_START;
        }
    }

    private static Pose2d getCloseAssignedStartingPose() {
        if (Robot.getInstance().getAlliance() == Alliance.RED) {
            return FieldConstants.CLOSE_RED_START;
        }
        else {
            return FieldConstants.CLOSE_BLUE_START;
        }
    }

    public static double getAllianceYModifier() {
        return Robot.getInstance().getAlliance() == Alliance.RED ? -1 : 1;
    }

}
