package org.usfirst.frc.team321.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team321.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class UseDrivetrain extends Command {
	
	public UseDrivetrain() {
		requires(Robot.drivetrain);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.drivetrain.setLeftMotors(ControlMode.PercentOutput, Robot.oi.drive.getLeftYAxisValue());
		Robot.drivetrain.setRightMotors(ControlMode.PercentOutput, Robot.oi.drive.getRightYAxisValue());
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
