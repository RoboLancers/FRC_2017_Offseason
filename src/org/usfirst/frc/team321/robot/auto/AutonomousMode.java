package org.usfirst.frc.team321.robot.auto;

import com.team254.lib.trajectory.Path;
import com.team254.lib.trajectory.TrajectoryGenerator;
import com.team254.lib.trajectory.io.TextFileDeserializer;
import org.usfirst.frc.team321.robot.Constants;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

abstract public class AutonomousMode {

    protected TrajectoryGenerator.Config config;
    private String autoName;

    public AutonomousMode(String name) {
		config = new TrajectoryGenerator.Config();
        config.dt = Constants.DT;
        config.max_acc = Constants.MAX_ACCELERATION;
        config.max_jerk = Constants.MAX_JERK;
        config.max_vel = Constants.MAX_VELOCITY;
		
		autoName = name;
	}
	
	public abstract void run();
	
	public String getName(){
		return autoName;
	}
	
	protected Path getPathFromFile(String filename){
    	Path path = null;

        try (Scanner trajectoryFile = new Scanner(new FileReader(new File(filename)))) {
            trajectoryFile.useDelimiter("\\Z");
            String trajectory = trajectoryFile.next();
            TextFileDeserializer textFileDeserializer = new TextFileDeserializer();
            path = textFileDeserializer.deserialize(trajectory);
        } catch (Exception e1) {
            System.err.println("Path retrieval from file failed");
            e1.printStackTrace();
        }
    	
		return path;
	}
}