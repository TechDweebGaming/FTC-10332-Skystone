package org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems;

import com.disnodeteam.dogecommander.Subsystem;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Admin on 1/3/2020.
 */
public class DriveBase implements Subsystem {

    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    private DcMotor[] driveMotors = new DcMotor[4];

    //private BNO055IMU imu;

    private double[] powers = new double[] { 0, 0, 0, 0};

    public DriveBase(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
    }

    @Override
    public void initHardware() {
        for(int i = 0; i < 4; i++) {
            driveMotors[i] = hardwareMap.get(DcMotor.class, String.format("drive_%s", i));
        }
        setDirections();
        /*
        BNO055IMU.Parameters gyroParams = new BNO055IMU.Parameters();

        gyroParams.mode = BNO055IMU.SensorMode.IMU;
        gyroParams.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        gyroParams.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        gyroParams.loggingEnabled = false;

        imu = hardwareMap.get(BNO055IMU.class, "imu");

        imu.initialize(gyroParams);

        while(!imu.isGyroCalibrated()) {
            setStatus("Waiting for Gyro Calibration");
        }
        */

        setStatus("Ready");
    }

    @Override
    public void periodic() {
        for(int i = 0; i < 4; i++) driveMotors[i].setPower(powers[i]);

        telemetry.update();
    }

    public void setPowers(double[] powers) {
        this.powers = powers;
    }

    public void setPowers(double power) {
        for(int i = 0; i < 4; i++) {
            powers[i] = power;
        }
    }

    public void setStatus(String status) {
        telemetry.addData("Drive Base Status", status);
        telemetry.update();
    }

    public void setModes(DcMotor.RunMode mode) {
        for(DcMotor motor : driveMotors) {
            motor.setMode(mode);
        }
        setDirections();
    }

    public void setDirections() {
        driveMotors[0].setDirection(DcMotorSimple.Direction.REVERSE);
        driveMotors[2].setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
