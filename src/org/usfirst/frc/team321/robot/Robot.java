
package org.usfirst.frc.team321.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team321.robot.auto.AutonomousEngine;
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
public class Robot extends IterativeRobot {

	public static Drivetrain drivetrain;
	public static Pneumatics pneumatics;
	public static Sensors sensors;
	public static GearShifter gearShifter;
	public static DashboardTable dashboardTable;
	public static OI oi;

	public static String gameData = "";
	public static String autoMode = "";

	private AutonomousEngine autoEngine;
	private Thread autoThread;
	private boolean autoModeRan = false;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain = new Drivetrain();
		pneumatics = new Pneumatics();
		sensors = new Sensors();
		gearShifter = new GearShifter();
		dashboardTable = new DashboardTable();
		oi = new OI();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		dashboardTable.update();
		if (autoModeRan) {
			autoModeRan = false;

			if (autoThread.isAlive()) {
				autoThread.interrupt();
			}
		}
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *  nnx7]
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		dashboardTable.update();
		autoMode = dashboardTable.getAutoMode();
		
		autoEngine = new AutonomousEngine();
		autoThread = new Thread(autoEngine);
		autoThread.start();
		autoModeRan = true;
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		dashboardTable.update();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		dashboardTable.update();

		double seconds_remaining = DriverStation.getInstance().getMatchTime();
		if (seconds_remaining > 15) {
			SmartDashboard.putBoolean("shutdown", true);
		}
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}
