package org.usfirst.frc.team321.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SolenoidHold extends InstantCommand {
    public SolenoidHold(Subsystem subsystem, DoubleSolenoid doubleSolenoid, DoubleSolenoid.Value value) {
    	requires(subsystem);
        doubleSolenoid.set(value == DoubleSolenoid.Value.kForward ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
    }
}
