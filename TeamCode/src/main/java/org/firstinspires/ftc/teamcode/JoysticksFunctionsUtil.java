package org.firstinspires.ftc.teamcode;


import androidx.core.math.MathUtils;


public class JoysticksFunctionsUtil {

    private static final double DEAD_ZONE = 0.05;
    private static final double SENSITIVE_VALUE_POWER = 2;
    private static final double SQUARE_FACTOR = 1.4;

    public static double getDeadZonedValue(double value) {
        return getDeadZonedValue(value, DEAD_ZONE);
    }

    public static double getDeadZonedValue(double value, double deadzone) {
        if (value < deadzone) {
            return 0;
        }
        return Math.signum(value) * (Math.abs(value) - deadzone) / (1 - deadzone);
    }

    public static double getSensitiveValue(double value) {
        return getSensitiveValue(value, SENSITIVE_VALUE_POWER);
    }

    public static double getSensitiveValue(double value, double power) {
        return Math.pow(Math.abs(value), power) * Math.signum(value);
    }

    /**
     * This function returns the value, if the stick was square instead of circle
     *
     * @param value The value we want to use.
     * @return stick value if stick was square.
     * <p>
     * if @ marks the 1 point of each axis:
     * <p>
     * @formatter:off
     *             Before:                                    After:
     *              (1,0)
     *           *****@*******      @ (1,1)                *************
     *      *****           *****                    *****    (1,0)     *****
     *     ***                   ***                ***  -------@-------@   ***
     *    **                       **              **   |          (1,1)|    **
     *   **                         **            **    |               |     **
     *   **                         *@ (0,1)      **    |          (0,1)@     **
     *   **                         **            **    |               |     **
     *   **                         **            **    |               |     **
     *    **                       **              **   |_______________|    **
     *     ***                   ***                ***                    ***
     *       *****           *****                    *****            *****
     *           *************                            *************
     * @formatter:on
     * </p>
     */
    public static double getSquaredValue(double value) {
        double squaredAxisValue = value * SQUARE_FACTOR;
        return MathUtils.clamp(squaredAxisValue, -1, 1);
    }

    public static double getDeadZonedSquaredValue(double value){
        return getSquaredValue(getDeadZonedValue(value));
    }

    public static double getDeadZonedSensitiveSquaredValue(double value){
        return getSensitiveValue(getDeadZonedSquaredValue(value));
    }


}
