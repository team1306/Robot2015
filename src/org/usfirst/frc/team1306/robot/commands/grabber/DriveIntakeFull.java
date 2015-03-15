package org.usfirst.frc.team1306.robot.commands.grabber;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveIntakeFull extends Command {

    public DriveIntakeFull() {
        // Use requires() here to declare subsystem dependencies
        requires(RobotMap.intakeLeft);
        requires(RobotMap.intakeRight);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.intakeLeft.drive(1.0);
    	RobotMap.intakeRight.drive(1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !RobotMap.TOTE_SWITCH.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.intakeLeft.stop();
    	RobotMap.intakeRight.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
