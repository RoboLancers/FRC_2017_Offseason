
package org.usfirst.frc.team321.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team321.robot.auto.trajectory.AutonomousEngine;
import org.usfirst.frc.team321.robot.subsystems.Drivetrain;
import org.usfirst.frc.team321.robot.subsystems.GearShifter;
import org.usfirst.frc.team321.robot.subsystems.Pneumatics;
import org.usfirst.frc.team321.robot.subsystems.Sensors;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

    public static Drivetrain leftDrive, rightDrive;
	public static Pneumatics pneumatics;
	public static Sensors sensors;
	public static GearShifter gearShifter;
	public static DashboardTable dashboardTable;
	public static OI oi;

	public static String gameData = "   ";
	public static String autoMode = "DoNothingFailsafe";

    private AutonomousEngine autoEngine;
    private Thread autoThread = null;
	private boolean autoModeRan = false;

	@Override
	public void robotInit() {
        leftDrive = new Drivetrain(false, Constants.TOPLEFT, Constants.MIDLEFT, Constants.BOTLEFT);
        rightDrive = new Drivetrain(true, Constants.TOPRIGHT, Constants.MIDRIGHT, Constants.BOTRIGHT);
		pneumatics = new Pneumatics();
		sensors = new Sensors();
		gearShifter = new GearShifter();
		dashboardTable = new DashboardTable();
		oi = new OI();

        autoEngine = new AutonomousEngine();
    }

    @Override
    public void robotPeriodic() {
        dashboardTable.update();
    }

	@Override
	public void autonomousInit() {
		dashboardTable.update();
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		autoMode = dashboardTable.getAutoMode();

        autoThread = new Thread(autoEngine);
        autoThread.start();

		autoModeRan = true;
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		if (autoModeRan) {
			autoModeRan = false;

            if (autoThread.isAlive()) {
				autoThread.interrupt();
			}else{
				System.out.println("Ending Auto");
            }
		}
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {}

	@Override
	public void teleopPeriodic() {
        if (DriverStation.getInstance().getMatchTime() < 15 && DriverStation.getInstance().isOperatorControl()) {
			SmartDashboard.putBoolean("shutdown", true);
		}

        Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
