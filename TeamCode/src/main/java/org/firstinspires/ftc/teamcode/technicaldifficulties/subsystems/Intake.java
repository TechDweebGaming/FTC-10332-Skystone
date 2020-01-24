package org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems;

import com.disnodeteam.dogecommander.Subsystem;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Admin on 1/7/2020.
 */

public class Intake implements Subsystem {

    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    private DcMotor[] intakeMotors = new DcMotor[2];
    private CRServo[] intakeServos = new CRServo[2];
    private Servo[] latchServos = new Servo[2];

    private double intakeMotorPower = 0;
    private double intakeServoPower = 0;
    private boolean intakeLatchTargetState = true;

    public Intake(HardwareMap hardwareMap, Telemetry telmetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telmetry;
    }

    @Override
    public void initHardware() {
        for(int i = 0; i < 2; i++) {
            intakeMotors[i] = hardwareMap.get(DcMotor.class, String.format("intake_motor_%s", i));
            intakeServos[i] = hardwareMap.get(CRServo.class, String.format("intake_servo_%s", i));
            latchServos[i] = hardwareMap.get(Servo.class, String.format("intake_latch_servo_%s", i));
        }

        intakeMotors[1].setDirection(DcMotorSimple.Direction.REVERSE);
        intakeServos[1].setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void periodic() {
        for(int i = 0; i < 2; i++) {
            intakeMotors[i].setPower(intakeMotorPower);
            intakeServos[i].setPower(intakeServoPower);
        }
        latchServos[0].setPosition(intakeLatchTargetState ? 0 : 0.5);
        latchServos[1].setPosition(intakeLatchTargetState ? 0.9 : 0.5);
        telemetry.addData("Intake Latch State", intakeLatchTargetState);
        telemetry.addData("Intake Latch Servo Pos", latchServos[1].getPosition());
    }

    public void setIntakeMotorPowers(double power) {
        intakeMotorPower = power;
    }

    /*
    public void setIntakeServoPower(double power) {
        intakeServoPower = power;
    }
    */

    public void setIntakeLatchTargetState(boolean targetState) {
        intakeLatchTargetState = targetState;
    }

}
