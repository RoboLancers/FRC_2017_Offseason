package org.usfirst.frc.team321.robot.utilities;

public class LancerPID {
	
	private double kP, kI, kD;
	private double setpoint, integral, lastError;
	
	public LancerPID(double p, double i, double d){
		this.kP = p;
		this.kI = i;
		this.kD = d;
		
		setpoint = 0;
		integral = 0;
		lastError = 0;
	}
	
	public void setSetpoint(double setpoint){
		this.setpoint = setpoint;
		
		integral = 0;
		lastError = 0;
	}
	
	public double getOutput(double current){
		double error, derivative, output;
		
		error = setpoint - current;
		
		derivative = error - lastError;
		
		output = (kP * error) + (kI * integral) + (kD * derivative);
		
		if(output > 1){
			output = 1;
		}else if(output < -1){
			output = -1;
		}else{
			integral += error;
		}
		
		lastError = error;
		
		return output;
	}
}
