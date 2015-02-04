package org.usfirst.frc.team1306.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.RobotMap;

/**
 * Drives robot forward as long at the timer is above 1
 */
public class DriveForward extends Command {
	private final OI oi;

	public DriveForward() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		oi = RobotMap.oi;
	}

	double startTime;

	// Called just before this Command runs the first time
	protected void initialize() {
		startTime = Timer.getFPGATimestamp();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		RobotMap.DRIVETRAIN_SUBSYSTEM.drive(0.5, 0, 0);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Timer.getFPGATimestamp() - startTime > 1.0;
	}

	// Called once after isFinished returns true
	protected void end() {
		RobotMap.DRIVETRAIN_SUBSYSTEM.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
