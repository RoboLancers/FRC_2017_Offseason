package org.usfirst.frc.team321.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

import static org.usfirst.frc.team321.robot.Constants.*;

public class Drivetrain extends Subsystem {
    private WPI_TalonSRX master, slave1, slave2;

    public Drivetrain(boolean invert, int... ports) {
        master = new WPI_TalonSRX(ports[0]);
        slave1 = new WPI_TalonSRX(ports[1]);
        slave2 = new WPI_TalonSRX(ports[2]);

        setMotors(ControlMode.Follower, master.getDeviceID());

        master.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, PIDLoopIDX, TIMEOUT);
        master.configAllowableClosedloopError(PIDLoopIDX, 400, TIMEOUT);
        master.configPeakOutputForward(1, TIMEOUT);
        master.configPeakOutputReverse(-1, TIMEOUT);
        master.configNominalOutputForward(0, TIMEOUT);
        master.configNominalOutputReverse(0, TIMEOUT);
        master.configOpenloopRamp(0, TIMEOUT);
        master.configClosedloopRamp(0, TIMEOUT);
        master.setNeutralMode(NeutralMode.Brake);
        master.config_kF(PIDLoopIDX, kF, TIMEOUT);
        master.config_kP(PIDLoopIDX, kP, TIMEOUT);
        master.config_kI(PIDLoopIDX, kI, TIMEOUT);
        master.config_kD(PIDLoopIDX, kD, TIMEOUT);

        if (invert) {
            invert();
        }
    }

    public void setMotors(ControlMode mode, double value) {
        if (mode == ControlMode.Follower) {
            slave1.set(mode, value);
            slave2.set(mode, value);
        } else {
            master.set(mode, value);
        }
    }

    public void invert() {
        master.setInverted(true);
        slave1.setInverted(true);
        slave2.setInverted(true);
    }

    public WPI_TalonSRX getMaster() {
        return master;
    }

    public WPI_TalonSRX[] getSlaves() {
        WPI_TalonSRX[] slaves = new WPI_TalonSRX[2];
        slaves[0] = slave1;
        slaves[1] = slave2;

        return slaves;
    }

    @Override
    protected void initDefaultCommand() {

    }
}
