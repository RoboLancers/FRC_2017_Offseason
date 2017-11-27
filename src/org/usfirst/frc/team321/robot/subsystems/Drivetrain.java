package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.robot.commands.UseDrivetrain;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	Spark topLeft, midLeft, botLeft, topRight, midRight, botRight;
	
	/**
	 * Intitializes drivetrain motors
	 * @param left Amount of motors on the left side
	 * @param right Amount of motors on the right side
	 */
	public Drivetrain(){
		topLeft = new Spark(RobotMap.TOPLEFT);
		midLeft = new Spark(RobotMap.MIDLEFT);
		botLeft = new Spark(RobotMap.BOTLEFT);
		topRight = new Spark(RobotMap.TOPRIGHT);
		midRight = new Spark(RobotMap.MIDRIGHT);
		botRight = new Spark(RobotMap.BOTRIGHT);
		
		topLeft.setInverted(true);
		midLeft.setInverted(true);
		botLeft.setInverted(true);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UseDrivetrain());
	}
	
	public void setLeftMotors(double power) {
		topLeft.set(power);
		midLeft.set(power);
		botLeft.set(power);
	}
	
	public void setRightMotors(double power) {
		topRight.set(power);
		midRight.set(power);
		botRight.set(power);
	}
	
	public void setAllMotors(double power) {
		setLeftMotors(power);
		setRightMotors(power);
	}
	
}
