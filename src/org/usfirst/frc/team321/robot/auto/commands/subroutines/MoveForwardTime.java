package org.usfirst.frc.team321.robot.auto.commands.subroutines;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team321.robot.Robot;

public class MoveForwardTime extends Command {

    public double power;
    public double seconds;
    public boolean hasFinished = false;
    private Timer timer = new Timer();

    public MoveForwardTime(double power, double seconds) {
        this.power = power;
        this.seconds = seconds;
    }

    protected void initialize() {
        hasFinished = false;
        timer.reset();
        timer.start();
    }

    protected void execute() {
        Robot.leftDrive.setMotors(ControlMode.PercentOutput, power);
        Robot.rightDrive.setMotors(ControlMode.PercentOutput, power);
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
        return timer.get() > seconds;
    }

}