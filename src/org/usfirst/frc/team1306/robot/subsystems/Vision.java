package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.commands.ProcessVisionImage;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private double distance;
	private double angle;
	
	protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ProcessVisionImage());
    }
    
    public void processImage() {
    	//James, put communication with the coprocessor here
    }
    
    public double getDistance() {
    	return distance;
    }
    
    public double getAngle() {
    	return angle;
    }
}

