package org.usfirst.frc.team321.robot.auto.modes;

import com.team254.lib.trajectory.Path;
import com.team254.lib.trajectory.PathGenerator;
import com.team254.lib.trajectory.WaypointSequence;
import org.usfirst.frc.team321.robot.Constants;
import org.usfirst.frc.team321.robot.DrivetrainProfileDriver;
import org.usfirst.frc.team321.robot.auto.AutonomousMode;

public class AutoRunSideSwitch extends AutonomousMode {
    private static final String name = "AutoRunSideSwitch";
    private Path path;

    public AutoRunSideSwitch() {
        super(name);

        WaypointSequence waypoint = new WaypointSequence(10);
        waypoint.addWaypoint(new WaypointSequence.Waypoint(0.0, 0.0, 0.0));
        waypoint.addWaypoint(new WaypointSequence.Waypoint(12.0, 0.0, 0.0));

        path = PathGenerator.makePath(waypoint, config, Constants.WHEELBASE_WIDTH, name);
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
