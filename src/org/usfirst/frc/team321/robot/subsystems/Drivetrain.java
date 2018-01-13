package org.usfirst.frc.team321.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team321.robot.Constants;
import org.usfirst.frc.team321.robot.commands.UseDrivetrain;

/**
 *
 */
public class Drivetrain extends Subsystem {
	private TalonSRX masterLeft, slaveLeft1, slaveLeft2, masterRight, slaveRight1, slaveRight2;
	
	public Drivetrain() {
        masterLeft = new TalonSRX(Constants.TOPLEFT);
        slaveLeft1 = new TalonSRX(Constants.MIDLEFT);
        slaveLeft2 = new TalonSRX(Constants.BOTLEFT);

        masterRight = new TalonSRX(Constants.TOPRIGHT);
        slaveRight1 = new TalonSRX(Constants.MIDRIGHT);
        slaveRight2 = new TalonSRX(Constants.BOTRIGHT);
		
		setUpTalons();
	}

    public void setLeftMotors(ControlMode mode, double value) {
        if (mode == ControlMode.Follower) {
            slaveLeft1.set(mode, value);
            slaveLeft2.set(mode, value);
        } else {
            masterLeft.set(mode, value);
            slaveLeft1.set(mode, value);
            slaveLeft2.set(mode, value);
        }
	}

    public void setRightMotors(ControlMode mode, double value) {
        if (mode == ControlMode.Follower) {
            slaveRight1.set(mode, value);
            slaveRight2.set(mode, value);
        } else {
            masterRight.set(mode, value);
            slaveRight1.set(mode, value);
            slaveRight2.set(mode, value);
        }
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UseDrivetrain());
	}
	
	private void setUpTalons() {
        setLeftMotors(ControlMode.Follower, masterLeft.getDeviceID());
        setRightMotors(ControlMode.Follower, masterRight.getDeviceID());

        masterLeft.configPeakOutputForward(1, Constants.TIMEOUT);
        masterLeft.configPeakOutputReverse(-1, Constants.TIMEOUT);
        masterLeft.configNominalOutputForward(0, Constants.TIMEOUT);
        masterLeft.configNominalOutputReverse(0, Constants.TIMEOUT);
        masterLeft.configOpenloopRamp(0, Constants.TIMEOUT);
        masterLeft.configClosedloopRamp(0, Constants.TIMEOUT);
        masterLeft.setNeutralMode(NeutralMode.Brake);
        masterLeft.setSensorPhase(true);
        masterLeft.config_kF(Constants.PIDLoopIDX, Constants.kF, Constants.TIMEOUT);
        masterLeft.config_kP(Constants.PIDLoopIDX, Constants.kP, Constants.TIMEOUT);
        masterLeft.config_kI(Constants.PIDLoopIDX, Constants.kI, Constants.TIMEOUT);
        masterLeft.config_kD(Constants.PIDLoopIDX, Constants.kD, Constants.TIMEOUT);
        masterLeft.setInverted(true);
        slaveLeft1.setInverted(true);
        slaveLeft2.setInverted(true);

        masterRight.configPeakOutputForward(1, Constants.TIMEOUT);
        masterRight.configPeakOutputReverse(-1, Constants.TIMEOUT);
        masterRight.configNominalOutputForward(0, Constants.TIMEOUT);
        masterRight.configNominalOutputReverse(0, Constants.TIMEOUT);
        masterRight.configOpenloopRamp(0, Constants.TIMEOUT);
        masterRight.configClosedloopRamp(0, Constants.TIMEOUT);
        masterRight.setNeutralMode(NeutralMode.Brake);
        masterRight.setSensorPhase(false);
        masterRight.setInverted(false);
        masterRight.config_kF(Constants.PIDLoopIDX, Constants.kF, Constants.TIMEOUT);
        masterRight.config_kP(Constants.PIDLoopIDX, Constants.kP, Constants.TIMEOUT);
        masterRight.config_kI(Constants.PIDLoopIDX, Constants.kI, Constants.TIMEOUT);
        masterRight.config_kD(Constants.PIDLoopIDX, Constants.kD, Constants.TIMEOUT);
	}

    public TalonSRX getLeftMaster() {
		return masterLeft;
	}

    public TalonSRX getRightMaster() {
		return masterRight;
	}

    public TalonSRX getLeftSlave() {
        return slaveLeft1;
    }

    public TalonSRX getRightSlave() {
        return slaveRight1;
    }
}
