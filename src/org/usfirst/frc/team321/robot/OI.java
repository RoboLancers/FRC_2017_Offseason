package org.usfirst.frc.team321.robot;

import org.usfirst.frc.team321.robot.commands.SolenoidHold;
import org.usfirst.frc.team321.robot.utilities.XboxController;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public XboxController drive = new XboxController(0);
	
	public OI(){
		drive.A().whenPressed(new SolenoidHold(Robot.pneumatics, Robot.gearShifter.gearShifter, DoubleSolenoid.Value.kForward));
	}
}
