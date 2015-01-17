package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorThree extends Command{

	private static final int levelThree = 600;
	
	public ElevatorThree(){
		requires(RobotMap.elevator);
	}
	
	protected void end() {
		
	}


	protected void execute() {
		
	}


	protected void initialize() {
		RobotMap.elevator.goTo(levelThree);
	}


	protected void interrupted() {
		RobotMap.elevator.stop();
		
	}

	@Override
	protected boolean isFinished() {
		
		return RobotMap.elevator.onTarget();
	}
}

