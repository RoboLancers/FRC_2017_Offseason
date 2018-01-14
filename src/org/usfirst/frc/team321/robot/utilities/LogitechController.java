package org.usfirst.frc.team321.robot.utilities;

import edu.wpi.first.wpilibj.buttons.Button;

public class LogitechController extends Controller {

    private static int LEFT_X_ID = 0;
    private static int LEFT_Y_ID = 1;
    private static int RIGHT_X_ID = 2;
    private static int RIGHT_Y_ID = 3;
    private static int A_ID = 2;
    private static int B_ID = 3;
    private static int X_ID = 1;
    private static int Y_ID = 4;
    private static int LT_ID = 5;
    private static int RT_ID = 6;
    private static int LB_ID = 7;
    private static int RB_ID = 8;
    private static int SELECT_ID = 9;
    private static int START_ID = 10;
    private static int LEFT_JOY_BTN_ID = 11;
    private static int RIGHT_JOY_BTN_ID = 12;
    private double tolerance = 0.10;

    public LogitechController(int port) {
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

    public Button leftJoyBtn() {
        return this.buttons[LEFT_JOY_BTN_ID];
    }

    public Button rightJoyBtn() {
        return this.buttons[RIGHT_JOY_BTN_ID];
    }

    public double getLeftYAxisValue() {
        if (Math.abs(this.joystick.getRawAxis(LEFT_Y_ID)) > tolerance) {
            return this.joystick.getRawAxis(LEFT_Y_ID);
        } else {
            return 0;
        }
    }

    public double getRawLeftYAxisValue() {
        return this.joystick.getRawAxis(LEFT_Y_ID);
    }

    public double getLeftYAxisNormalized() {
        return Utilities.squareKeepSign(getLeftYAxisValue());
    }

    public double getRightYAxisValue() {
        if (Math.abs(this.joystick.getRawAxis(RIGHT_Y_ID)) > tolerance) {
            return this.joystick.getRawAxis(RIGHT_Y_ID);
        } else {
            return 0;
        }
    }

    public double getRawRightYAxisValue() {
        return this.joystick.getRawAxis(RIGHT_Y_ID);
    }

    public double getRightYAxisNormalized() {
        return Utilities.squareKeepSign(getRightYAxisValue());
    }

    public double getLeftXAxisValue() {
        if (Math.abs(this.joystick.getRawAxis(LEFT_X_ID)) > tolerance) {
            return this.joystick.getRawAxis(LEFT_X_ID);
        } else {
            return 0;
        }
    }

    public double getRawLeftXAxisValue() {
        return this.joystick.getRawAxis(LEFT_X_ID);
    }

    public double getLeftXAxisNormalized() {
        return Utilities.squareKeepSign(getLeftXAxisValue());
    }

    public double getRightXAxisValue() {
        if (Math.abs(this.joystick.getRawAxis(RIGHT_X_ID)) > tolerance) {
            return this.joystick.getRawAxis(RIGHT_X_ID);
        } else {
            return 0;
        }
    }

    public double getRawRightXAxisValue() {
        return this.joystick.getRawAxis(RIGHT_X_ID);
    }

    public double getRightXAxisNormalized() {
        return Utilities.squareKeepSign(getRightXAxisValue());
    }
}