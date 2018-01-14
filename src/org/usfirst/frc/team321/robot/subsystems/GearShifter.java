package org.usfirst.frc.team321.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team321.robot.Constants;

public class GearShifter extends Subsystem {
	
	public DoubleSolenoid gearShifter;
	
	public GearShifter(){
		gearShifter = new DoubleSolenoid(Constants.GEARSHIFTER_FORWARD, Constants.GEARSHIFTER_REVERSE);
		gearShifter.set(DoubleSolenoid.Value.kForward);
	}
	
	public void setHighGear() {
		gearShifter.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void setLowGear() {
		gearShifter.set(DoubleSolenoid.Value.kForward);
	}
	
	public boolean isHighGear() {
		return (gearShifter.get() == DoubleSolenoid.Value.kForward);
	}

	@Override
	protected void initDefaultCommand() {
		
	}
}