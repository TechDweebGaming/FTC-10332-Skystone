package org.firstinspires.ftc.teamcode.technicaldifficulties.opmodes;

import com.disnodeteam.dogecommander.DogeCommander;
import com.disnodeteam.dogecommander.DogeOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.technicaldifficulties.opmodes.commands.TankDrive;
import org.firstinspires.ftc.teamcode.technicaldifficulties.opmodes.subsystems.DriveBase;

/**
 * Created by Admin on 1/3/2020.
 */

@TeleOp(group = "10332", name = "Primary Op Mode")
public class TeleOpMode extends LinearOpMode implements DogeOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DogeCommander commander = new DogeCommander(this);

        DriveBase driveBase = new DriveBase(hardwareMap);

        commander.registerSubsystem(driveBase);

        commander.init();

        waitForStart();

        commander.runCommandsParallel(
                new TankDrive(driveBase, gamepad1)
        );

        commander.stop();

    }

}
