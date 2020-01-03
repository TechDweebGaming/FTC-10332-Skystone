package org.firstinspires.ftc.teamcode.technicaldifficulties.opmodes.subsystems;

import com.disnodeteam.dogecommander.Subsystem;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Admin on 1/3/2020.
 */
public class DriveBase implements Subsystem {

    private HardwareMap hardwareMap;

    private DcMotor[] driveMotors = new DcMotor[4];
    private double[] powers = new double[] { 0, 0, 0, 0};

    public DriveBase(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    @Override
    public void initHardware() {
        for(int i = 0; i < 4; i++) {
            driveMotors[i] = hardwareMap.get(DcMotor.class, String.format("drive_%s", i));
        }
    }

    @Override
    public void periodic() {
        for(int i = 0; i < 4; i++) {
            driveMotors[i].setPower(powers[i]);
        }
    }

    public void setPowers(double[] powers) {
        this.powers = powers;
    }

    public void setPowers(double power) {
        for(int i = 0; i < 4; i++) {
            powers[i] = power;
        }
    }
}
