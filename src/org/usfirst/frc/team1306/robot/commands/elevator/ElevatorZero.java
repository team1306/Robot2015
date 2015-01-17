package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.commands.CommandBase;

public class ElevatorZero extends CommandBase{
	
	private static final int levelZero = 0;
	private final OI oi;
	
	public ElevatorZero() {
		requires(elevator);
		oi = getOI();
	}

	protected void end() {
	}


	protected void execute() {
		
		
	}


	protected void initialize() {
	elevator.goTo(levelZero);
		
	}


	protected void interrupted() {
		elevator.stop();
	}


	protected boolean isFinished() {
		
		return elevator.onTarget();
	}

	
}