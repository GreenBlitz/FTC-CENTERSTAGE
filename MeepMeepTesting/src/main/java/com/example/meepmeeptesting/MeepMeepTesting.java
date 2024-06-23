package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setConstraints(90, 50, Math.toRadians(180), Math.toRadians(180), 15.5)
                .setDimensions(15.5, 15.5)
                .followTrajectorySequence(drive ->
                        // add your trajectory here:
                        drive.trajectorySequenceBuilder(new Pose2d(-35, 60, -Math.PI / 2))
                                .lineToSplineHeading(new Pose2d(-38, 40, Math.toRadians(-135)))
                                .addTemporalMarker(() -> {
                                })
                                .waitSeconds(0.5)
                                .strafeRight(25)
                                .lineToLinearHeading(new Pose2d(-55, 35, Math.PI))
                                .addTemporalMarker(() -> {
                                })
                                .waitSeconds(0.5)
                                .lineTo(new Vector2d(-55, 11))
                                .lineTo(new Vector2d(20, 11))
                                .lineToSplineHeading(new Pose2d(40, 25, 0))
                                .lineToLinearHeading(new Pose2d(50, 43))
                                .addTemporalMarker(() -> {
                                })
                                .waitSeconds(0.5)
                                //pick up whites
                                .lineToSplineHeading(new Pose2d(20, 11, Math.PI))
                                .lineTo(new Vector2d(-55, 11))
                                .addTemporalMarker(() -> {
                                })
                                .waitSeconds(0.5)
                                .lineTo(new Vector2d(20, 11))
                                .lineToSplineHeading(new Pose2d(50, 35, 0))
                                .addTemporalMarker(() -> {
                                })
                                .waitSeconds(0.5)
                                .lineToSplineHeading(new Pose2d(20, 11, Math.PI))
                                .lineTo(new Vector2d(-55, 11))
                                .addTemporalMarker(() -> {
                                })
                                .waitSeconds(0.5)
                                .lineTo(new Vector2d(20, 11))
                                .lineToSplineHeading(new Pose2d(50, 35, 0))
                                .addTemporalMarker(() -> {
                                })
                                .waitSeconds(0.5)
                                .build()


                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}