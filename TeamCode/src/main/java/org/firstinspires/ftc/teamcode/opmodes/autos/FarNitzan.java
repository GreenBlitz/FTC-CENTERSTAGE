package org.firstinspires.ftc.teamcode.opmodes.autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.FieldStartingLocation;
import org.firstinspires.ftc.teamcode.utils.AutoUtil;

public class FarNitzan extends DefaultNitzan {
    @Override
    public Alliance getAlliance() {
        return Alliance.RED;
    }

    @Override
    public FieldStartingLocation getFieldStartingLocation() {
        return FieldStartingLocation.FAR;
    }

    @Override
    public void run() throws InterruptedException {

        Pose2d startPose = AutoUtil.getAssignedStartingPose();

        drive.setPoseEstimate(startPose);

        waitForStart();

        if (!isStopRequested()) {
            drive.followTrajectorySequence(far());
            drive.followTrajectorySequence(backdropToPixelPile());
            drive.followTrajectorySequence(backdropToPixelPile());
        }
    }
}
