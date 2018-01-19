package org.usfirst.frc.team321.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class SwitchGyroDrive extends InstantCommand {
    public SwitchGyroDrive() {
        UseDrivetrain.gyroDrive = !UseDrivetrain.gyroDrive;
    }
}
