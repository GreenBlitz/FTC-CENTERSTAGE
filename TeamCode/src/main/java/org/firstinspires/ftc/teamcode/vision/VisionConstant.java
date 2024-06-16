package org.firstinspires.ftc.teamcode.vision;

import org.firstinspires.ftc.vision.VisionPortal;
import org.openftc.easyopencv.OpenCvWebcam;

public class VisionConstant {

    protected static final String CAMERA_ID = "Webcam1";

    protected static final int CAMERA_RESOLUTION_WIDTH = 640;
    protected static final int CAMERA_RESOLUTION_HEIGHT = 480;
    protected static final int TRACKER_MIN_SIZE = 16;
    protected static final int MAX_NUM_RECOGNITIONS = 10;

    protected static final float TRACKER_MAX_OVERLAP = 0.2f;

    protected static final VisionPortal.StreamFormat STREAM_FORMAT = VisionPortal.StreamFormat.YUY2;

}
