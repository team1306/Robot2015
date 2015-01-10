package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.CommandBase;

/**
 *
 */
public class RunElevator extends CommandBase {

	private final OI oi;
	private static final int levelZero = 0;
	private static final int levelOne = 200;
	private static final int levelTwo = 400;
	private static final int levelThree = 600;
	
    public RunElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(elevator);
    	oi = getOI();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevator.goTo(elevator.getPoint());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(elevator.hitBottom()) {
    		RobotMap.ELEVATOR_ENCODER.reset();
    	}
    	if(oi.getLevel(0)) {
    		elevator.goTo(levelZero);
    	}
    	else if(oi.getLevel(1)) {
    		elevator.goTo(levelOne);
    	}
    	else if(oi.getLevel(2)) {
    		elevator.goTo(levelTwo);
    	}
    	else if(oi.getLevel(3)) {
    		elevator.goTo(levelThree);
    	}
    	else {
    		elevator.goTo(elevator.getPoint() + (int)(10*oi.elevatorDir()));
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
