package org.usfirst.frc.team1306.robot.commands.autonomous;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves from picking up autonomous yellow tote to the autonomous zone
 */
public class RevToAutoZone extends Command {

    public RevToAutoZone() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMap.DRIVETRAIN_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.DRIVE_FRONT_LEFT_ENCODER.reset();
    	RobotMap.DRIVE_FRONT_RIGHT_ENCODER.reset();
    	RobotMap.DRIVE_REAR_LEFT_ENCODER.reset();
    	RobotMap.DRIVE_REAR_RIGHT_ENCODER.reset();
    	RobotMap.DRIVETRAIN_SUBSYSTEM.stop();
    }
    
    int ticks = 9001; //Change this in testing
    boolean done = false;

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int avg = (
    			Math.abs(RobotMap.DRIVE_FRONT_LEFT_ENCODER.get()) +
    			Math.abs(RobotMap.DRIVE_FRONT_RIGHT_ENCODER.get()) +
    			Math.abs(RobotMap.DRIVE_REAR_LEFT_ENCODER.get()) +
    			Math.abs(RobotMap.DRIVE_REAR_RIGHT_ENCODER.get())) / 2 ;
    	
    	if (avg <= ticks){
    		RobotMap.DRIVETRAIN_SUBSYSTEM.drive(0.0, -1.0, 0.0);
    	} else {
    		RobotMap.DRIVETRAIN_SUBSYSTEM.stop();
    		done = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.DRIVE_FRONT_LEFT_ENCODER.reset();
    	RobotMap.DRIVE_FRONT_RIGHT_ENCODER.reset();
    	RobotMap.DRIVE_REAR_LEFT_ENCODER.reset();
    	RobotMap.DRIVE_REAR_RIGHT_ENCODER.reset();
    	RobotMap.DRIVETRAIN_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	RobotMap.DRIVE_FRONT_LEFT_ENCODER.reset();
    	RobotMap.DRIVE_FRONT_RIGHT_ENCODER.reset();
    	RobotMap.DRIVE_REAR_LEFT_ENCODER.reset();
    	RobotMap.DRIVE_REAR_RIGHT_ENCODER.reset();
    	RobotMap.DRIVETRAIN_SUBSYSTEM.stop();
    }
}
