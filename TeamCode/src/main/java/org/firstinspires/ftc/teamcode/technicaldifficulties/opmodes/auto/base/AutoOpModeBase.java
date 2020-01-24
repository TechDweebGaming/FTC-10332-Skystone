package org.firstinspires.ftc.teamcode.technicaldifficulties.opmodes.auto.base;

import com.disnodeteam.dogecommander.DogeCommander;
import com.disnodeteam.dogecommander.DogeOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems.DriveBase;
import org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems.Intake;

/**
 * Created by Admin on 1/23/2020.
 */

public abstract class AutoOpModeBase extends LinearOpMode implements DogeOpMode {

    protected DogeCommander commander;

    protected DriveBase driveBase;
    protected Intake intake;

    protected ElapsedTime timer;

    @Override
    public void runOpMode() throws InterruptedException {
        commander = new DogeCommander(this);

        driveBase = new DriveBase(hardwareMap, telemetry);
        intake = new Intake(hardwareMap, telemetry);

        commander.registerSubsystem(driveBase);
        commander.registerSubsystem(intake);

        commander.init();

        timer = new ElapsedTime();

        waitForStart();

        runCommands();

        commander.stop();
    }

    public abstract void runCommands();

}
