package org.firstinspires.ftc.teamcode.gamepads;

import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadWrapper extends GamepadEx {

    private final Trigger leftTriggerButton;
    private final Trigger rightTriggerButton;

    public GamepadWrapper(Gamepad gamepad) {
        super(gamepad);
        this.leftTriggerButton = new Trigger(() -> getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > GamepadConstants.DEAD_ZONE);
        this.rightTriggerButton = new Trigger(() -> getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > GamepadConstants.DEAD_ZONE);
    }

    public Trigger getTriggerAsButton(GamepadKeys.Trigger trigger) {
        return trigger == GamepadKeys.Trigger.LEFT_TRIGGER ? leftTriggerButton : rightTriggerButton;
    }
}
