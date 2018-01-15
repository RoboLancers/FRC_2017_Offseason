package org.usfirst.frc.team321.robot.auto.Pathfinder;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team321.robot.Constants;

import static org.usfirst.frc.team321.robot.Constants.*;

abstract public class PathfinderPath {
    private Trajectory trajectory;
    private TankModifier modifier;
    private String name;

    public PathfinderPath(String name) {
        this.name = name;
    }

    public void generateTrajectory(Waypoint[] points) {
        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_LOW, DT, MAX_VELOCITY, MAX_ACCELERATION, MAX_JERK);
        trajectory = Pathfinder.generate(points, config);
        modifier = new TankModifier(trajectory).modify(Constants.WHEELBASE_WIDTH);
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public TankModifier getModifier() {
        return modifier;
    }

    public abstract void run();

    public abstract String getName();
}
