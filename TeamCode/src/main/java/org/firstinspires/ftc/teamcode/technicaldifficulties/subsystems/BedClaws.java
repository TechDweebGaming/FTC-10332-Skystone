package org.firstinspires.ftc.teamcode.technicaldifficulties.subsystems;

import com.disnodeteam.dogecommander.Subsystem;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Admin on 1/23/2020.
 */

public class BedClaws implements Subsystem {

    private HardwareMap hardwareMap;

    private Servo[] latchServos = new Servo[2];

    private boolean latchTargetState = false;

    public BedClaws(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    @Override
    public void initHardware() {
        for(int i = 0; i < 2; i++) {
            latchServos[i] = hardwareMap.get(Servo.class, String.format("bed_latch_servo_%s", i));
        }
        latchServos[1].setDirection(Servo.Direction.REVERSE);
    }

    @Override
    public void periodic() {
        for(int i = 0; i < 2; i++) {
            latchServos[i].setPosition(latchTargetState ? 1 : 0);
        }
    }

    public void setLatchState(boolean state) {
        latchTargetState = state;
    }

}
