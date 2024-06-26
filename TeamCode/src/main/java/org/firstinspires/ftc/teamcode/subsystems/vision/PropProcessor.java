package org.firstinspires.ftc.teamcode.subsystems.vision;

import android.graphics.Canvas;
import android.graphics.Paint;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.PropLocation;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class PropProcessor implements VisionProcessor {

    private PropLocation location;

    @Override
    public void init(int width, int height, CameraCalibration calibration) {

    }

    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {
        Mat rightZone = getRightZoneMatrix(frame);
        Mat centerZone = getCenterZoneMatrix(frame);

        Scalar avgRightColor = getAvgColor(rightZone);
        Scalar avgCenterColor = getAvgColor(centerZone);

        if (isPropPartOfAvgColor(avgRightColor)) {
            this.location = PropLocation.RIGHT;
        }
        else if (isPropPartOfAvgColor(avgCenterColor)) {
            this.location = PropLocation.CENTER;
        }
        else {
            this.location = PropLocation.LEFT;
        }

        rightZone.release();
        centerZone.release();

        return null;
    }

    public Mat getRightZoneMatrix(Mat frame) {
        if (Robot.getInstance().getAlliance() == Alliance.RED) {
            return frame.submat(VisionConstant.RED_RIGHT_ZONE);
        }
        else {
            return frame.submat(VisionConstant.BLUE_RIGHT_ZONE);
        }
    }

    public Mat getCenterZoneMatrix(Mat frame) {
        if (Robot.getInstance().getAlliance() == Alliance.RED) {
            return frame.submat(VisionConstant.RED_CENTER_ZONE);
        }
        else {
            return frame.submat(VisionConstant.BLUE_CENTER_ZONE);
        }
    }

    public Scalar getAvgColor(Mat matrix) {
        Imgproc.blur(matrix, matrix, VisionConstant.BLUR_SIZE);
        return Core.mean(matrix);
    }

    public double getAllianceColorThreshold() {
        return Robot.getInstance().getAlliance() == Alliance.RED ? VisionConstant.RED_THRESHOLD : VisionConstant.BLUE_THRESHOLD;
    }

    public boolean isPropPartOfAvgColor(Scalar color) {
        int allianceColorIndex = Robot.getInstance().getAlliance() == Alliance.RED ? VisionConstant.RED_INDEX : VisionConstant.BLUE_INDEX;
        double allianceColor = color.val[allianceColorIndex];
        boolean allianceColorPassesThreshold = allianceColor > getAllianceColorThreshold();
        double sumOfColor = color.val[VisionConstant.RED_INDEX] + color.val[VisionConstant.GREEN_INDEX] + color.val[VisionConstant.BLUE_INDEX];
        return allianceColorPassesThreshold && sumOfColor < VisionConstant.AMOUNT_OF_COLOR * allianceColor;
    }

    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {
    }

    public PropLocation getLocation() {
        return location;
    }

}
