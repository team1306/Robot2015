package org.usfirst.frc.team1306.robot.subsystems;

import java.nio.ByteBuffer;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.ProcessVisionImage;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
	
	public Vision() {
		super();
		data = new byte[8];
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private double distance;
	
	protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ProcessVisionImage());
    }
    
	private byte[] data;
	
    public void processImage() {
    	
    	RobotMap.COPROCESSOR.transaction(data, data, 8);
    	
    	distance = ByteBuffer.wrap(data).getDouble();
    }
    
    public double getXTranslation() {
    	return distance;
    }

}

