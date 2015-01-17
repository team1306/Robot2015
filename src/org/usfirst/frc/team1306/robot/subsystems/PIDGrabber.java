package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.elevator.RunGrabber;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDGrabber extends PIDSubsystem{

	private double pidOut;
	
	public PIDGrabber(){
		
		super("Grabber", 0.00005, 0.0, 0.0);
		
		pidOut = 0.0;
		
		getPIDController().setContinuous(false);
		setInputRange(0.0, 1000.0);
		setOutputRange(-1.0, 1.0);
		setAbsoluteTolerance(5.0);
		
		SmartDashboard.putData("Grabber PID", getPIDController());
		
		enable();
	}

	
	protected double returnPIDInput() {
		
		return RobotMap.GRABBER_ENCODER.get();
	}


	protected void usePIDOutput(double arg0) {
		
	}

	
	protected void initDefaultCommand() {
		
		setDefaultCommand(new RunGrabber());
	}
}
