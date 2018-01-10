package org.usfirst.frc.team321.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

public class DashboardTable {

/*    private NetworkTableEntry matchTime, gyroAngle;
    private NetworkTableEntry autoMode;*/
	
	NetworkTable networkTable;

    DashboardTable() {
        /*NetworkTable networkTable = NetworkTableInstance.getDefault().getTable("data");
        
        matchTime = networkTable.getEntry("match/time");
        gyroAngle = networkTable.getEntry("sensors/gyroAngle");

        autoMode = networkTable.getEntry("autoMode/selectedMode");*/
    	
    	networkTable = NetworkTable.getTable("data");
    	
    	networkTable.addTableListener("autoMode/selectedMode", new ITableListener() {
			@Override
			public void valueChanged(ITable source, String key, Object value, boolean isNew) {
				Robot.autoMode = value.toString();
			}
		}, true);
    }

    public void update() {
        /*matchTime.setNumber(Timer.getMatchTime());
        gyroAngle.setNumber(Robot.sensors.getRobotAngle());*/
    	
    	networkTable.putNumber("match/time", Timer.getMatchTime());
    	Robot.autoMode = getAutoMode();
    }

    public String getAutoMode() {
        //return autoMode.getString("DoNothingFailsafe");
    	
    	return networkTable.getString("autoMode/selectedMode", "DoNothingFailsafe");
    }
}
