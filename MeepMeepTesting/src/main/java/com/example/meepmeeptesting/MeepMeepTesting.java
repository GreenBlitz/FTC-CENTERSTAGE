package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MinAccelerationConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.ProfileAccelerationConstraint;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.ColorScheme;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueLight;
import com.noahbres.meepmeep.roadrunner.Constraints;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.DriveTrainType;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setConstraints(90, 50, Math.toRadians(180), Math.toRadians(180), 15.5)
                .setDimensions(15.5, 15.5)
                .followTrajectorySequence(drive ->
                        // add your trajectory here:
                        drive.trajectorySequenceBuilder(new Pose2d(12, -60, Math.PI/2))
                                .lineToSplineHeading(new Pose2d(14, -40, Math.toRadians(45)))
                                .addTemporalMarker(() -> {})
                                .waitSeconds(0.5)
                                .splineToLinearHeading(new Pose2d(25, -55), 0)
                                .splineToSplineHeading(new Pose2d(40, -35, 0), 0)
                                .lineToLinearHeading(new Pose2d(50, -37)).setConstraints(new MecanumVelocityConstraint(10, 15.5), new ProfileAccelerationConstraint(5))
                                .addTemporalMarker(() -> {})
                                .waitSeconds(0.5)
                                .resetConstraints()
                                .lineToSplineHeading(new Pose2d(20, -11, Math.PI))
                                .lineTo(new Vector2d(-55, -11))
                                .addTemporalMarker(() -> {})
                                .waitSeconds(0.5)
                                .lineTo(new Vector2d(20, -11))
                                .lineToSplineHeading(new Pose2d(50, -35, 0))
                                .build()


                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}