package org.usfirst.frc.team1306.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1306.robot.RobotMap;

/**
 * Moves from one yellow tote to the next yellow tote in autonomous mode
 */
public class MoveNextToteNeg extends Command {

    public MoveNextToteNeg() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMap.DRIVETRAIN_SUBSYSTEM);
    }

    //Fiddle with these values until we find something that works
    double slope = 1;
    double inter = 0.5;
    int end = 300;
    
    int pol = -1;
    boolean done = false;
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.DRIVE_FRONT_LEFT_ENCODER.reset();
    	RobotMap.DRIVE_FRONT_RIGHT_ENCODER.reset();
    	RobotMap.DRIVE_REAR_LEFT_ENCODER.reset();
    	RobotMap.DRIVE_REAR_RIGHT_ENCODER.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double avg = (Math.abs(RobotMap.DRIVE_FRONT_LEFT_ENCODER.get()) + Math.abs(RobotMap.DRIVE_FRONT_RIGHT_ENCODER.get()) + Math.abs(RobotMap.DRIVE_REAR_LEFT_ENCODER.get()) + Math.abs(RobotMap.DRIVE_REAR_RIGHT_ENCODER.get())) / 4;
    	double aspd = (slope * avg) + inter;
    	double bspd = (-slope * (avg - end)) + inter;
    	if (aspd < 1){
    		RobotMap.DRIVETRAIN_SUBSYSTEM.drive(pol * aspd, 0.0, 0.0);
    	} else if (bspd >= 1) {
    		RobotMap.DRIVETRAIN_SUBSYSTEM.drive((double)pol, 0.0, 0.0);
    	} else if (bspd < 1){
    		RobotMap.DRIVETRAIN_SUBSYSTEM.drive(pol * bspd, 0.0, 0.0);
    	} else if (bspd == inter){
    		done = true;
    		RobotMap.DRIVETRAIN_SUBSYSTEM.drive(0.0, 0.0, 0.0);
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
    	RobotMap.DRIVETRAIN_SUBSYSTEM.drive(0.0, 0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	RobotMap.DRIVE_FRONT_LEFT_ENCODER.reset();
    	RobotMap.DRIVE_FRONT_RIGHT_ENCODER.reset();
    	RobotMap.DRIVE_REAR_LEFT_ENCODER.reset();
    	RobotMap.DRIVE_REAR_RIGHT_ENCODER.reset();
    	RobotMap.DRIVETRAIN_SUBSYSTEM.drive(0.0, 0.0, 0.0);
    }
}