package org.usfirst.frc.team321.robot;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;

public class DashboardTable {

    private NetworkTableEntry autoModeEntry, matchTimeEntry;

    DashboardTable() {
        NetworkTableInstance networkTableInstance = NetworkTableInstance.getDefault();
        NetworkTable networkTable = networkTableInstance.getTable("data");

        autoModeEntry = networkTable.getEntry("/autoMode/selectedMode");
        matchTimeEntry = networkTable.getEntry("/match/time");

        networkTable.addEntryListener("", (table, key, entry, value, flags) -> {
            Robot.autoMode = value.getString();
        }, EntryListenerFlags.kUpdate);
    }

    public void update() {
        matchTimeEntry.forceSetDouble(Timer.getMatchTime());
        Robot.autoMode = getAutoMode();
    }

    public String getAutoMode() {
        return autoModeEntry.getString("DoNothingFailsafe");
    }
}
