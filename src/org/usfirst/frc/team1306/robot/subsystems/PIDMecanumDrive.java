package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;
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

		super("Drivetrain", 0.05, 0.0, 0.02);

		pidOut = 0.0;

		getPIDController().setContinuous();
		setInputRange(0.0, 360.0);
		setOutputRange(-1.0, 1.0);
		setAbsoluteTolerance(1.0);
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
		return modulus(RobotMap.GYRO.getAngle());
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
	
	private double lastTimeTurning;
	public void drive(double x, double y, double rotation) {
		RobotMap.DRIVETRAIN.setSafetyEnabled(false);
				
		if (rotation != 0.0 || Timer.getFPGATimestamp() - lastTimeTurning < 0.5 && RobotMap.GYRO.getRate() > 5.0) {
			changeSetpoint();
		} else {
			rotation = pidOut;
		}
		SmartDashboard.putNumber("Rotation", rotation);
		SmartDashboard.putNumber("X", x);
		SmartDashboard.putNumber("Y", y);
		if(robotCenter) {
			RobotMap.DRIVETRAIN.mecanumDrive_Cartesian(-x, y, -rotation,
				0.0);
		}
		else {
			RobotMap.DRIVETRAIN.mecanumDrive_Cartesian(-x, y, -rotation,
				RobotMap.GYRO.getAngle());
		}

		SmartDashboard.putNumber("Gyro", modulus(RobotMap.GYRO.getAngle()));
		SmartDashboard.putNumber("FL Encoder", RobotMap.DRIVE_FRONT_LEFT_ENCODER.getRate());
		SmartDashboard.putNumber("RL Encoder", RobotMap.DRIVE_REAR_LEFT_ENCODER.getRate());
		SmartDashboard.putNumber("FR Encoder", RobotMap.DRIVE_FRONT_RIGHT_ENCODER.getRate());
		SmartDashboard.putNumber("RR Encoder", RobotMap.DRIVE_REAR_RIGHT_ENCODER.getRate());
	}
	
	private double x;
	
	public void setXTranslation(double x) {
		this.x = -x;
	}
	
	private double y;
	
	public void setYTranslation(double y) {
		SmartDashboard.putNumber("Y Translation", this.y);
		this.y = y;
		SmartDashboard.putNumber("Set Y Translation", this.y);
	}
	
	public void driveWithPID() {
		RobotMap.DRIVETRAIN.setSafetyEnabled(false);
		SmartDashboard.putString("Driving", x + " " + -y + " " + -pidOut);
		RobotMap.DRIVETRAIN.mecanumDrive_Cartesian(x, -y, -pidOut, RobotMap.GYRO.getAngle());
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
		setSetpoint(modulus(RobotMap.GYRO.getAngle()));
		lastTimeTurning = Timer.getFPGATimestamp();
	}
	
	private double modulus(double x) {
		while (x < 360.0) {
			x += 360.0;
		}
		while (x >= 360.0) {
			x -= 360.0;
		}
		return x;
		//return (int)Math.round(x) % 360;
	}
	
	private boolean robotCenter = false;
	
	public void toggleCenter() {
		robotCenter = !robotCenter;
	}

}
