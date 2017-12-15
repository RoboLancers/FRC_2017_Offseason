package org.usfirst.frc.team321.robot;

import org.usfirst.frc.team321.robot.utilities.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static XboxController drive = new XboxController(0);
	
	public OI(){
	}
}
