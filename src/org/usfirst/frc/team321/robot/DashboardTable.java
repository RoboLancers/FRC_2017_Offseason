package org.usfirst.frc.team321.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

@SuppressWarnings("deprecation")
public class DashboardTable {

    private NetworkTable networkTable;

    DashboardTable() {

        networkTable = NetworkTable.getTable("data");

        networkTable.addTableListener("autoMode/selectedMode", (source, key, value, isNew) -> Robot.autoMode = value.toString(), true);
        networkTable.addTableListener(new ITableListener() {
			
			@Override
			public void valueChanged(ITable source, String key, Object value, boolean isNew) {
				Robot.autoMode = source.getString("autoMode/selectedMode", "DoNothingFailsafe");
				if(key.equals("autoMode/selectedMode")){
					Robot.autoMode = key.toString();
				}
			}
		}, true);
    }

    public void update() {
        networkTable.putNumber("match/time", Timer.getMatchTime());
        Robot.autoMode = getAutoMode();
    }

    public String getAutoMode() {
        return networkTable.getString("autoMode/selectedMode", "DoNothingFailsafe");
    }
}
