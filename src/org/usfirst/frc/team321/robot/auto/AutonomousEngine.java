package org.usfirst.frc.team321.robot.auto;

import org.usfirst.frc.team321.robot.Robot;

public class AutonomousEngine implements Runnable {
	private AutonomousManager autonomousManager;

	public AutonomousEngine() {
		autonomousManager = new AutonomousManager();
	}
	
	@Override
	public void run() {
		Robot.autoMode = Robot.dashboardTable.getAutoMode();
		autonomousManager.getModeByName(Robot.autoMode).run();
	}
}