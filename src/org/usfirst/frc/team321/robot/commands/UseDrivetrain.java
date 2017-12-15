package org.usfirst.frc.team321.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team321.robot.OI;
import org.usfirst.frc.team321.robot.Robot;

public class UseDrivetrain extends Command {
	
	public UseDrivetrain() {
		requires(Robot.drivetrain);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.drivetrain.setLeftMotors(OI.drive.getLeftYAxisValue());
		Robot.drivetrain.setRightMotors(OI.drive.getRightYAxisValue());
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
