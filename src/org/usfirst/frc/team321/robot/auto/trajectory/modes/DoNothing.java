package org.usfirst.frc.team321.robot.auto.trajectory.modes;

import org.usfirst.frc.team321.robot.auto.trajectory.AutonomousMode;

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
