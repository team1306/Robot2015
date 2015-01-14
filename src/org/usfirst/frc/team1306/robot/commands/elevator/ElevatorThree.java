package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.commands.CommandBase;

public class ElevatorThree extends CommandBase{

	private static final int levelThree = 600;
	
	public ElevatorThree(){
		requires(elevator);
	}
	
	protected void end() {
		
	}


	protected void execute() {
		
	}


	protected void initialize() {
		elevator.goTo(levelThree);
	}


	protected void interrupted() {
		elevator.stop();
		
	}

	@Override
	protected boolean isFinished() {
		
		return elevator.onTarget();
	}
}

