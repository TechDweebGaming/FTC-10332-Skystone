package org.firstinspires.ftc.teamcode.technicaldifficulties.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.technicaldifficulties.opmodes.auto.base.LineOnly;

/**
 * Created by Admin on 1/23/2020.
 */

@Autonomous(group = "10332", name = "Line Only (D-B, F-R)")
public class DLineOnly extends LineOnly {

    public DLineOnly() {
        super(false, true);
    }

}
