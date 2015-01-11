package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.OI;

/**
 *
 */
public class TeleopDrive extends CommandBase {
	
	private final OI oi;

	public TeleopDrive() {
		super("Drive");
		// Use requires() here to declare subsystem dependencies
		requires(drivetrain);
		oi = getOI();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	/**
	 * This method is called repeatedly when this command is run.
	 * It takes the values of the joysticks on the drive xbox controller
	 * and turns it into movements for the mecanum drivetrain.
	 */
	protected void execute() {
		drivetrain.drive(oi.moveX(), oi.moveY(), oi.rotation());
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
		drivetrain.stop();
	}

	/**
	 * Called when another command which requires one or more of the same
	 * subsystems is scheduled to run.
	 */
	protected void interrupted() {
		drivetrain.stop();
	}
}
