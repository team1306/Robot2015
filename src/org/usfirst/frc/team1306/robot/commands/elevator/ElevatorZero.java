package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves Elevator to level 0
 */

public class ElevatorZero extends Command {
	
	private static final int levelZero = 0;
	private final OI oi;
	
	public ElevatorZero() {
		requires(RobotMap.elevator);
		oi = RobotMap.oi;
	}

	protected void end() {
	}


	protected void execute() {
		
		
	}


	protected void initialize() {
		RobotMap.elevator.goTo(levelZero);
		
	}


	protected void interrupted() {
		RobotMap.elevator.stop();
	}


	protected boolean isFinished() {
		
		return RobotMap.elevator.onTarget();
	}

	
}
