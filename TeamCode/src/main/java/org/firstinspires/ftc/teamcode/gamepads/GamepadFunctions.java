package org.firstinspires.ftc.teamcode.gamepads;


import androidx.core.math.MathUtils;

import org.opencv.core.Mat;


public class GamepadFunctions {

    public static double getDeadZonedSensitiveSquaredValue(double value) {
        return getSensitiveValue(getDeadZonedSquaredValue(value));
    }

    public static double getDeadZonedSquaredValue(double value) {
        return getSquaredValue(getDeadZonedValue(value));
    }

    public static double getDeadZonedSensitiveValue(double value) {
        return getSensitiveValue(getDeadZonedValue(value));
    }

    public static double getDeadZonedValue(double value) {
        return getDeadZonedValue(value, GamepadConstants.DEAD_ZONE);
    }

    public static double getDeadZonedValue(double value, double deadzone) {
        if (Math.abs(value) < deadzone) {
            return 0;
        }
        return Math.signum(value) * (Math.abs(value) - deadzone) / (1 - deadzone);
    }

    public static double getSensitiveValue(double value) {
        return getSensitiveValue(value, GamepadConstants.SENSITIVE_VALUE_POWER);
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
        double squaredAxisValue = value * GamepadConstants.SQUARE_FACTOR;
        return MathUtils.clamp(squaredAxisValue, -1, 1);
    }

}
