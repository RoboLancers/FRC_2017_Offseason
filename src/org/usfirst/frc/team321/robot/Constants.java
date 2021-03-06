package org.usfirst.frc.team321.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Constants {
	public static final int TOPLEFT = 5;
	public static final int MIDLEFT = 1;
	public static final int BOTLEFT = 3;
	public static final int TOPRIGHT = 8;
	public static final int MIDRIGHT = 4;
	public static final int BOTRIGHT = 2;

	public static final int COMPRESSOR = 0;
	public static final int GEARSHIFTER_FORWARD = 2;
	public static final int GEARSHIFTER_REVERSE = 3;

	public static final double WHEELBASE_WIDTH = 27 / 12.0;
    public static final double WHEEL_RADIUS = 0.1016; //In meters

	public static final double DT = 0.05;
    public static final double MAX_ACCELERATION = 4.0;
	public static final double MAX_JERK = 25.0;
    public static final double MAX_VELOCITY = 5.0;
    
	public static final int PIDLoopIDX = 0;
	public static final int TIMEOUT = 0;
	
	public static final double nativePerFoot = 3893.020921; //2172.99549;
	
	public static double kF = 0;
	public static double kP = 0;
	public static double kI = 0;
	public static double kD = 0;
}
