package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDMecanumDrive extends PIDSubsystem {

	// Initialize your subsystem here
	public PIDMecanumDrive() {
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.

		super("Drivetrain", 0.0005, 0.0, 0.0);

		pidOut = 0.0;

		getPIDController().setContinuous();
		setInputRange(0.0, 360.0);
		setOutputRange(-1.0, 1.0);
		setAbsoluteTolerance(5.0);
		changeSetpoint();

		SmartDashboard.putData("PID", getPIDController());

		enable();
		

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new TeleopDrive());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return RobotMap.GYRO.getAngle();
	}

	private double pidOut;

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);

		pidOut = output;

	}

	/**
	 * Drives the robot
	 * @param x The x translation vector
	 * @param y The y translation vector
	 * @param rotation Angular velocity
	 */
	private static double maximumSpeed = 1;
	
	/**
	 * Sets the maximum output speed of the drivetrain
	 * @param speed
	 */
	public static void setMaximumSpeed(double speed){
		maximumSpeed = speed;
	}

	/**
	 * Gets the maximum output of the drivetrain
	 * @return (double) maximum speed
	 */
	public static double getMaximumSpeed(){
		return maximumSpeed;
	}
	
	public void drive(double x, double y, double rotation) {
		SmartDashboard.putBoolean("Driving", true);
		
		setOutputRange(-maximumSpeed, maximumSpeed);
		
		if (rotation == 0.0) {
			rotation = pidOut;
		} else {
			changeSetpoint();
		}
		SmartDashboard.putNumber("Rotation", rotation);
		RobotMap.DRIVETRAIN.mecanumDrive_Cartesian(-x, y, -rotation,
				RobotMap.GYRO.getAngle());

		SmartDashboard.putNumber("Gyro", RobotMap.GYRO.getAngle());
	}
	
	private double x;
	
	public void setXTranslation(double x) {
		this.x = x;
	}
	
	private double y;
	
	public void setYTranslation(double y) {
		this.y = y;
	}
	
	public void driveWithPID() {
		RobotMap.DRIVETRAIN.mecanumDrive_Cartesian(-x, y, pidOut, RobotMap.GYRO.getAngle());
	}

	/**
	 * Stops robot
	 */
	public void stop() {
		RobotMap.DRIVETRAIN.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
	}

	/**
	 * Changes setpoint to the direction the robot is currently facing
	 */
	private void changeSetpoint() {
		setSetpoint((int)Math.round(RobotMap.GYRO.getAngle()) % 360);
	}
}
