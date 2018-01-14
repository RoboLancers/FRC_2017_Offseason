package org.usfirst.frc.team321.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team321.robot.Constants;
import org.usfirst.frc.team321.robot.commands.RegulateCompressor;

public class Pneumatics extends Subsystem {

	private Compressor compressor;
	
	public Pneumatics() {
		compressor = new Compressor(Constants.COMPRESSOR);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new RegulateCompressor());
	}
	
	public void regulateCompressor(){
    	if(!compressor.getPressureSwitchValue() && !compressor.enabled()
    			&& isCompressorSafeToUse()){
    		compressor.start();
    	}else if(compressor.getPressureSwitchValue() && compressor.enabled() 
    			|| !isCompressorSafeToUse()){
    		compressor.stop();
    	}
    }

	private boolean isCompressorSafeToUse() {
		return (!compressor.getCompressorCurrentTooHighFault() || compressor.getCompressorCurrentTooHighStickyFault()) &&
				(!compressor.getCompressorNotConnectedFault() || compressor.getCompressorNotConnectedStickyFault()) &&
				(!compressor.getCompressorShortedFault() || compressor.getCompressorShortedStickyFault());
	}	
	
	public boolean getPressure(){
		return compressor.getPressureSwitchValue();
	}
	
}
