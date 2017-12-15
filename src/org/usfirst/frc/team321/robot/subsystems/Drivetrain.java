package org.usfirst.frc.team321.robot.subsystems;

import org.usfirst.frc.team321.robot.Constants;
import org.usfirst.frc.team321.robot.commands.UseDrivetrain;
import org.usfirst.frc.team321.robot.utilities.LancerPID;
import org.usfirst.frc.team321.robot.utilities.Utilities;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	private Spark topLeft, midLeft, botLeft, topRight, midRight, botRight;
	private Encoder leftEncoder, rightEncoder;
	private LancerPID pid;
	
    public static final double kDistancePerRevolution = 2 * Math.PI * 4;
    public static final double kPulsesPerRevolution = 256;
    public static final double kDistancePerPulse = kDistancePerRevolution / kPulsesPerRevolution;
	
	/**
	 * Initializes drivetrain motors
	 * @param left Amount of motors on the left side
	 * @param right Amount of motors on the right side
	 */
	public Drivetrain(){
		topLeft = new Spark(Constants.TOPLEFT);
		midLeft = new Spark(Constants.MIDLEFT);
		botLeft = new Spark(Constants.BOTLEFT);
		topRight = new Spark(Constants.TOPRIGHT);
		midRight = new Spark(Constants.MIDRIGHT);
		botRight = new Spark(Constants.BOTRIGHT);
		
		topLeft.setInverted(true);
		midLeft.setInverted(true);
		botLeft.setInverted(true);
		
		leftEncoder = new Encoder(0, 1, true, EncodingType.k4X);
		rightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
		
		leftEncoder.setDistancePerPulse(kDistancePerPulse);
		rightEncoder.setDistancePerPulse(kDistancePerPulse);
		
		pid = new LancerPID(0, 0, 0);
	}
	
	public double getRightEncoderDistance(){
		return rightEncoder.getDistance();
	}
	
	public double getLeftEncoderDistance(){
		return leftEncoder.getDistance();
	}
	
	public int getRawLeftEncoderCount(){
		return leftEncoder.get();
	}
	
	public int getRawRightEncoderCount(){
		return rightEncoder.get();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UseDrivetrain());
	}
	
	public void setLeftMotors(double power) {
		power = Utilities.range(power, -1, 1);
		topLeft.set(power);
		midLeft.set(power);
		botLeft.set(power);
	}
	
	public void setRightMotors(double power) {
		power = Utilities.range(power, -1, 1);
		topRight.set(power);
		midRight.set(power);
		botRight.set(power);
	}
	
	public void setAllMotors(double power) {
		setLeftMotors(power);
		setRightMotors(power);
	}
	
}
