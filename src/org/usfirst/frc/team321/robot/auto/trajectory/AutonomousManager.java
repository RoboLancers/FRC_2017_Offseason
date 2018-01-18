package org.usfirst.frc.team321.robot.auto.trajectory;

import org.usfirst.frc.team321.robot.auto.trajectory.modes.*;

import java.util.ArrayList;

public class AutonomousManager {
    private ArrayList<AutonomousMode> modes = new ArrayList<>();

	AutonomousManager(){
		modes.add(new DoNothingFailsafe());
		modes.add(new DoNothing());
        modes.add(new AutoRunSide());
        modes.add(new AutoRunSideSwitch());
        modes.add(new SwitchMiddle());
	}

    public AutonomousMode getModeByName(String name) {
        return modes
                .stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(new DoNothingFailsafe());
	}
}