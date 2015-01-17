package org.usfirst.frc.team1306.robot.commands;

/**
 *
 */
public class UpdateImage extends CommandBase {

	public UpdateImage() {
		// Use requires() here to declare subsystem dependencies
		requires(vision);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		vision.startAcquisition();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		vision.sendImage();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		vision.stopAcquisition();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		vision.stopAcquisition();
	}
}
