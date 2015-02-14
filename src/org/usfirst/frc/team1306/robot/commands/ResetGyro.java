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

    private double startTime;
    private boolean isGyroReset;
    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = Timer.getFPGATimestamp();
    	isGyroReset = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (Timer.getFPGATimestamp() - startTime > 0.5 && !isGyroReset) {
    		RobotMap.GYRO.reset();
    		setInterruptible(false);
    		isGyroReset = true;
    	}
    	RobotMap.DRIVETRAIN_SUBSYSTEM.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - startTime > 1.5;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
