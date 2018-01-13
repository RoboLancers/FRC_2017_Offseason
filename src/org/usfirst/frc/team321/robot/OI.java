package org.usfirst.frc.team321.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.usfirst.frc.team321.robot.commands.DSolenoidHold;
import org.usfirst.frc.team321.robot.commands.SolenoidHold;
import org.usfirst.frc.team321.robot.subsystems.GearShifter;
import org.usfirst.frc.team321.robot.utilities.LogitechController;
import org.usfirst.frc.team321.robot.utilities.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public LogitechController drive = new LogitechController(0);

    OI() {
        drive.RT().whileHeld(new DSolenoidHold(Robot.gearShifter, Robot.gearShifter.gearShifter, DoubleSolenoid.Value.kForward));
	}
}
