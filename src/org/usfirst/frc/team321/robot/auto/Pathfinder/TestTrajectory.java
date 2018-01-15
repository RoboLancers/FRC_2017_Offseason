package org.usfirst.frc.team321.robot.auto.Pathfinder;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team321.robot.Constants;

public class TestTrajectory {

    TankModifier modifier;

    public TestTrajectory() {
        Waypoint[] points = new Waypoint[]{
                new Waypoint(-4, -1, 0),
                new Waypoint(-4, -1, 0),
                new Waypoint(0, 0, 0),
        };

        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.DT, Constants.MAX_VELOCITY, Constants.MAX_ACCELERATION, Constants.MAX_JERK);
        Trajectory trajectory = Pathfinder.generate(points, config);

        modifier = new TankModifier(trajectory).modify(Constants.WHEELBASE_WIDTH);
    }
}
