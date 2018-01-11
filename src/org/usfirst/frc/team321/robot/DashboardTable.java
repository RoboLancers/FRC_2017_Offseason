package org.usfirst.frc.team321.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

@SuppressWarnings("deprecation")
public class DashboardTable {

    private NetworkTable networkTable;

    DashboardTable() {

        networkTable = NetworkTable.getTable("data");

        networkTable.addTableListener("autoMode/selectedMode", (source, key, value, isNew) -> Robot.autoMode = value.toString(), true);
    }

    public void update() {
        networkTable.putNumber("match/time", Timer.getMatchTime());
        Robot.autoMode = getAutoMode();
    }

    public String getAutoMode() {
        return networkTable.getString("autoMode/selectedMode", "DoNothingFailsafe");
    }
}
