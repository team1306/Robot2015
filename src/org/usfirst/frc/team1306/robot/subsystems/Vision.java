package org.usfirst.frc.team1306.robot.subsystems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.ProcessVisionImage;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
	
	private static final String hostName = "10.13.6.5";
	private static final int portNumber = 5800;
	
	private Socket jetsonSocket;
	private PrintWriter out;
	private BufferedReader in, stdIn;
	
	public Vision() {
		super();
		
		try {
			jetsonSocket = new Socket(hostName, portNumber);
			out = new PrintWriter(jetsonSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(jetsonSocket.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
		} catch(Exception e) {
			jetsonSocket = null;
			out = null;
			in = null;
			stdIn = null;
			e.printStackTrace();
		}
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private double distance;
	
	protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ProcessVisionImage());
    }
	
    public void processImage() {
    	out.print(String(RobotMap.rangeFinder.get()));
    	
    	distance = Double.parseDouble(in.readLine());
    }
    
    public double getXTranslation() {
    	return distance;
    }

}

