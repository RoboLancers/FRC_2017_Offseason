package org.usfirst.frc.team321.robot.auto.Pathfinder.paths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;
import org.usfirst.frc.team321.robot.PathfinderFollower;
import org.usfirst.frc.team321.robot.auto.Pathfinder.PathfinderPath;

public class TestTrajectory extends PathfinderPath {

    private static final String name = "TestTrajectory";

    public TestTrajectory() {
        super(name);
        generateTrajectory(new Waypoint[]{
                new Waypoint(0, 0, Pathfinder.d2r(-50)),
                new Waypoint(10.0, -7.5, 0),
                new Waypoint(16.25, -7.5, 0),
                new Waypoint(18.75, -5.0, Pathfinder.d2r(45))
        });
    }

    @Override
    public void run() {
        PathfinderFollower pathfinderFollower = new PathfinderFollower(super.getModifier());
        pathfinderFollower.followPath();
    }

    @Override
    public String getName() {
        return name;
    }
}
