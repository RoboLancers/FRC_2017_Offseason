package org.usfirst.frc.team321.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SolenoidToggle extends InstantCommand {
    public SolenoidToggle(Subsystem subsystem, DoubleSolenoid doubleSolenoid, DoubleSolenoid.Value value) {
        requires(subsystem);

        if (value == null) {
            if (doubleSolenoid.get() == DoubleSolenoid.Value.kForward) {
                doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
            } else if (doubleSolenoid.get() == DoubleSolenoid.Value.kReverse) {
                doubleSolenoid.set(DoubleSolenoid.Value.kForward);
            }
        } else {
            doubleSolenoid.set(value);
        }
    }
}
