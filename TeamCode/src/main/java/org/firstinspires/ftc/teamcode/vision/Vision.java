package org.firstinspires.ftc.teamcode.vision;

import android.util.Pair;
import android.util.Size;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.geometry.Vector2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagPoseFtc;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import java.util.ArrayList;
import java.util.List;

public class Vision extends SubsystemBase {

    private VisionPortal visionPortal;
    private AprilTagProcessor aprilTagProcessor;
    private TfodProcessor tfodProcessor;
    private List<AprilTagDetection> aprilTagDetections;

    public Vision(HardwareMap hardwareMap) {

        aprilTagDetections = new ArrayList<>();

        this.aprilTagProcessor = new AprilTagProcessor.Builder()
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .setDrawAxes(true)
                .setDrawCubeProjection(true)
                .build();

        this.tfodProcessor = new TfodProcessor.Builder()
                .setMaxNumRecognitions(VisionConstant.MAX_NUM_RECOGNITIONS)
                .setUseObjectTracker(true)
                .setTrackerMaxOverlap(VisionConstant.TRACKER_MAX_OVERLAP)
                .setTrackerMinSize(VisionConstant.TRACKER_MIN_SIZE)
                .build();

        this.visionPortal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, VisionConstant.CAMERA_ID))
                .addProcessors(aprilTagProcessor, tfodProcessor)
                .setCameraResolution(new Size(VisionConstant.CAMERA_RESOLUTION_WIDTH, VisionConstant.CAMERA_RESOLUTION_HEIGHT))
                .setStreamFormat(VisionConstant.STREAM_FORMAT)
                .enableLiveView(true)
                .setAutoStopLiveView(true)
                .build();
    }

    @Override
    public void periodic() {

        aprilTagDetections = aprilTagProcessor.getDetections();

    }

    public List<AprilTagDetection> getTagsDetections() {
        return aprilTagDetections;
    }
    public List<Pair<AprilTagPoseFtc,Integer>> getTagsPoses() {
        List<Pair<AprilTagPoseFtc,Integer>> poses = new ArrayList<>();
        for(AprilTagDetection detection : getTagsDetections())
            if(detection.metadata != null)
                poses.add(new Pair<>(detection.ftcPose,detection.id));
        return poses;
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("first tag x: ", getTagsPoses().get(0).first.x);
    }

}
