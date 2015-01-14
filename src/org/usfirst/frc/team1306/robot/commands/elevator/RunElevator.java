package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 *
 */
public class RunElevator extends CommandBase {

	private final OI oi;
	private static final int levelZero = 0;
	private static final int levelOne = 200;
	private static final int levelTwo = 400;
	private static final int levelThree = 600;

	private static int height;

	public RunElevator() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(elevator);
		oi = getOI();
	}

	/**
	 * This method is called just before this Command runs the first time.
	 */
	protected void initialize() {
		elevator.goTo(elevator.getPoint());
	}

	/**
	 * This method is called repeatedly when this Command is scheduled to run.
	 */
	protected void execute() {
		if (elevator.hitBottom()) {
			RobotMap.ELEVATOR_ENCODER.reset();
		}
		if (oi.getLevel(0)) {
			elevator.goTo(levelZero);
		} else if (oi.getLevel(1)) {
			elevator.goTo(levelOne);
		} else if (oi.getLevel(2)) {
			elevator.goTo(levelTwo);
		} else if (oi.getLevel(3)) {
			elevator.goTo(levelThree);
		} else {
			elevator.goTo(elevator.getPoint() + (int) (10 * oi.elevatorDir()));
		}

		height = RobotMap.ELEVATOR_ENCODER.get();
		SmartDashboard.putNumber("Elevator Height", (double) height);
		if (height == 0)
			SmartDashboard.putString("Level", "0");
		else if (height < 200 && height > 0)
			SmartDashboard.putString("Level", "0-1");
		else if (height == 200)
			SmartDashboard.putString("Level", "1");
		else if (height > 200 && height < 400)
			SmartDashboard.putString("Level", "1-2");
		else if (height == 400)
			SmartDashboard.putString("Level", "2");
		else if (height > 400 && height < 600)
			SmartDashboard.putString("Level", "2-3");
		else if (height == 600)
			SmartDashboard.putString("Level", "3");
		else
			SmartDashboard.putString("Level", "N/A");

	}

	/**
	 * This method returns true when this Command no longer needs to run execute().
	 */
	protected boolean isFinished() {
		return false;
	}

	/**
	 * This method called once after isFinished returns true.
	 */
	protected void end() {
		elevator.goTo(elevator.getPoint());
	}

	/**
	 * This method called when another command which requires one or more of the same
	 * subsystems is scheduled to run
	 */
	protected void interrupted() {
		elevator.goTo(elevator.getPoint());
	}
}
