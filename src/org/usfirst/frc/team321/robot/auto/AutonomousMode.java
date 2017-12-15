package org.usfirst.frc.team321.robot.auto;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import org.usfirst.frc.team321.robot.Constants;
import org.usfirst.frc.team321.robot.Robot;

import com.team254.lib.trajectory.Path;
import com.team254.lib.trajectory.PathGenerator;
import com.team254.lib.trajectory.TrajectoryGenerator;
import com.team254.lib.trajectory.WaypointSequence;
import com.team254.lib.trajectory.io.TextFileDeserializer;

abstract public class AutonomousMode {
	
	String autoName;
	TrajectoryGenerator.Config config;
	
	AutonomousMode(String name){
		config = new TrajectoryGenerator.Config();
		config.dt = Constants.dt;
		config.max_acc = Constants.max_acc;
		config.max_jerk = Constants.max_jerk;
		config.max_vel = Constants.max_vel;
		
		autoName = name;
	}
	
	public abstract void run();
	
	public String getName(){
		return autoName;
	}
	
	protected Path generatePath(WaypointSequence sequence){
		return PathGenerator.makePath(sequence, config, Constants.kWheelbaseWidth, getName());
	}
	
	protected Path getPathFromFile(String filename){
    	Path path = null;
		try {
			Scanner trajFile = new Scanner(new FileReader(new File(filename)));
			trajFile.useDelimiter("\\Z");
			String traj = trajFile.next();
			TextFileDeserializer tfds = new TextFileDeserializer();
			path = tfds.deserialize(traj);
		} catch (Exception e) {
			System.err.println("Path retreival from file failed");
			e.printStackTrace();
		}
		return path;
	}
}