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

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		drivetrain.drive(oi.moveX(), oi.moveY(), oi.rotation());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		drivetrain.stop();
	}
}
