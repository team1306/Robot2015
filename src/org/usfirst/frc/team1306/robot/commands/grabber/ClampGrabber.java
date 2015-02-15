package org.usfirst.frc.team1306.robot.commands.grabber;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Calls command to run grabber motor to close
 */
public class ClampGrabber extends Command {

    public ClampGrabber() {
        // Use requires() here to declare subsystem dependencies
        requires(RobotMap.grabber);
    }

    private double startTime;
    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.grabber.clamp();
    	startTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - startTime > 0.5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.grabber.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
