package org.firstinspires.ftc.teamcode.vision;

import android.graphics.Canvas;
import android.util.Size;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import org.opencv.core.Mat;

public class Vision extends SubsystemBase implements VisionProcessor {

    private VisionPortal visionPortal;

    public Vision(HardwareMap hardwareMap) {

        AprilTagProcessor.Builder aprilTagProcessorBuilder = new AprilTagProcessor.Builder()
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .setDrawAxes(true)
                .setDrawCubeProjection(true);

        AprilTagProcessor aprilTagProcessor = aprilTagProcessorBuilder.build();

        TfodProcessor.Builder tfodProcessorBuilder = new TfodProcessor.Builder()
                .setMaxNumRecognitions(VisionConstant.MAX_NUM_RECOGNITIONS)
                .setUseObjectTracker(true)
                .setTrackerMaxOverlap(VisionConstant.TRACKER_MAX_OVERLAP)
                .setTrackerMinSize(VisionConstant.TRACKER_MIN_SIZE);

        TfodProcessor tfodProcessor = tfodProcessorBuilder.build();

        VisionPortal.Builder visionPortalBuilder = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, VisionConstant.CAMERA_ID))
                .addProcessors(aprilTagProcessor,tfodProcessor)
                .setCameraResolution(new Size(VisionConstant.CAMERA_RESOLUTION_WIDTH,VisionConstant.CAMERA_RESOLUTION_HEIGHT))
                .setStreamFormat(VisionConstant.STREAM_FORMAT)
                .enableLiveView(true)
                .setAutoStopLiveView(true);

        visionPortal = visionPortalBuilder.build();
    }

    @Override
    public void init(int width, int height, CameraCalibration calibration) {

    }

    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {
        return null;
    }

    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {

    }
}
