package org.firstinspires.ftc.teamcode;

class StateMotionPlanner {

    private int robotStateIndex;

    protected StateMotionPlanner(RobotState startingState) {
        this.robotStateIndex = getStateIndex(startingState);
    }

    protected RobotState getLeftState() {
        robotStateIndex = (robotStateIndex + 2) % 3;
        return getIndexState(robotStateIndex);
    }

    protected RobotState getRightState() {
        robotStateIndex = (robotStateIndex + 1) % 3;
        return getIndexState(robotStateIndex);
    }

    public int getRobotStateIndex() {
        return robotStateIndex;
    }

    private int getStateIndex(RobotState state) {
        switch (state) {
            case SCORE:
                return 2;
            case DRIVE:
                return 1;
            case INTAKE:
                return 0;
            default:
                return 1;
        }
    }

    private RobotState getIndexState(int index) {
        switch (index) {
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
