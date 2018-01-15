package org.usfirst.frc.team321.robot.auto.Pathfinder.paths;

import org.usfirst.frc.team321.robot.auto.Pathfinder.PathfinderPath;

public class DoNothingFailsafe extends PathfinderPath {

    private static final String name = "DoNothingFailsafe";

    public DoNothingFailsafe() {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Shouldn't be running");
    }

    @Override
    public String getName() {
        return name;
    }
}
