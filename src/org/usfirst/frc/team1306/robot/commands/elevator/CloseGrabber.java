package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.commands.CommandBase;

/**
 *
 */
public class CloseGrabber extends CommandBase {

    public CloseGrabber() {
        // Use requires() here to declare subsystem dependencies
        requires(grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	grabber.close();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
