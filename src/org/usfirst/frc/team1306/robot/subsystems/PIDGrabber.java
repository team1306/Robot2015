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

	/**
	 * Returns the current value of the encoder
	 * 
	 * @return (double) Grabber encoder value
	 */
	protected double returnPIDInput() {
		
		return RobotMap.GRABBER_ENCODER.get();
	}
	
	protected void usePIDOutput(double arg0) {
		
	}
	/**
	 * Sets the default command to be used to RunGrabber (Continuous)
	 */
	protected void initDefaultCommand() {
		
		//setDefaultCommand(new RunGrabber());
	}
	
	/**
	 * Returns point at which the encoder is
	 * @return (int) Grabber encoder value
	 */
	public int getPoint(){
		return RobotMap.GRABBER_ENCODER.get();
	}
	/**
	 * Sets motor to go forwards to clamp grabber
	 */
	public void clamp() {
		RobotMap.GRABBER_MOTOR.set(1.0);
	}
	/**
	 * Sets motor to go backwards to unclamp grabber
	 */
	public void unclamp() {
		RobotMap.GRABBER_MOTOR.set(-1.0);
	}
	/**
	 * Drives grabber at the given speed in the param
	 * @param speed
	 */
	public void drive(double speed){
		RobotMap.GRABBER_MOTOR.set(speed);
	}
}
