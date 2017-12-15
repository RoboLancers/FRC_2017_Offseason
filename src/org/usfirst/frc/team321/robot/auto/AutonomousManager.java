package org.usfirst.frc.team321.robot.auto;

import java.util.ArrayList;

import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.Constants;
import org.usfirst.frc.team321.robot.DrivetrainProfileDriver;

import com.team254.lib.trajectory.Path;
import com.team254.lib.trajectory.PathGenerator;
import com.team254.lib.trajectory.TrajectoryGenerator;
import com.team254.lib.trajectory.WaypointSequence;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousManager {
	  
	Robot robot;
	public ArrayList<AutonomousMode> modes = new ArrayList<AutonomousMode>();

	AutonomousManager(Robot robot){
		this.robot = robot;
		
		modes.add(new DoNothingFailsafe());
		modes.add(new DoNothing());
		modes.add(new CrossBaseline(robot));
		//modes.add(new CenterPeg(robot));
	}
	
	public AutonomousMode getModeByName(String name){
		for (AutonomousMode mode : modes){
			if (mode.getName().equals(name))
				return mode;
		}
		
		try {
			throw new Exception();
		} catch (Exception e) {
			System.err.println("Mode not found");
			e.printStackTrace();
			return new DoNothingFailsafe();
		}
	}
	
	public AutonomousMode getModeByIndex (int index){
		try {
			return modes.get(index);
		} catch (IndexOutOfBoundsException e){
			System.err.println("Mode out of array bounds");
			e.printStackTrace();
			return new DoNothingFailsafe();
		}
	}
/*
	public class CenterPeg extends AutonomousMode {
		
		Path path;
		CenterPeg(Robot r) {
			super(r);
			TrajectoryGenerator.Config config = new TrajectoryGenerator.Config();
			config.dt = .05;
			config.max_acc = 4.5; //prev 5.0
			config.max_jerk = 25.0;
			config.max_vel = 7.0;
			
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0.0, 0.0, 0.0));
			p.addWaypoint(new WaypointSequence.Waypoint(7.3, 0.0, 0.0));
			
			path = PathGenerator.makePath(p, config, Constants.kWheelbaseWidth, "CenterPeg");
		}

		@Override
		public void run() {
			
			try{ Thread.sleep(250);} catch(Exception e){System.out.println("Error waiting for shifters to shift...");}
			
			//Path path = this.getPathFromFile("/home/lvuser/centerPeg.txt");
			
			DrivetrainProfileDriver driver = new DrivetrainProfileDriver(path);
			driver.followPathBACKWARDS();
			
			try {
				while (!driver.isDone()) { 
					System.out.println("   Finnegan is a dunce!! BIG THINGS!!!!!    ;)");
					Thread.sleep(20); 
				}
				robot.gearHandler.setDoors(Constants.gearOpen);
				Thread.sleep(750);
				robot.leftTrans.set(-60);
				robot.rightTrans.set(60);
				Thread.sleep(400);
				robot.leftTrans.set(0);
				robot.rightTrans.set(0);
				robot.gearHandler.setDoors(Constants.gearClosed);
				robot.shifter.set(Constants.highGear);
				robot.leftTrans.setHighGear(true, false);
				robot.rightTrans.setHighGear(true, false);
			} catch (Exception e) {}
		}

		@Override
		public String getName() {
			return "CenterPeg";
		}
		
	}*/
	
	public class DoNothing extends AutonomousMode {
		
		DoNothing(){
			
		}

		@Override
		public void run() {
			System.out.println("Explicitly told not to move");
		}

		@Override
		public String getName() {
			return "DoNothing";
		}
		
	}
	

	public class DoNothingFailsafe extends AutonomousMode {
		
		DoNothingFailsafe(){
			
		}

		@Override
		public void run() {
			System.out.println("This shouldn't be running - Mode 0 selected for some reason");
		}

		@Override
		public String getName() {
			return "DoNothingFailsafe";
		}
		
	}
	
	public class CrossBaseline extends AutonomousMode {

		Path path;
		CrossBaseline(Robot r) {
			super(r);
			TrajectoryGenerator.Config config = new TrajectoryGenerator.Config();
			config.dt = .05;
			config.max_acc = 9.0;//4.5; //prev 5.0
			config.max_jerk = 25.0;
			config.max_vel = 10.0;//5.0;
			
			WaypointSequence p = new WaypointSequence(10);
			p.addWaypoint(new WaypointSequence.Waypoint(0.0, 0.0, 0.0));
			p.addWaypoint(new WaypointSequence.Waypoint(14.0, 0.0, 0.0));
			
			path = PathGenerator.makePath(p, config, Constants.kWheelbaseWidth, "CrossBaseline");
		}
		@Override
		public void run() {
			
			try{ Thread.sleep(250);} catch(Exception e){System.out.println("Error waiting for shifters to shift...");}
			
			DrivetrainProfileDriver driver = new DrivetrainProfileDriver(path);
			driver.followPathBACKWARDS();
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "CrossBaseline";
		}
		
	}
}