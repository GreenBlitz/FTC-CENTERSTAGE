package org.firstinspires.ftc.teamcode.subsystems.vision;

import android.graphics.Canvas;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Location;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class PropProcessor implements VisionProcessor {

    private Location location;

    @Override
    public void init(int width, int height, CameraCalibration calibration) {

    }

    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {

        Mat leftZone = getLeftZoneMatrix(frame);
        Mat centerZone = getCenterZoneMatrix(frame);

        Scalar left = getAvgColor(leftZone);
        Scalar center = getAvgColor(centerZone);

        if (isPropPartOfAvgColor(left)) {
            this.location = Location.LEFT;
        }
        else if (isPropPartOfAvgColor(center)) {
            this.location = Location.CENTER;
        }
        else {
            this.location = Location.RIGHT;
        }

        leftZone.release();
        centerZone.release();

        return null;
    }

    public Mat getLeftZoneMatrix(Mat frame) {
        if (Robot.getInstance().getAlliance() == Alliance.RED) {
            return frame.submat(VisionConstant.RED_LEFT_ZONE_AREA);
        }
        else {
            return frame.submat(VisionConstant.BLUE_LEFT_ZONE_AREA);
        }
    }

    public Mat getCenterZoneMatrix(Mat frame) {
        if (Robot.getInstance().getAlliance() == Alliance.RED) {
            return frame.submat(VisionConstant.RED_CENTER_ZONE_AREA);
        }
        else {
            return frame.submat(VisionConstant.BLUE_CENTER_ZONE_AREA);
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

    public Location getLocation() {
        return location;
    }

}
