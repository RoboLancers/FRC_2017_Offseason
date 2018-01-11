package org.usfirst.frc.team321.robot.auto.modes;

import org.usfirst.frc.team321.robot.auto.AutonomousMode;

public class DoNothingFailsafe extends AutonomousMode {

    private static final String name = "DoNothingFailsafe";

    public DoNothingFailsafe() {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("This shouldn't be running - Mode 0 selected for some reason");
    }

    @Override
    public String getName() {
        return name;
    }

}
