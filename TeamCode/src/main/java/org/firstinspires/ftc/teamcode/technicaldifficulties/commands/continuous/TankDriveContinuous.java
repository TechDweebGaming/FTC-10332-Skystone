package org.firstinspires.ftc.teamcode.technicaldifficulties.commands.continuous;

import com.disnodeteam.dogecommander.Command;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems.DriveBase;

/**
 * Created by Admin on 1/3/2020.
 */
public class TankDriveContinuous implements Command {

    private DriveBase driveBase;
    private Gamepad driveGamePad;

    public TankDriveContinuous(DriveBase driveBase, Gamepad driveGamePad) {
        this.driveBase = driveBase;
        this.driveGamePad = driveGamePad;
    }

    @Override
    public void start() {
        driveBase.setPowers(0);
    }

    @Override
    public void periodic() {
        driveBase.setPowers(calculatePowersFromJoysticks(driveGamePad.left_stick_x, driveGamePad.left_stick_y, driveGamePad.right_stick_x));
    }

    @Override
    public void stop() {
        driveBase.setPowers(0);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }


    private double[] calculatePowersFromJoysticks(float driveX, float driveY, float rot) {
        double hypot = Math.hypot(-driveX, driveY);
        double desiredAngle = Math.atan2(driveY, -driveX) - Math.PI / 4;
        return new double[] {
                hypot * Math.cos(desiredAngle) - rot,
                hypot * Math.sin(desiredAngle) + rot,
                hypot * Math.sin(desiredAngle) - rot,
                hypot * Math.cos(desiredAngle) + rot
        };
    }
}
