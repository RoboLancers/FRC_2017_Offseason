package org.usfirst.frc.team321.robot.utilities;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public abstract class Controller {
	Joystick joystick;
	Button[] buttons;
	
	Controller(int port){
		this.joystick = new Joystick(port);
		this.initializeButtons();
	}
	
	void initializeButtons() {
		buttons = new JoystickButton[13];
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JoystickButton(joystick, i);
		}
	}
}
