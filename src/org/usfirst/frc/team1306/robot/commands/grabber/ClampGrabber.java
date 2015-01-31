package org.usfirst.frc.team1306.robot.commands.grabber;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Calls command to run grabber motor to close
 */
public class ClampGrabber extends Command {

    public ClampGrabber() {
        // Use requires() here to declare subsystem dependencies
        requires(RobotMap.grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.grabber.clamp();
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
    	// Sets point to the current point so that the movement is discontinued
    	RobotMap.grabber.setSetpoint(RobotMap.GRABBER_ENCODER.get());
    }
}
