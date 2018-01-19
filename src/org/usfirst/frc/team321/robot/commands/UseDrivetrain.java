package org.usfirst.frc.team321.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team321.robot.Robot;
import org.usfirst.frc.team321.robot.utilities.Utilities;

public class UseDrivetrain extends Command {

    public static boolean gyroDrive = false;
    private boolean hasFinished;
    private double tolerance = 0.1, error;
    private boolean straight;
    private double targetHeading;

    public UseDrivetrain() {
        requires(Robot.leftDrive);
        requires(Robot.rightDrive);
        straight = false;
        hasFinished = false;
    }

    protected void initialize() {
        targetHeading = Robot.sensors.getFusedHeading();
        hasFinished = false;
    }

    protected void execute() {
        double forward = -Robot.oi.drive.getLeftYAxisValueNormalized();
        double turn = Robot.oi.drive.getRightXAxisValueNormalized();
        double leftMotorSpeed = 0, rightMotorSpeed = 0;

        if (!straight) {
            targetHeading = Robot.sensors.getFusedHeading();
        }

        if (Math.abs(forward) > tolerance || Math.abs(turn) > tolerance) {
            if (Math.abs(turn) > tolerance) {
                straight = false;
                leftMotorSpeed = Utilities.limit(forward + turn, 1);
                rightMotorSpeed = Utilities.limit(forward - turn, 1);
            } else {
                straight = true;
                error = targetHeading - Robot.sensors.getFusedHeading();
                error *= 0.2;

                leftMotorSpeed = Utilities.limit(forward + error, 1);
                rightMotorSpeed = Utilities.limit(forward - error, 1);
            }
        }

        Robot.leftDrive.setMotors(ControlMode.PercentOutput, leftMotorSpeed);
        Robot.rightDrive.setMotors(ControlMode.PercentOutput, rightMotorSpeed);
    }

    @Override
    protected boolean isFinished() {
        return hasFinished;
    }

    @Override
    protected void end() {
        hasFinished = true;
    }

    @Override
    protected void interrupted() {
        hasFinished = true;
    }
}
