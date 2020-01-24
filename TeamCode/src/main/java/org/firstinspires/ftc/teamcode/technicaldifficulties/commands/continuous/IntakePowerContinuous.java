package org.firstinspires.ftc.teamcode.technicaldifficulties.commands.continuous;

import com.disnodeteam.dogecommander.Command;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems.Intake;

/**
 * Created by Admin on 1/7/2020.
 */

public class IntakePowerContinuous implements Command {

    private Intake intake;
    private Gamepad gunnerGamePad;

    public IntakePowerContinuous(Intake intake, Gamepad gunnerGamePad) {
        this.intake = intake;
        this.gunnerGamePad = gunnerGamePad;
    }

    @Override
    public void start() {
        intake.setIntakeMotorPowers(0);
        intake.setIntakeLatchTargetState(true);
    }

    @Override
    public void periodic() {
        if(gunnerGamePad.right_trigger > .5) intake.setIntakeMotorPowers(gunnerGamePad.right_trigger / 3);
        else if(gunnerGamePad.left_trigger > .5) intake.setIntakeMotorPowers(gunnerGamePad.left_trigger / -3);
        else intake.setIntakeMotorPowers(0);

        if(gunnerGamePad.right_bumper) intake.setIntakeLatchTargetState(false);
    }

    @Override
    public void stop() {
        intake.setIntakeMotorPowers(0);
        intake.setIntakeLatchTargetState(false);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

}
