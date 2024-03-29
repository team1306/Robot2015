package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Turns off the drivetrain safety
 * Gets the X and Y acceleration values and converts them into Xbox rumble
 * Moves the drivetrain with the two Xbox joysticks
 */
public class TeleopDrive extends Command {

	private final OI oi;

	public TeleopDrive() {
		
		super("Drive");
		// Use requires() here to declare subsystem dependencies
		requires(RobotMap.DRIVETRAIN_SUBSYSTEM);
		oi = RobotMap.oi;
		
		SmartDashboard.putBoolean("Trying to Drive", true);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		RobotMap.GYRO.reset();
		RobotMap.DRIVETRAIN_SUBSYSTEM.setSetpoint(0.0);
		RobotMap.DRIVETRAIN.setSafetyEnabled(false);
	}

	/**
	 * This method is called repeatedly when this command is run.
	 */
	protected void execute() {

		RobotMap.DRIVETRAIN_SUBSYSTEM.drive(oi.moveX(), oi.moveY(), oi.rotation());
	}

	/**
	 * This method returns true when this Command no longer needs to run execute()
	 */
	protected boolean isFinished() {
		return false;
	}

	/**
	 * Called once after isFinished returns true.
	 */
	protected void end() {
		RobotMap.DRIVETRAIN_SUBSYSTEM.stop();
	}

	/**
	 * Called when another command which requires one or more of the same
	 * subsystems is scheduled to run.
	 */
	protected void interrupted() {
		end();
	}
}
