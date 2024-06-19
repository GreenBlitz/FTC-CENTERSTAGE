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
        Rect leftZoneArea;
        Rect centerZoneArea;

        if (Robot.getInstance().getAlliance() == Alliance.RED) {
            leftZoneArea = VisionConstant.RED_LEFT_ZONE_AREA;
            centerZoneArea = VisionConstant.RED_CENTER_ZONE_AREA;
        } else {
            leftZoneArea = VisionConstant.BLUE_LEFT_ZONE_AREA;
            centerZoneArea = VisionConstant.BLUE_CENTER_ZONE_AREA;
        }

        Mat leftZone = frame.submat(leftZoneArea);
        Mat centerZone = frame.submat(centerZoneArea);

        Imgproc.blur(leftZone, leftZone, VisionConstant.BLUR_SIZE);
        Imgproc.blur(centerZone, centerZone, VisionConstant.BLUR_SIZE);

        Scalar left = Core.mean(leftZone);
        Scalar center = Core.mean(centerZone);

        double threshold = Robot.getInstance().getAlliance() == Alliance.RED ? VisionConstant.RED_THRESHOLD : VisionConstant.BLUE_THRESHOLD;
        int idx = Robot.getInstance().getAlliance() == Alliance.RED ? VisionConstant.RED_INDEX : VisionConstant.BLUE_INDEX;

        double leftColor = left.val[idx];
        double centerColor = center.val[idx];


        if (leftColor > threshold && (left.val[VisionConstant.RED_INDEX] + left.val[VisionConstant.GREEN_INDEX] + left.val[VisionConstant.BLUE_INDEX] < VisionConstant.AMOUNT_OF_COLOR * left.val[idx])) {
            this.location = Location.LEFT;
            Imgproc.rectangle(frame, leftZoneArea, VisionConstant.WHITE_COLOR_RGB, VisionConstant.AREA_RECTANGLE_THICKNESS);
        } else if (centerColor > threshold && (center.val[VisionConstant.RED_INDEX] + center.val[VisionConstant.GREEN_INDEX] + center.val[VisionConstant.BLUE_INDEX] < VisionConstant.AMOUNT_OF_COLOR * center.val[idx])) {
            this.location = Location.CENTER;
            Imgproc.rectangle(frame, centerZoneArea, VisionConstant.WHITE_COLOR_RGB, VisionConstant.AREA_RECTANGLE_THICKNESS);
        } else {
            this.location = Location.RIGHT;
        }

        leftZone.release();
        centerZone.release();

        return null;
    }

    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {

    }

    public Location getLocation() {
        return location;
    }

}
