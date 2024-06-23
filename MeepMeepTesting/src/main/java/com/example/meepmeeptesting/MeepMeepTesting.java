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
                        drive.trajectorySequenceBuilder(new Pose2d(12, -70, -Math.PI / 2))
                                .lineTo(new Vector2d(12, -50))
                                .turn(Math.toRadians(-45))//make object angle
//                                .addTemporalMarker(() -> Robot.getInstance().setState(RobotState.INTAKE).schedule())
                                .waitSeconds(2)
//                                .addTemporalMarker(() -> Robot.getInstance().getClaw().openRight())
                                .waitSeconds(0.5)
                                .turn(Math.toRadians(45))
                                .waitSeconds(1)
//                                .addTemporalMarker(() -> Robot.getInstance().setState(RobotState.DRIVE).schedule())
                                .waitSeconds(1)
                                .lineTo(new Vector2d(12, -60))
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