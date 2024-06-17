package org.firstinspires.ftc.teamcode.subsystems.vision;

import android.graphics.Canvas;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.RobotConstants;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class ObjectProcessor implements VisionProcessor {

    private Location location;

    @Override
    public void init(int width, int height, CameraCalibration calibration) {

    }

    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {
        Rect leftZoneArea;
        Rect centerZoneArea;

        if (RobotConstants.ALLIANCE == Alliance.RED && RobotConstants.SIDE == Location.FAR || RobotConstants.ALLIANCE == Alliance.BLUE && RobotConstants.SIDE == Location.CLOSE) {
            leftZoneArea = VisionConstant.RED_LEFT_ZONE_AREA;
            centerZoneArea = VisionConstant.RED_CENTER_ZONE_AREA;
        } else {
            leftZoneArea = VisionConstant.BLUE_LEFT_ZONE_AREA;
            centerZoneArea = VisionConstant.BLUE_CENTER_ZONE_AREA;
        }

        Mat leftZone = frame.submat(leftZoneArea);
        Mat centerZone = frame.submat(centerZoneArea);

        Imgproc.blur(leftZone, leftZone, new Size(5, 5));
        Imgproc.blur(centerZone, centerZone, new Size(5, 5));

        Scalar left = Core.mean(leftZone);
        Scalar center = Core.mean(centerZone);

        double threshold = RobotConstants.ALLIANCE == Alliance.RED ? VisionConstant.RED_THRESHOLD : VisionConstant.BLUE_THRESHOLD;
        int idx = RobotConstants.ALLIANCE == Alliance.RED ? 0 : 2;

        double leftColor = left.val[idx];
        double centerColor = center.val[idx];

        if (leftColor > threshold && (left.val[0] + left.val[1] + left.val[2] - left.val[idx] < left.val[idx])) {
            this.location = Location.LEFT;
            Imgproc.rectangle(frame, leftZoneArea, new Scalar(255, 255, 255), 10);
        } else if (centerColor > threshold && (center.val[0] + center.val[1] + center.val[2] - center.val[idx] < center.val[idx])) {
            this.location = Location.CENTER;
            Imgproc.rectangle(frame, centerZoneArea, new Scalar(255, 255, 255), 10);
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
