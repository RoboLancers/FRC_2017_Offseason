package org.usfirst.frc.team321.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCode extends CommandGroup {
 
	public AutoCode () {
		addSequential (new ForwardMovement (1, 3));
		addSequential(new MoveLeftOrRight (1, 0.5, true));
		
	}
}
