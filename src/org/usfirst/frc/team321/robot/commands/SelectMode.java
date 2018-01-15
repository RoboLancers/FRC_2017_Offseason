package org.usfirst.frc.team321.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team321.robot.Robot;

public class SelectMode extends InstantCommand {
    public SelectMode() {
        Robot.pathfinderEngine.selectMode();
    }
}
