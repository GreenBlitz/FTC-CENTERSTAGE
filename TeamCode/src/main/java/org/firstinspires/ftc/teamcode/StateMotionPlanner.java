package org.firstinspires.ftc.teamcode;

public class StateMotionPlanner {

    private static final int NUMBER_OF_STATES = 3;

    private int robotStateIndex;

    protected StateMotionPlanner(RobotState startingState) {
        this.robotStateIndex = startingState.index;
    }

    protected RobotState getLeftState() {
        robotStateIndex = (robotStateIndex + (NUMBER_OF_STATES - 1)) % NUMBER_OF_STATES;
        return getIndexState(robotStateIndex);
    }

    protected RobotState getRightState() {
        robotStateIndex = (robotStateIndex + 1) % NUMBER_OF_STATES;
        return getIndexState(robotStateIndex);
    }

    public int getRobotStateIndex() {
        return robotStateIndex;
    }

    private RobotState getIndexState(int index) {
        switch (index) {
            case 3:
                return RobotState.CLIMB;
            case 2:
                return RobotState.SCORE;
            case 1:
                return RobotState.DRIVE;
            case 0:
                return RobotState.INTAKE;
            default:
                return RobotState.DRIVE;
        }
    }

}
