package org.usfirst.frc.team321.robot.auto.Pathfinder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PathfinderEngine implements Runnable {
    int mode, step;
    private PathManager pathManager;

    public PathfinderEngine() {
        mode = 1;
        step = 0;
        pathManager = new PathManager();
    }

    public void displayMode() {
        SmartDashboard.putNumber("autoMode", mode);
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int i) {
        mode = i;
        saveMode();
        displayMode();
    }

    public void saveMode() {
        try {
            PrintWriter p = new PrintWriter(new File("/home/lvuser/autoMode.txt"));
            p.printf("%d", mode);
            p.flush();
            p.close();
        } catch (Exception e) {

        }
    }

    public void selectMode() {
        if (++mode > (pathManager.getPaths().size() - 1)) mode = 1;
        saveMode();
        displayMode();
    }

    public void loadSavedMode() {
        try {
            FileInputStream fin = new FileInputStream("/home/lvuser/autoMode.txt");
            Scanner s = new Scanner(fin);
            if (s.hasNextInt()) mode = s.nextInt();
            else mode = 0;
            fin.close();
        } catch (Exception e) {
            mode = 0;
        }
        displayMode();
    }

    @Override
    public void run() {
        pathManager.getPathByIndex(mode).run();
    }
}