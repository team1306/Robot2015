package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.OI;

/**
 *
 */
public class LowerElevator extends CommandBase {
	
	private final OI oi;

    public LowerElevator() {
        requires(elevator);
        oi = new OI();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevator.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!elevator.hitBottom()) {
    		elevator.down();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return elevator.hitTop() || (oi.rightTrigger() == 0);
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	elevator.stop();
    }
}
