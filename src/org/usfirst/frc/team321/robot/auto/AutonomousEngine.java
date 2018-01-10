package org.usfirst.frc.team321.robot.auto;

import org.usfirst.frc.team321.robot.Robot;

public class AutonomousEngine implements Runnable {
	private AutonomousManager autonomousManager;
	private String mode;

	public AutonomousEngine() {
		mode = "DoNothingFailsafe";
		autonomousManager = new AutonomousManager();
	}
	
	@Override
	public void run() {
		mode = Robot.dashboardTable.getAutoMode();
		autonomousManager.getModeByName(mode).run();
	}
}