package org.usfirst.frc.team321.robot.utilities;

import edu.wpi.first.wpilibj.buttons.Button;

public class DJHero extends Controller {

	private static int TURN_TABLE = 3;
	private static int BLUE_BUTTON = 1;
	private static int GREEN_BUTTON = 2;
	private static int RED_BUTTON = 3;
	private static int BLACK_BUTTON = 4;
	
	private int multiplier = 5;
	
	public DJHero(int port) {
		super(port);
	}
	
	public Button blueButton() {
		return this.buttons[BLUE_BUTTON];
	}
	
	public Button greenButton() {
		return this.buttons[GREEN_BUTTON];
	}
	
	public Button redButton() {
		return this.buttons[RED_BUTTON];
	}
	
	public Button blackButton() {
		return this.buttons[BLACK_BUTTON];
	}
	
	public double turntable() {
		return this.joystick.getRawAxis(TURN_TABLE) * multiplier;
	}
}
