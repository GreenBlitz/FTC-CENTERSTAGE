package org.firstinspires.ftc.teamcode.subsystems.vision;

import android.graphics.Canvas;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Mat;

public class ObjectProcessor implements VisionProcessor {

    private boolean isBlueAlliance;
    private TeamObjectDetection objectDetection;

    public ObjectProcessor(boolean isBlueAlliance) {
        this.isBlueAlliance = isBlueAlliance;
    }

    private boolean isPixelOfObject(double[] pixel) {
        if(pixel == null || pixel.length < 3) {
            return false;
        }
        if(isBlueAlliance) {
            return pixel[0]*VisionConstant.PERCENTAGE_OF_ALLIANCE_COLOR < pixel[2] &&
                   pixel[1]*VisionConstant.PERCENTAGE_OF_ALLIANCE_COLOR < pixel[2];
        }
        else {
            return pixel[2]*VisionConstant.PERCENTAGE_OF_ALLIANCE_COLOR < pixel[0] &&
                   pixel[1]*VisionConstant.PERCENTAGE_OF_ALLIANCE_COLOR < pixel[0];
        }
    }

    private int[] getObjectCoords(Mat frame) {
        int avgX = 0;
        int avgY = 0;
        int pixelCount = 0;

        for(int i = 0; i < frame.width(); i+=2)
            for(int j = 0; j < frame.height(); j+=2)
                if(isPixelOfObject(frame.get(i,j))) {
                    avgX += i;
                    avgY += j;
                    pixelCount++;
                }

        if(pixelCount != 0) {
            avgX /= pixelCount;
            avgY /= pixelCount;
            return new int[]{avgX,avgY};
        }
        else {
            return null;
        }

    }

    public TeamObjectDetection getLastDetection() {
        return objectDetection;
    }

    @Override
    public void init(int width, int height, CameraCalibration calibration) {

    }

    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {

        int[] coordinates = getObjectCoords(frame);

        if(coordinates != null) {
            this.objectDetection = new TeamObjectDetection(coordinates[0],coordinates[1], frame.width(), frame.height());
            return objectDetection;
        }
        return null;
    }

    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {

    }
}
