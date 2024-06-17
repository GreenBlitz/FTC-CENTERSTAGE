package org.firstinspires.ftc.teamcode.subsystems.vision;

import org.firstinspires.ftc.vision.VisionPortal;
import org.opencv.core.Rect;
import org.openftc.easyopencv.OpenCvWebcam;

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
    protected static final Rect RED_LEFT_ZONE_AREA = new Rect(815, 550, 175, 100);
    protected static final Rect RED_CENTER_ZONE_AREA = new Rect(1365, 475, 125, 125);
    protected static final Rect BLUE_LEFT_ZONE_AREA = new Rect(240, 525, 175, 100);
    protected static final Rect BLUE_CENTER_ZONE_AREA = new Rect(925, 485, 125, 125);
}
