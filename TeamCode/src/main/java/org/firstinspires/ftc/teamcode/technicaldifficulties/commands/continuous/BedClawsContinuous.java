package org.firstinspires.ftc.teamcode.technicaldifficulties.commands.continuous;

import com.disnodeteam.dogecommander.Command;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems.BedClaws;

/**
 * Created by Admin on 1/23/2020.
 */

public class BedClawsContinuous implements Command {

    private BedClaws bedClaws;
    private Gamepad gunnerGamePad;

    public BedClawsContinuous(BedClaws bedClaws, Gamepad gunnerGamePad) {
        this.bedClaws = bedClaws;
        this.gunnerGamePad = gunnerGamePad;
    }

    @Override
    public void start() {
        bedClaws.setLatchState(false);
    }

    @Override
    public void periodic() {
        bedClaws.setLatchState(gunnerGamePad.left_bumper);
    }

    @Override
    public void stop() {
        bedClaws.setLatchState(false);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

}
