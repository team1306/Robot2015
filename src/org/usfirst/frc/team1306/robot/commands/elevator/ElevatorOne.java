package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.commands.CommandBase;

public class ElevatorOne extends CommandBase{

	private static final int levelOne = 200;
	
	public ElevatorOne(){
		requires(elevator);
	}
	
	protected void end() {
		
	}


	protected void execute() {
		
	}


	protected void initialize() {
		elevator.goTo(levelOne);
	}


	protected void interrupted() {
		elevator.stop();
		
	}

	@Override
	protected boolean isFinished() {
		
		return elevator.onTarget();
	}

}
