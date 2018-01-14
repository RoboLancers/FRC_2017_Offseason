package org.usfirst.frc.team321.robot.auto.modes;

import com.team254.lib.trajectory.Path;
import com.team254.lib.trajectory.PathGenerator;
import com.team254.lib.trajectory.WaypointSequence;
import org.usfirst.frc.team321.robot.Constants;
import org.usfirst.frc.team321.robot.DrivetrainProfileDriver;
import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.auto.AutonomousMode;

public class SwitchMiddle extends AutonomousMode {
    private static final String name = "SwitchMiddle";
    private Path path;

    public SwitchMiddle() {
        super(name);

        WaypointSequence waypoints = new WaypointSequence(10);

        if (!Robot.gameData.equals("   ") && Robot.gameData.charAt(0) == 'L') {
            waypoints.addWaypoint(new WaypointSequence.Waypoint(0.0, 0.0, 0.0));
            waypoints.addWaypoint(new WaypointSequence.Waypoint(11, 2.5, 0.0));
        } else if (!Robot.gameData.equals("   ") && Robot.gameData.charAt(0) == 'R') {
            waypoints.addWaypoint(new WaypointSequence.Waypoint(0.0, 0.0, 0.0));
            waypoints.addWaypoint(new WaypointSequence.Waypoint(11, -2.5, 0.0));
        } else {
            waypoints.addWaypoint(new WaypointSequence.Waypoint(0.0, 0.0, 0.0));
            waypoints.addWaypoint(new WaypointSequence.Waypoint(0.0, 0.0, 0.0));
        }

        path = PathGenerator.makePath(waypoints, config, Constants.WHEELBASE_WIDTH, name);
    }

    @Override
    public void run() {
        DrivetrainProfileDriver driver = new DrivetrainProfileDriver(path);
        driver.followPath();
    }

    @Override
    public String getName() {
        return name;
    }
}
