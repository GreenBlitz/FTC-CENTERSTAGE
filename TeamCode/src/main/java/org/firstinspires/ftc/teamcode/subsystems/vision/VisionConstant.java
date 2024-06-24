package org.firstinspires.ftc.teamcode.subsystems.vision;

import org.firstinspires.ftc.vision.VisionPortal;
import org.opencv.core.Rect;
import org.opencv.core.Size;

class VisionConstant {

    protected static final String CAMERA_ID = "Webcam1";

    protected static final int CAMERA_RESOLUTION_WIDTH = 640;
    protected static final int CAMERA_RESOLUTION_HEIGHT = 480;
    protected static final int TRACKER_MIN_SIZE = 16;
    protected static final int MAX_NUM_RECOGNITIONS = 10;

    protected static final float TRACKER_MAX_OVERLAP = 0.2f;

    protected static final VisionPortal.StreamFormat STREAM_FORMAT = VisionPortal.StreamFormat.YUY2;

    protected static final double BLUE_THRESHOLD = 60;
    protected static final double RED_THRESHOLD = 100;
    protected static final double AMOUNT_OF_COLOR = 2.8;

    protected static final Rect RED_RIGHT_ZONE = new Rect(380, 400, 150, 80);
    protected static final Rect RED_CENTER_ZONE = new Rect(60, 290, 100, 90);
    protected static final Rect BLUE_RIGHT_ZONE = new Rect(380, 400, 150, 80);
    protected static final Rect BLUE_CENTER_ZONE = new Rect(60, 280, 100, 90);

    protected static final Size BLUR_SIZE = new Size(5, 5);

    protected static final int RED_INDEX = 0;
    protected static final int GREEN_INDEX = 1;
    protected static final int BLUE_INDEX = 2;

}
