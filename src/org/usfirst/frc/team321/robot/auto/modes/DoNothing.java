package org.usfirst.frc.team321.robot.auto.modes;

import org.usfirst.frc.team321.robot.auto.AutonomousMode;

public class DoNothing extends AutonomousMode {

    private static final String name = "DoNothing";

    public DoNothing() {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Explicitly told not to move");
    }

    @Override
    public String getName() {
        return name;
    }

}
