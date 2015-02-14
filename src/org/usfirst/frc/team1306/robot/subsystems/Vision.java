package org.usfirst.frc.team1306.robot.subsystems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.usfirst.frc.team1306.robot.commands.ProcessVisionImage;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Vision extends Subsystem {
	
	private static final String hostName = "10.13.6.20";
	private static final int portNumber = 5802;
	
	private Socket jetsonSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	public Vision() {
		super();
		
		SmartDashboard.putBoolean("Vision Processing", connectToCoprocessor());
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private double distance;
	
	protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ProcessVisionImage());
    }
	
    public void processImage() {
    	
    	boolean connected = (out != null);
    	if (!connected) {
    		connected = connectToCoprocessor();
    		SmartDashboard.putBoolean("Vision Processing", connected);
    	}
    	
    	if (connected) {
    		out.println("0.00");
    	
    		try {
    			distance = Double.parseDouble(in.readLine());
			} catch (Exception e) {
				SmartDashboard.putBoolean("Vision Processing", connectToCoprocessor());
				distance = 0.0;
			}
    		SmartDashboard.putNumber("Lateral Distance", distance);
    	}
    }
    
    public double getXTranslation() {
    	return distance;
    }
    
    private boolean connectToCoprocessor() {
		try {
			jetsonSocket = new Socket(hostName, portNumber);
			out = new PrintWriter(jetsonSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(jetsonSocket.getInputStream()));
			return true;
		} catch(Exception e) {
			jetsonSocket = null;
			out = null;
			in = null;
			return false;
		}
    }

}

