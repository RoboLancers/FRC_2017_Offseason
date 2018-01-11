package org.usfirst.frc.team321.robot;

import com.team254.lib.trajectory.Path;
import com.team254.lib.trajectory.Trajectory;
import com.team254.lib.trajectory.Trajectory.Segment;
import edu.wpi.first.wpilibj.Notifier;
import org.usfirst.frc.team321.robot.utilities.Utilities;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class DrivetrainProfileDriver {
	private double dtSeconds;
	private ArrayList<Segment> leftVelPts, rightVelPts;
	private int numPoints;
	private Trajectory lt, rt;
	private boolean running = false, done = false;
	private long step;
	private boolean runBACKWARDS = false;
	private AtomicBoolean interrupt = new AtomicBoolean(false);

    public DrivetrainProfileDriver(Path path) {
        //this.path = path;
        this.leftVelPts = new ArrayList<Segment>();
        this.rightVelPts = new ArrayList<Segment>();
        //store the velocity pts
        numPoints = path.getLeftWheelTrajectory().getNumSegments();
        lt = path.getLeftWheelTrajectory();
        rt = path.getRightWheelTrajectory();
        dtSeconds = lt.getSegment(0).dt;
        for (int i = 0; i < numPoints; i++) {
            leftVelPts.add(lt.getSegment(i));
            rightVelPts.add(rt.getSegment(i));
        }
    }

    Notifier pointExecutor = new Notifier(new PeriodicRunnable());

	private class PeriodicRunnable implements java.lang.Runnable {
		private long startTime;
		private boolean firstTime;

		public PeriodicRunnable() {
			firstTime = true;
		}

		private Segment invertSegment(Segment s) {
			return new Segment(-s.pos, -s.vel, -s.acc, -s.jerk, s.heading, s.dt, s.x, s.y);
		}

		public void run() {
	    	if (firstTime) {
	    		firstTime = false;
	    		startTime = System.currentTimeMillis();
	    		running = true;
	    		done = false;
	    	}
	    	step = (System.currentTimeMillis() - startTime) / (long)(dtSeconds * 1000);
	    	//System.out.print("step: " + step);
	    	try {
                if (interrupt.get()) throw new Exception("Interrupting profile");

	    		if (runBACKWARDS){
                    Robot.drivetrain.setLeftMotors(Utilities.feetPerSecondToPWM(rightVelPts.get((int) step).vel));
	    			Robot.drivetrain.setLeftMotors(Utilities.feetPerSecondToPWM(leftVelPts.get((int)step).vel));
	    		} else {
	    			Robot.drivetrain.setLeftMotors(-Utilities.feetPerSecondToPWM(leftVelPts.get((int)step).vel));
	    			Robot.drivetrain.setRightMotors(-Utilities.feetPerSecondToPWM(rightVelPts.get((int)step).vel));
	    		}
	    	} catch (Exception e) {
	    		pointExecutor.stop();
	    		running = false;
	    		done = true;
	    		if (runBACKWARDS) runBACKWARDS = false;
	    	}
	    }
	}
	
	public void interruptProfile() {
		interrupt.set(true);
	}

	public boolean isRunning() {
		return running;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void followPathBACKWARDS() {
		runBACKWARDS = true;
		pointExecutor.startPeriodic(dtSeconds / 2.0);
	}
	
	public void followPath() {
		runBACKWARDS = false;
		System.out.println("pointExecutor.startPeriodic(" + dtSeconds / 2.0);
		pointExecutor.startPeriodic(dtSeconds / 2.0);
	}	
}
