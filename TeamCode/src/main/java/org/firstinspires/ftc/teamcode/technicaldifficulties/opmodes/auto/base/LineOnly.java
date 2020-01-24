package org.firstinspires.ftc.teamcode.technicaldifficulties.opmodes.auto.base;

import org.firstinspires.ftc.teamcode.technicaldifficulties.commands.completion.DriveTime;

/**
 * Created by Admin on 1/23/2020.
 */

public abstract class LineOnly extends AutoOpModeBase {

    private int multiplier;
    private boolean outer;

    public LineOnly(boolean foundationSide, boolean outer) {
        multiplier = foundationSide ? 1 : -1;
        this.outer = outer;
    }

    @Override
    public void runCommands() {
        commander.runCommand(new DriveTime(driveBase, outer ? 0.25 : 1.25, timer, -0.25));
        commander.runCommand(new DriveTime(driveBase, 2, timer, new double[] {
                multiplier * -0.5,
                multiplier * 0.5,
                multiplier * 0.5,
                multiplier * -0.5
        }));
    }

}
