package org.usfirst.frc.team321.robot.auto.Pathfinder;

import org.usfirst.frc.team321.robot.auto.Pathfinder.paths.DoNothingFailsafe;
import org.usfirst.frc.team321.robot.auto.Pathfinder.paths.TestTrajectory;

import java.util.ArrayList;

public class PathManager {

    private ArrayList<PathfinderPath> paths = new ArrayList<>();

    PathManager() {
        paths.add(new DoNothingFailsafe());
        paths.add(new TestTrajectory());
    }

    public ArrayList<PathfinderPath> getPaths() {
        return paths;
    }

    public PathfinderPath getPathByName(String name) {
        return paths
                .stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(new DoNothingFailsafe());
    }

    public PathfinderPath getPathByIndex(int index) {
        try {
            return paths.get(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return new DoNothingFailsafe();
        }
    }
}
