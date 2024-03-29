package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sends image from camera to the driver station
 */
public class UpdateDriverImage extends Command {

	public UpdateDriverImage() {
		setRunWhenDisabled(true);
		
		// Use requires() here to declare subsystem dependencies
		requires(RobotMap.camera);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		RobotMap.camera.startAcquisition();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		RobotMap.camera.sendImage();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		RobotMap.camera.stopAcquisition();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
