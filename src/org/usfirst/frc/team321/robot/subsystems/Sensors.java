package org.usfirst.frc.team321.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;
import org.usfirst.frc.team321.robot.utilities.Utilities;

public class Sensors {
    private AHRS navX;

    public Sensors() {
        navX = new AHRS(SerialPort.Port.kMXP);

        navX.reset();
        navX.resetDisplacement();
    }

    public double getRobotAngle() {
        return Utilities.floor(navX.getAngle(), 2);
    }

    public double getRobotHeading() {
        if (navX.getAngle() < 0) {
            return Utilities.floor(360 - Math.abs(navX.getAngle() % 360), 2);
        } else {
            return Utilities.floor(navX.getAngle() % 360, 2);
        }
    }

    public double getRobotVelocity() {
        return Utilities.floor(Math.hypot(navX.getVelocityX(), navX.getVelocityY()), 2);
    }

    public double getRobotDisplacement() {
        return Utilities.floor(Math.hypot(navX.getDisplacementX(), navX.getDisplacementY()), 2);
    }
}
