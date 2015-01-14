package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.commands.CommandBase;

public class ElevatorTwo extends CommandBase{

	private static final int levelTwo = 400;
	
	public ElevatorTwo(){
		requires(elevator);
	}
	
	protected void end() {
		
	}


	protected void execute() {
		
	}


	protected void initialize() {
		elevator.goTo(levelTwo);
	}


	protected void interrupted() {
		elevator.stop();
		
	}

	@Override
	protected boolean isFinished() {
		
		return elevator.onTarget();
	}
}
