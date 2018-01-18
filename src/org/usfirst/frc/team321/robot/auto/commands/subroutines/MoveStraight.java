package org.usfirst.frc.team321.robot.auto.commands.subroutines;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.utilities.Utilities;

public class MoveStraight extends Command {

    private Timer timer = new Timer();
    private double power;
    private double seconds;
    private boolean hasFinished = false;
    private boolean useTime = false;
    private double position;
    private double targetAngle;
    private boolean hasTargetAngle = false, hasPosition = false;

    public MoveStraight(double power, double seconds, boolean time) {
        this.power = power;
        this.seconds = seconds;
        this.useTime = time;
    }

    public MoveStraight(double power, double position) {
        this.power = power;
        this.position = position;
        this.hasPosition = true;
    }

    public MoveStraight(double power, boolean useAngle, double targetAngle) {
        this.power = power;
        this.targetAngle = targetAngle;
        this.hasTargetAngle = useAngle;
    }

    protected void initialize() {
        hasFinished = false;

        if (!hasTargetAngle) {
            targetAngle = Robot.sensors.getRobotAngle();
        }

        Robot.sensors.getNavX().resetDisplacement();

        timer.reset();
        timer.start();
    }

    protected void execute() {
        if (!hasPosition) {
            double[] motorSpeed = Utilities.calcTurn(power, Robot.sensors.getRobotAngle(), targetAngle);

            Robot.leftDrive.setMotors(ControlMode.PercentOutput, motorSpeed[0]);
            Robot.rightDrive.setMotors(ControlMode.PercentOutput, motorSpeed[1]);
        } else {
            Robot.leftDrive.setMotors(ControlMode.Position, position);
            Robot.rightDrive.setMotors(ControlMode.Position, position);
        }
    }

    protected void end() {
        Robot.leftDrive.setMotors(ControlMode.PercentOutput, 0);
        Robot.rightDrive.setMotors(ControlMode.PercentOutput, 0);
        hasFinished = true;
    }

    protected void interrupted() {
        end();
    }

    protected boolean isFinished() {
        if (useTime) {
            return timer.get() > seconds;
        } else {
            return hasFinished;
        }
    }
}