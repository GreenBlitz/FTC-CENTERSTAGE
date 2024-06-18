package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.robocol.Command;

import org.firstinspires.ftc.teamcode.subsystems.arm.ArmCommands;
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmState;
import org.firstinspires.ftc.teamcode.subsystems.claw.ClawCommands;
import org.firstinspires.ftc.teamcode.subsystems.elevator.ElevatorCommands;
import org.firstinspires.ftc.teamcode.subsystems.elevator.ElevatorState;
import org.firstinspires.ftc.teamcode.subsystems.wrist.WristCommands;
import org.firstinspires.ftc.teamcode.subsystems.wrist.WristState;

public class StateCommands {

    public static SequentialCommandGroup setState(RobotState robotState) {
        switch (robotState) {
            case SCORE_BOARD:
                return scoreBoardState();
            case INTAKE:
                return intakeState();
            case DRIVE:
            default:
                return driveState();
        }
    }

    private static SequentialCommandGroup scoreBoardState() {
        return new SequentialCommandGroup(
                new ParallelCommandGroup(
                        WristCommands.moveToState(WristState.SCORE),
                        ArmCommands.goToState(ArmState.SCORE),
                        ElevatorCommands.goToState(ElevatorState.SCORE)
                )
        );
    }

    private static SequentialCommandGroup intakeState() {
        return new SequentialCommandGroup(
                new ParallelCommandGroup(
                        WristCommands.moveToState(WristState.INTAKE),
                        ArmCommands.goToState(ArmState.INTAKE),
                        ElevatorCommands.goToState(ElevatorState.INTAKE)
                ),
                ClawCommands.openBothFingers()
        );
    }

    private static SequentialCommandGroup driveState() {
        return new SequentialCommandGroup(
                ClawCommands.closeBothFingers(),
                new ParallelCommandGroup(
                        WristCommands.moveToState(WristState.IDLE),
                        ArmCommands.goToState(ArmState.IDLE),
                        ElevatorCommands.goToState(ElevatorState.INTAKE)
                )
        );
    }

}
