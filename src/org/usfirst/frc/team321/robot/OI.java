package org.usfirst.frc.team321.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team321.robot.commands.SolenoidHold;
import org.usfirst.frc.team321.robot.commands.SwitchGyroDrive;
import org.usfirst.frc.team321.robot.utilities.controllers.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public XboxController drive = new XboxController(0);

    OI() {
        drive.RIGHT_BACK().whileHeld(new SolenoidHold(Robot.gearShifter, Robot.gearShifter.gearShifter, DoubleSolenoid.Value.kForward));
        drive.LEFT_BACK().whenPressed(new SwitchGyroDrive());
    }
}
