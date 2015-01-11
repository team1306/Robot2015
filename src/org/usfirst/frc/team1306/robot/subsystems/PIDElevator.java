package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.elevator.RunElevator;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDElevator extends PIDSubsystem {

	private double pidOut;

	// Initialize your subsystem here
	public PIDElevator() {
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		super("Elevator", 0.005, 0.0, 0.0);

		pidOut = 0.0;

		getPIDController().setContinuous(false);
		setInputRange(0.0, 1000.0); // range of encoder values
		setOutputRange(-1.0, 1.0); // range of motor speeds
		setAbsoluteTolerance(5.0); // tolerance in encoder ticks

		SmartDashboard.putData("Elevator PID", getPIDController());

		enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new RunElevator());
    }
    
    public int getPoint() {
    	return RobotMap.ELEVATOR_ENCODER.get();
    }
    
    public boolean done() {
    	return Math.abs(pidOut) < 0.03;
    }

    public void goTo(int point) {
    	if(point - getPoint() > 0 && hitTop()) {
    		setSetpoint(getPoint());
    	}
    	else if(point - getPoint() < 0 && hitBottom()) {
    		setSetpoint(getPoint());
    	}
    	else {
    		setSetpoint(point);
    	}
    }
    
    public boolean hitTop() {
    	return RobotMap.ELEVATOR_TOP_LIMIT.get();
    }
    
    public boolean hitBottom() {
    	return RobotMap.ELEVATOR_BOTTOM_LIMIT.get();
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return RobotMap.ELEVATOR_ENCODER.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	pidOut = output;
    	RobotMap.ELEVATOR_MOTOR.set(output);
    }
}
