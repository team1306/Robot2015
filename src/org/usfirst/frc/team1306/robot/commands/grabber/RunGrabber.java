package org.usfirst.frc.team1306.robot.commands.grabber;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RunGrabber extends Command{
	
	
	public RunGrabber() {
		// Use requires() to set subsystem dependencies
		requires(RobotMap.grabber);
	}
	
	// Runs when it no longer needs to run execute()
	protected void end() {	
	}

	// Runs after initialize(), called repeatedly when scheduled to run
	protected void execute() {
		RobotMap.grabber.drive(OI.getGrabberSpeed());
	}

	// Called the first time the command is called to run
	protected void initialize() {
	}

	// Called when another command in the subsystem is scheduled to run
	protected void interrupted() {
	}

	// Called when the command is finished
	protected boolean isFinished() {
		return false;
	}

}
