package org.firstinspires.ftc.teamcode.technicaldifficulties.commands.completion;

import com.disnodeteam.dogecommander.Command;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems.DriveBase;

/**
 * Created by Admin on 1/22/2020.
 */

public class DriveTime implements Command {

    private DriveBase driveBase;
    private double[] powers;
    private double seconds;
    private ElapsedTime timer;

    public DriveTime(DriveBase driveBase, double seconds, ElapsedTime timer, double[] powers) {
        this.driveBase = driveBase;
        this.powers = powers;
        this.seconds = seconds;
        this.timer = timer;
    }

    public DriveTime(DriveBase driveBase, double seconds, ElapsedTime timer, double power) {
        this(driveBase, seconds, timer, new double[] { power, power, power, power});
    }

    @Override
    public void start() {
        timer.reset();
        driveBase.setPowers(0);
    }

    @Override
    public void periodic() {
        driveBase.setPowers(powers);
    }

    @Override
    public void stop() {
        driveBase.setPowers(0);
    }

    @Override
    public boolean isCompleted() {
        return timer.seconds() >= seconds;
    }
}
