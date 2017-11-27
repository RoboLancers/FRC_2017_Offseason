package org.usfirst.frc.team321.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team321.robot.OI;
import org.usfirst.frc.team321.robot.Robot;

public class UseDrivetrain extends Command {
	
	public static DriveMode driveMode = DriveMode.STRAIGHT;
	
	enum DriveMode{
		STRAIGHT, TURNING
	}
	
	public UseDrivetrain() {
		requires(Robot.drivetrain);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		switch(driveMode) {
			case STRAIGHT:
				Robot.drivetrain.setAllMotors(OI.drive.turntable());
				break;
			case TURNING:
				Robot.drivetrain.setLeftMotors(OI.drive.turntable());
				Robot.drivetrain.setRightMotors(-OI.drive.turntable());
				break;
			default:
				break;
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
