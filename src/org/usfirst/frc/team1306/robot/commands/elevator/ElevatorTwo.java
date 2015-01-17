package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorTwo extends Command{

	private static final int levelTwo = 400;
	
	public ElevatorTwo(){
		requires(RobotMap.elevator);
	}
	
	protected void end() {
		
	}


	protected void execute() {
		
	}


	protected void initialize() {
		RobotMap.elevator.goTo(levelTwo);
	}


	protected void interrupted() {
		RobotMap.elevator.stop();
		
	}

	@Override
	protected boolean isFinished() {
		
		return RobotMap.elevator.onTarget();
	}
}
