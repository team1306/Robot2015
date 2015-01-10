package org.usfirst.frc.team1306.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team1306.robot.commands.CommandBase;
import org.usfirst.frc.team1306.robot.OI;

/**
 *
 */
public class DriveForward extends CommandBase {
	private final OI oi;
	
    public DriveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		oi = getOI();
    }
    
    double startTime;

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	drivetrain.drive(0.5, 0, 0);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - startTime > 1.0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
