package org.usfirst.frc.team321.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Notifier;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

import java.util.concurrent.atomic.AtomicBoolean;

public class PathfinderFollower {
    private Notifier pointExecutor = new Notifier(new PathfinderFollower.PeriodicRunnable());
    private EncoderFollower left, right;
    private boolean running = false, done = false;
    private long step;
    private AtomicBoolean interrupt = new AtomicBoolean(false);

    public PathfinderFollower(TankModifier modifier) {
        left = new EncoderFollower(modifier.getLeftTrajectory());
        right = new EncoderFollower(modifier.getRightTrajectory());

        left.configureEncoder(Robot.leftDrive.getMaster().getSelectedSensorPosition(Constants.PIDLoopIDX), 1024, Constants.WHEEL_RADIUS * 2);
        left.configurePIDVA(Constants.kP, Constants.kI, Constants.kD, 1 / Constants.MAX_VELOCITY, 0);

        right.configureEncoder(Robot.rightDrive.getMaster().getSelectedSensorPosition(Constants.PIDLoopIDX), 1024, Constants.WHEEL_RADIUS * 2);
        right.configurePIDVA(Constants.kP, Constants.kI, Constants.kD, 1 / Constants.MAX_VELOCITY, 0);
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isDone() {
        return done;
    }

    public void followPath() {
        System.out.println("pointExecutor.startPeriodic(" + Constants.DT / 2.0 + ")");
        pointExecutor.startPeriodic(Constants.DT / 2.0);
    }

    private class PeriodicRunnable implements java.lang.Runnable {
        public void run() {
            double l = left.calculate(Robot.leftDrive.getMaster().getSelectedSensorPosition(Constants.PIDLoopIDX));
            double r = right.calculate(Robot.leftDrive.getMaster().getSelectedSensorPosition(Constants.PIDLoopIDX));

            double gyro_heading = Robot.sensors.getRobotHeading();
            double desired_heading = Pathfinder.r2d(left.getHeading());

            double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
            double turn = 0.8 * (-1.0 / 80.0) * angleDifference;

            Robot.leftDrive.setMotors(ControlMode.PercentOutput, l + turn);
            Robot.rightDrive.setMotors(ControlMode.PercentOutput, r - turn);
        }
    }
}
