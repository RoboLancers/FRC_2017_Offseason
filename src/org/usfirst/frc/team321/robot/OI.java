package org.usfirst.frc.team321.robot;

import org.usfirst.frc.team321.robot.commands.SolenoidHold;
import org.usfirst.frc.team321.robot.subsystems.GearShifter;
import org.usfirst.frc.team321.robot.utilities.DJHero;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static DJHero drive = new DJHero(0);
	
	OI(){
		drive.blueButton().whileHeld(new SolenoidHold(Robot.gearShifter, GearShifter.gearShifter, DoubleSolenoid.Value.kForward));
		
	}
}
