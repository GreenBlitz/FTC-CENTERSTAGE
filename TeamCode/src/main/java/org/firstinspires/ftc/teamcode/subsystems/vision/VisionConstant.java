package org.firstinspires.ftc.teamcode.subsystems.vision;

import org.firstinspires.ftc.vision.VisionPortal;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;

class VisionConstant {

    protected static final String CAMERA_ID = "Webcam1";

    protected static final int CAMERA_RESOLUTION_WIDTH = 640;
    protected static final int CAMERA_RESOLUTION_HEIGHT = 480;
    protected static final int TRACKER_MIN_SIZE = 16;
    protected static final int MAX_NUM_RECOGNITIONS = 10;

    protected static final float TRACKER_MAX_OVERLAP = 0.2f;

    protected static final VisionPortal.StreamFormat STREAM_FORMAT = VisionPortal.StreamFormat.YUY2;

    protected static final double BLUE_THRESHOLD = 70;
    protected static final double RED_THRESHOLD = 100;
    protected static final double AMOUNT_OF_COLOR = 2.8;
    protected static final Rect RED_LEFT_ZONE_AREA = new Rect(0, 244, 320, 236);
    protected static final Rect RED_CENTER_ZONE_AREA = new Rect(320, 211, 320, 269);
    protected static final Rect BLUE_LEFT_ZONE_AREA = new Rect(0, 233, 320, 247);
    protected static final Rect BLUE_CENTER_ZONE_AREA = new Rect(320, 215, 320, 265);
    protected static final Size BLUR_SIZE = new Size(5, 5);
    protected static final Scalar WHITE_COLOR_RGB = new Scalar(255,255,255);
    protected static final int AREA_RECTANGLE_THICKNESS = 10;
    protected static final int RED_INDEX = 0;
    protected static final int GREEN_INDEX = 1;
    protected static final int BLUE_INDEX = 2;
}
