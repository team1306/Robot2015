package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves Elevator to level 1
 */
public class ElevatorOne extends Command {

	private static final int levelOne = 200;
	
	public ElevatorOne(){
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(RobotMap.elevator);
	}
	
	/**
	 * This method is called just before this Command runs the first time.
	 */
	protected void initialize() {
		RobotMap.elevator.goTo(levelOne);
	}
	
	/**
	 * This method is called repeatedly when this Command is scheduled to run.
	 */
	protected void execute() {
		
	}
	
	/**
	 * This method returns true when this Command no longer needs to run execute().
	 */
	protected boolean isFinished() {
		return RobotMap.elevator.onTarget();
	}

	/**
	 * This method called once after isFinished returns true.
	 */
	protected void end() {
		
	}

	/**
	 * This method called when another command which requires one or more of the same
	 * subsystems is scheduled to run
	 */
	protected void interrupted() {
		RobotMap.elevator.stop();
	}
}
