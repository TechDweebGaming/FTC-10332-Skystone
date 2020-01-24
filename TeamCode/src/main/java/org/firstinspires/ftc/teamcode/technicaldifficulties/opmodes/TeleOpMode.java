package org.firstinspires.ftc.teamcode.technicaldifficulties.opmodes;

import com.disnodeteam.dogecommander.DogeCommander;
import com.disnodeteam.dogecommander.DogeOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.technicaldifficulties.commands.continuous.BedClawsContinuous;
import org.firstinspires.ftc.teamcode.technicaldifficulties.commands.continuous.IntakePowerContinuous;
import org.firstinspires.ftc.teamcode.technicaldifficulties.commands.continuous.TankDriveContinuous;
import org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems.BedClaws;
import org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems.DriveBase;
import org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems.Intake;

/**
 * Created by Admin on 1/3/2020.
 */

@TeleOp(group = "10332", name = "Primary Op Mode")
public class TeleOpMode extends LinearOpMode implements DogeOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DogeCommander commander = new DogeCommander(this);

        DriveBase driveBase = new DriveBase(hardwareMap, telemetry);
        Intake intake = new Intake(hardwareMap, telemetry);
        BedClaws bedClaws = new BedClaws(hardwareMap);

        commander.registerSubsystem(driveBase);
        commander.registerSubsystem(intake);
        commander.registerSubsystem(bedClaws);

        commander.init();

        waitForStart();

        commander.runCommandsParallel(
                new TankDriveContinuous(driveBase, gamepad1),
                new IntakePowerContinuous(intake, gamepad2),
                new BedClawsContinuous(bedClaws, gamepad2)
        );

        commander.stop();

    }

}
