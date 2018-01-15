package org.usfirst.frc.team321.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team321.robot.commands.SelectMode;
import org.usfirst.frc.team321.robot.commands.SolenoidHold;
import org.usfirst.frc.team321.robot.utilities.LogitechController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public LogitechController drive = new LogitechController(0);

    OI() {
        drive.RT().whileHeld(new SolenoidHold(Robot.gearShifter, Robot.gearShifter.gearShifter, DoubleSolenoid.Value.kForward));
        drive.Y().whenPressed(new SelectMode());
    }
}
