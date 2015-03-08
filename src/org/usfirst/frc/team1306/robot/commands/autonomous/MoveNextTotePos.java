package org.usfirst.frc.team1306.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1306.robot.RobotMap;

/**
 * Moves from one yellow tote to the next yellow tote in autonomous mode
 */
public class MoveNextTotePos extends Command {

    public MoveNextTotePos() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMap.DRIVETRAIN_SUBSYSTEM);
    }

    //Fiddle with these values until we find something that works
    double slope = 1.0;
    double inter = 0.5;
    
    int pol = 1;
    
    private double startTime;
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double time = Timer.getFPGATimestamp() - startTime;
    	double aspd = (slope * time) + inter;
    		RobotMap.DRIVETRAIN_SUBSYSTEM.drive(Math.min(pol * aspd, 1.0), 0.0, 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return RobotMap.vision.getXTranslation() != 0.0;
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
