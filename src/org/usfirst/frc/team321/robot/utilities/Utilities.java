package org.usfirst.frc.team321.robot.utilities;

import org.usfirst.frc.team321.robot.Constants;

public class Utilities {
    public static double feetToRotations(double feet) {
		return (feet * Constants.nativePerFoot) / 4096.0;
	}
	
	public static double feetPerSecondToRPM(double ftPerSec) {
		return ((ftPerSec * Constants.nativePerFoot * 60.0) / 1024.0);//Originally 4096
	}

    public static double limit(double value, double max) {
        return limit(value, -max, max);
    }

    public static double limit(double value, double min, double max) {
        return Math.min(max, Math.max(min, value));
    }

    public static double floor(double num, int places) {
        double multiplier = Math.pow(10, places);

        num *= multiplier;

        return (int) num / multiplier;
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
