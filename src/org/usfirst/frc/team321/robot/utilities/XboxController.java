package org.usfirst.frc.team321.robot.utilities;

import edu.wpi.first.wpilibj.buttons.Button;

public class XboxController extends Controller {
	
	private double tolerance = 0.1;
	
	public static int LEFT_X_ID = 0;
	public static int LEFT_Y_ID = 1;
	public static int LT_ID = 2;
	public static int RT_ID = 3;
	public static int RIGHT_X_ID = 4;
	public static int RIGHT_Y_ID = 5;
	
	public static int A_ID = 1;
	public static int B_ID = 2;
	public static int X_ID = 3;
	public static int Y_ID = 4;
	public static int LB_ID = 5;
	public static int RB_ID = 6;
	public static int SELECT_ID = 7;
	public static int START_ID = 8;
	
	public XboxController(int port) {
		super(port);
	}
	
	public Button A() {
		return this.buttons[A_ID];
	}
	
	public Button B() {
		return this.buttons[B_ID];
	}
	
	public Button X() {
		return this.buttons[X_ID];
	}
	
	public Button Y() {
		return this.buttons[Y_ID];
	}
	
	public Button LT() {
		return this.buttons[LT_ID];
	}
	
	public Button RT() {
		return this.buttons[RT_ID];
	}
	
	public Button LB() {
		return this.buttons[LB_ID];
	}
	
	public Button RB() {
		return this.buttons[RB_ID];
	}
	
	public Button select() {
		return this.buttons[SELECT_ID];
	}
	
	public Button start() {
		return this.buttons[START_ID];
	}
	
	public double getLeftYAxisValue(){
		if(Math.abs(this.joystick.getRawAxis(LEFT_Y_ID)) > tolerance){
			return -getRawLeftYAxisValue();
		}else{
			return 0;
		}
	}
	
	private double getRawLeftYAxisValue() {
		return this.joystick.getRawAxis(LEFT_Y_ID);
	}
	
	public double getRightYAxisValue(){
		if(Math.abs(this.joystick.getRawAxis(RIGHT_Y_ID)) > tolerance){
			return -getRawRightYAxisValue();
		}else{
			return 0;
		}
	}
	
	private double getRawRightYAxisValue() {
		return this.joystick.getRawAxis(RIGHT_Y_ID);
	}
	
	public double getLeftXAxisValue(){
		if(Math.abs(this.joystick.getRawAxis(LEFT_X_ID)) > tolerance){
			return this.joystick.getRawAxis(LEFT_X_ID);
		}else{
			return 0;
		}
	}
	
	public double getRawLeftXAxisValue() {
		return this.joystick.getRawAxis(LEFT_X_ID);
	}
	
	public double getRightXAxisValue(){
		if(Math.abs(this.joystick.getRawAxis(RIGHT_X_ID)) > tolerance){
			return this.joystick.getRawAxis(RIGHT_X_ID);
		}else{
			return 0;
		}
	}
	
	public double getRawRightXAxisValue(){
		return this.joystick.getRawAxis(RIGHT_X_ID);
	}
}
