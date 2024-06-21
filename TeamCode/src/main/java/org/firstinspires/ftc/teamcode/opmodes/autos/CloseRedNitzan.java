package org.firstinspires.ftc.teamcode.opmodes.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.FieldStartingLocation;

public class CloseRedNitzan  extends DefaultNitzan {

    @Override
    public Alliance getAlliance() {
        return Alliance.RED;
    }

    @Override
    public FieldStartingLocation getFieldStartingLocation() {
        return FieldStartingLocation.CLOSE;
    }

    @Override
    public void run() throws InterruptedException {

        Pose2d startPose = new Pose2d(12, -60, Math.PI/2);

        drive.setPoseEstimate(startPose);

        waitForStart();

        if (!isStopRequested()) {
            drive.followTrajectorySequence(closeRed());
            drive.followTrajectorySequence(redBackdropToPixelPile());
            drive.followTrajectorySequence(redBackdropToPixelPile());
        }
    }
}
