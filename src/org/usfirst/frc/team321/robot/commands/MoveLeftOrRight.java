package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class MoveLeftOrRight extends Command {

	Timer timer = new Timer();
	double time;
	double power;
	boolean wallOnLeft;
	
	public MoveLeftOrRight (double time, double power, boolean wallOnLeft) {
		requires (Robot.drivetrain);
		this.time = time;
		this.power = power;
		this.wallOnLeft = wallOnLeft;
	}
	 protected void intitialize() {
		 Robot.drivetrain.setAllMotors(0);
		 timer.reset();
		 timer.start();
	 }
	
	 protected void execute() {
		 if (wallOnLeft == true) {
			 Robot.drivetrain.setLeftMotors(-power);
			 Robot.drivetrain.setRightMotors(power);
		 } else { 
			 Robot.drivetrain.setLeftMotors(power);
			 Robot.drivetrain.setRightMotors(-power);
		 }
	 }
	@Override
	protected boolean isFinished() {
		return (timer.get() > this.time);
	} 	
	protected void end() {
		Robot.drivetrain.setAllMotors(0);
	}
	protected void interrupted () {
		Robot.drivetrain.setAllMotors(0);
	}
}
	 
	 
	 