package org.usfirst.frc.team321.robot.auto.modes;

import com.team254.lib.trajectory.Path;
import com.team254.lib.trajectory.PathGenerator;
import com.team254.lib.trajectory.WaypointSequence;
import org.usfirst.frc.team321.robot.Constants;
import org.usfirst.frc.team321.robot.DrivetrainProfileDriver;
import org.usfirst.frc.team321.robot.auto.AutonomousMode;

public class AutoRunSide extends AutonomousMode {

    private static final String name = "AutoRunSide";
    private Path path;

    public AutoRunSide() {
        super(name);

        WaypointSequence waypoint_0 = new WaypointSequence(10);
        waypoint_0.addWaypoint(new WaypointSequence.Waypoint(0.0, 0.0, 0.0));
        waypoint_0.addWaypoint(new WaypointSequence.Waypoint(12.0, 0.0, 0.0));

        path = PathGenerator.makePath(waypoint_0, config, Constants.WHEELBASE_WIDTH, name);
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