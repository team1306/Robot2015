package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.subsystems.PIDMecanumDrive;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets PIDMecanumDrive's maximum output to .25
 */
public class MaximumSpeed25 extends Command {

	/**
	 * Initializes command for 25% drive speed
	 */
    public MaximumSpeed25() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMap.DRIVETRAIN_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	PIDMecanumDrive.setMaximumSpeed(.25);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (PIDMecanumDrive.getMaximumSpeed() == .25)
        	return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
