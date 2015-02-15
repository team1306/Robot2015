package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetGyro extends Command {

    public ResetGyro() {
        // Use requires() here to declare subsystem dependencies
        requires(RobotMap.DRIVETRAIN_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.GYRO.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(RobotMap.GYRO.getAngle()) <= 0.5;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
