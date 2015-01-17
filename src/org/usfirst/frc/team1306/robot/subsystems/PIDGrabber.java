package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.grabber.RunGrabber;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDGrabber extends PIDSubsystem{
	
	public PIDGrabber(){
		
		super("Grabber", 0.0005, 0.0, 0.0);
		
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
	
	public int getPoint(){
		return RobotMap.GRABBER_ENCODER.get();
	}
	
	public void clamp() {
		RobotMap.GRABBER_MOTOR.set(1.0);
	}
	
	public void unclamp() {
		RobotMap.GRABBER_MOTOR.set(-1.0);
	}
	
	public void drive(double speed){
		RobotMap.GRABBER_MOTOR.set(speed);
	}
}
