package org.usfirst.frc.team321.robot.commands;

import org.usfirst.frc.team321.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ForwardMovement extends Command{
	Timer timer = new Timer();
	double power;
	double time;
	
	public ForwardMovement(double power, double time){
		requires(Robot.drivetrain);
		this.power = power;
		this.time = time;
	}
	protected void initialize(){
		Robot.drivetrain.setAllMotors(0);
		timer.reset();
		timer.start();
		}
	
	protected void execute(){
		Robot.drivetrain.setAllMotors(power);
	}
	
	@Override
	protected boolean isFinished() {
		return (timer.get() > this.time);
	}
	protected void end(){
		Robot.drivetrain.setAllMotors(0);
	}
	protected void interrupted(){
		Robot.drivetrain.setAllMotors(0);
	}
}


