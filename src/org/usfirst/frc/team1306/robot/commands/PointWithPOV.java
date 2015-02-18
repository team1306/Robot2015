package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PointWithPOV extends Command {

    public PointWithPOV() {
        // Use requires() here to declare subsystem dependencies
        requires(RobotMap.DRIVETRAIN_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	int pov = RobotMap.oi.getPOV();
    	if (0 <= pov && pov < 360) {
    		RobotMap.DRIVETRAIN_SUBSYSTEM.setSetpoint(pov);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.DRIVETRAIN_SUBSYSTEM.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.DRIVETRAIN_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
