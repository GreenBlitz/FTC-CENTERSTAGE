package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.arm.ArmCommands;
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmState;
import org.firstinspires.ftc.teamcode.subsystems.claw.ClawCommands;
import org.firstinspires.ftc.teamcode.subsystems.elevator.ElevatorCommands;
import org.firstinspires.ftc.teamcode.subsystems.elevator.ElevatorState;
import org.firstinspires.ftc.teamcode.subsystems.wrist.WristCommands;
import org.firstinspires.ftc.teamcode.subsystems.wrist.WristState;

public class StateCommands {

    protected static SequentialCommandGroup scoreState() {
        return new SequentialCommandGroup(
                ClawCommands.closeBothFingers(),
                new ParallelCommandGroup(
                        ClawCommands.unlockFingers(),
                        WristCommands.moveToState(WristState.SCORE),
                        ArmCommands.goToState(ArmState.SCORE),
                        ElevatorCommands.goToState(ElevatorState.SCORE)
                )
        );
    }

    protected static SequentialCommandGroup intakeState() {
        return new SequentialCommandGroup(
                new ParallelCommandGroup(
                        ClawCommands.unlockFingers(),
                        WristCommands.moveToState(WristState.INTAKE),
                        ArmCommands.goToState(ArmState.INTAKE),
                        ElevatorCommands.goToState(ElevatorState.INTAKE)
                ),
                ClawCommands.openBothFingers()
        );
    }

    protected static SequentialCommandGroup preIntakeState() {
        return new SequentialCommandGroup(
                new ParallelCommandGroup(
                        ClawCommands.unlockFingers(),
                        WristCommands.moveToState(WristState.INTAKE),
                        ArmCommands.goToState(ArmState.IDLE),
                        ElevatorCommands.goToState(ElevatorState.INTAKE)
                )
        );
    }

    protected static SequentialCommandGroup climbState() {
        return new SequentialCommandGroup(
                ClawCommands.closeBothFingers(),
                new ParallelCommandGroup(
                        ClawCommands.unlockFingers(),
                        ArmCommands.goToState(ArmState.CLIMB),
                        ElevatorCommands.goToState(ElevatorState.CLIMB)
                )
        );
    }

    protected static SequentialCommandGroup driveState() {
        return new SequentialCommandGroup(
                ClawCommands.closeBothFingers(),
                new ParallelCommandGroup(
                        ClawCommands.lockFingers(),
                        WristCommands.moveToState(WristState.IDLE),
                        ArmCommands.goToState(ArmState.IDLE),
                        ElevatorCommands.goToState(ElevatorState.IDLE)
                )
        );
    }

}
