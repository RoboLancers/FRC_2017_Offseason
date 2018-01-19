package org.usfirst.frc.team321.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SolenoidHold extends Command {
    DoubleSolenoid.Value value = null;
    private DoubleSolenoid ds;
    private boolean hasFinished = false;

    public SolenoidHold(Subsystem sub, DoubleSolenoid ds, DoubleSolenoid.Value defaultValue) {
        requires(sub);
        this.ds = ds;
        this.value = defaultValue;
    }

    protected void initialize() {
        ds.set(value == DoubleSolenoid.Value.kForward ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
        hasFinished = false;
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void interrupted() {
        ds.set(value);
        hasFinished = true;
    }
}
