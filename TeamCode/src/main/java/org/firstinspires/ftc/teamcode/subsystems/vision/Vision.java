package org.firstinspires.ftc.teamcode.subsystems.vision;

import android.graphics.Canvas;
import android.util.Pair;
import android.util.Size;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagPoseFtc;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import org.opencv.core.Mat;

import java.util.ArrayList;
import java.util.List;

public class Vision extends SubsystemBase {

    private AprilTagProcessor aprilTagProcessor;
    private TfodProcessor tfodProcessor;
    private ObjectProcessor objectProcessor;
    private VisionPortal visionPortal;
    private List<AprilTagDetection> aprilTagDetections;
    private TeamObjectDetection teamObjectDetection;

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

        objectProcessor = new ObjectProcessor(false);

        this.visionPortal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, VisionConstant.CAMERA_ID))
                .addProcessors(aprilTagProcessor, tfodProcessor, objectProcessor)
                .setCameraResolution(new Size(VisionConstant.CAMERA_RESOLUTION_WIDTH, VisionConstant.CAMERA_RESOLUTION_HEIGHT))
                .setStreamFormat(VisionConstant.STREAM_FORMAT)
                .enableLiveView(true)
                .setAutoStopLiveView(true)
                .build();
    }

    @Override
    public void periodic() {

        this.aprilTagDetections = aprilTagProcessor.getDetections();
        this.teamObjectDetection = objectProcessor.getLastDetection();

    }

    public List<AprilTagDetection> getTagsDetections() {
        return aprilTagDetections;
    }
    public List<Pair<AprilTagPoseFtc,Integer>> getTagsPoses() {
        List<AprilTagDetection> temp = getTagsDetections();
        List<Pair<AprilTagPoseFtc,Integer>> poses = new ArrayList<>();
        for(AprilTagDetection detection : temp)
            if(detection.metadata != null)
                poses.add(new Pair<>(detection.ftcPose,detection.id));
        return poses;
    }

    public void telemetry(Telemetry telemetry) {
        List<Pair<AprilTagPoseFtc,Integer>> poses = getTagsPoses();
        if(!poses.isEmpty()) {
            telemetry.addData("detected: ", poses.size() + " AprilTags");
            telemetry.addData("the first tag is: ", poses.get(0).second);
            telemetry.addData("first tag x: ", poses.get(0).first.x);
            telemetry.addData("first tag y: ", poses.get(0).first.y);
            telemetry.addData("first tag z: ", poses.get(0).first.z);
        }
        if(teamObjectDetection != null) {
            telemetry.addData("object X on screen: ", teamObjectDetection.x);
            telemetry.addData("object Y on screen: ", teamObjectDetection.y);
        }
    }
}