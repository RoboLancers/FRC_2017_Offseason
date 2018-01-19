package org.usfirst.frc.team321.robot.utilities.controllers;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team321.robot.utilities.Utilities;

public class XboxController extends Controller {
	
	private double tolerance = 0.1;

    private static int LEFT_X_ID = 0;
    private static int LEFT_Y_ID = 1;
    private static int LEFT_TRIGGER_ID = 2;
    private static int RIGHT_TRIGGER_ID = 3;
    private static int RIGHT_X_ID = 4;
    private static int RIGHT_Y_ID = 5;

    private static int A_ID = 1;
    private static int B_ID = 2;
    private static int X_ID = 3;
    private static int Y_ID = 4;
    private static int LEFT_BACK_ID = 5;
    private static int RIGHT_BACK_ID = 6;
    private static int SELECT_ID = 7;
    private static int START_ID = 8;
	
	public XboxController(int port) {
		super(port);
	}

    public Button a() {
		return this.buttons[A_ID];
	}

    public Button b() {
		return this.buttons[B_ID];
	}

    public Button x() {
		return this.buttons[X_ID];
	}

    public Button y() {
		return this.buttons[Y_ID];
	}

    public Button LEFT_BACK() {
        return this.buttons[LEFT_BACK_ID];
	}

    public Button RIGHT_BACK() {
        return this.buttons[RIGHT_BACK_ID];
	}
	
	public Button select() {
		return this.buttons[SELECT_ID];
	}
	
	public Button start() {
		return this.buttons[START_ID];
	}

    public double getNormalizedLeftTriggerValue() {
        double value = getRawLeftTriggerValue();
        return Math.abs(value) > tolerance ? value : tolerance;
    }

    public double getRawLeftTriggerValue() {
        return this.joystick.getRawAxis(LEFT_TRIGGER_ID);
    }

    public double getNormalizedRightTriggerValue() {
        double value = getRawRightTriggerValue();
        return Math.abs(value) > tolerance ? value : tolerance;
    }

    public double getRawRightTriggerValue() {
        return this.joystick.getRawAxis(RIGHT_TRIGGER_ID);
    }

    public double getLeftYAxisValueNormalized() {
        double value = getRawLeftYAxisValue();
        return Math.abs(value) > tolerance ? Utilities.squareKeepSign(value) : tolerance;
	}
	
	private double getRawLeftYAxisValue() {
		return this.joystick.getRawAxis(LEFT_Y_ID);
	}

    public double getRightYAxisValueNormalized() {
        double value = getRawRightYAxisValue();
        return Math.abs(value) > tolerance ? Utilities.squareKeepSign(value) : tolerance;
	}
	
	private double getRawRightYAxisValue() {
		return this.joystick.getRawAxis(RIGHT_Y_ID);
	}
	
	public double getLeftXAxisValue(){
        double value = getRawLeftXAxisValue();
        return Math.abs(value) > tolerance ? Utilities.squareKeepSign(value) : tolerance;
	}
	
	public double getRawLeftXAxisValue() {
		return this.joystick.getRawAxis(LEFT_X_ID);
	}

    public double getRightXAxisValueNormalized() {
        double value = getRawRightXAxisValue();
        return Math.abs(value) > tolerance ? Utilities.squareKeepSign(value) : tolerance;
	}
	
	public double getRawRightXAxisValue(){
		return this.joystick.getRawAxis(RIGHT_X_ID);
	}
}
