package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.elevator.RunElevator;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDElevator extends PIDSubsystem {

	// Initialize your subsystem here
	public PIDElevator() {
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		super("Elevator", 0.002, 0.0, 0.0);

		getPIDController().setContinuous(false);
		setInputRange(0.0, 18000.0); // range of encoder values
		setOutputRange(-1.0, 1.0); // range of motor speeds
		setAbsoluteTolerance(100.0); // tolerance in encoder ticks
		

		SmartDashboard.putData("Elevator PID", getPIDController());
		

		RobotMap.ELEVATOR_MOTOR.setSafetyEnabled(false);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new RunElevator());
	}

	/**
	 * Gets the elevator's current position
	 * @return elevator's position
	 */
	public int getPoint() {
		return RobotMap.ELEVATOR_ENCODER.get();
	}

	/**
	 * Tells elevator to go to specified encoder position
	 * @param point Target point
	 */
	public void goTo(int point) {
		if (point - getPoint() > 0 && hitTop()) {
			setSetpoint(getPoint());
		} else if (point - getPoint() < 0 && hitBottom()) {
			setSetpoint(getPoint());
		} else {
			setSetpoint(point);
		}
		enable();
	}
	
	
	public void drive(double speed) {
		if (speed == 0.0) {
			enable();
		} else {
			disable();
			setSetpoint(getPoint());
			if (speed < 0.0) {
				speed /= 4.0;
			}
			if (!(hitTop() && speed > 0 || hitBottom() && speed < 0))
				RobotMap.ELEVATOR_MOTOR.set(-speed);
		}
		SmartDashboard.putBoolean("Hit Top", hitTop());
		SmartDashboard.putBoolean("Hit Bottom", hitBottom());
		

		

	}
	public void stop() {
		drive(0.0);
	}

	/**
	 * Tells if elevator hits the top
	 * @return true if at upper limit
	 */
	public boolean hitTop() {
		return !RobotMap.ELEVATOR_TOP_LIMIT.get();
	}

	/**
	 * Tells if elevator hits the bottom
	 * @return true if at bottom limit
	 */
	public boolean hitBottom() {
		boolean hit = !RobotMap.ELEVATOR_BOTTOM_LIMIT.get();
		if (hit) {
			RobotMap.ELEVATOR_ENCODER.reset();
		}
		return hit;
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
		if (hitTop() && output > 0.0 || hitBottom() && output < 0.0) {
			output = 0.0;
		}
		RobotMap.ELEVATOR_MOTOR.set(-output);
	}
}
