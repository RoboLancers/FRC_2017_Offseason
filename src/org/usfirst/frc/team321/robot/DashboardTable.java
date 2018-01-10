package org.usfirst.frc.team321.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;

public class DashboardTable {

    private NetworkTableEntry matchTime, gyroAngle;
    private NetworkTableEntry autoMode;

    DashboardTable() {
        NetworkTable networkTable = NetworkTableInstance.getDefault().getTable("data");

        matchTime = networkTable.getEntry("match/time");
        gyroAngle = networkTable.getEntry("sensors/gyroAngle");

        autoMode = networkTable.getEntry("autoMode/selectedMode");
    }

    public void update() {
        matchTime.setNumber(Timer.getMatchTime());
        gyroAngle.setNumber(Robot.sensors.getRobotAngle());
    }

    public String getAutoMode() {
        return autoMode.getString("DoNothingFailsafe");
    }
}
