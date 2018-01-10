package org.usfirst.frc.team321.robot.utilities;

import org.usfirst.frc.team321.robot.subsystems.Drivetrain;

public class Utilities {
	public static final double feetToRotations(double feet) {
		return (360 / Drivetrain.kDistancePerRevolution) * feet;
	}
	
	public static double feetPerSecondToPWM(double ftPerSec) {
		return ftPerSec * 0.05;
	}

    public static double floor(double num, int places) {
        double multiplier = Math.pow(10, places);

        num *= multiplier;

        return (int) num / multiplier;
    }

	public static double range(double value, double min, double max){
		if(value > max){
			return max;
		}else if(value < min){
			return min;
		}

		return value;
	}

    public static double squareKeepSign(double num) {
        if (num < 0) {
            return -(num * num);
        } else {
            return num * num;
        }
    }

    public static double sqrtKeepSign(double num) {
        if (num < 0) {
            return -(Math.sqrt(-num));
        } else {
            return Math.sqrt(num);
        }
    }
}
