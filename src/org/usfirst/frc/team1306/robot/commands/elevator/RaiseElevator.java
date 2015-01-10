package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.commands.CommandBase;

/**
 *
 */
public class RaiseElevator extends CommandBase {
	
	private final OI oi;

	public RaiseElevator() {
    	super("Raise Elevator");
    	requires(elevator);
    	oi = getOI();
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevator.goTo(elevator.getPoint());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!elevator.hitTop() && !elevator.done()) {
    		elevator.goTo(elevator.getPoint() + (int)oi.rightTrigger()*10);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return elevator.hitTop() || (oi.rightTrigger() == 0);
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevator.goTo(elevator.getPoint());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	elevator.goTo(elevator.getPoint());
    }
}
