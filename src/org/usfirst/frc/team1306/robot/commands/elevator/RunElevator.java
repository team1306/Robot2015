package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Gets input from Joystick and converts it into elevator speed and direction.
 * Calculates location compared to levels and prints to SmartDashboard
 */
public class RunElevator extends Command {

	private final OI oi;

	private static int height;

	public RunElevator() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(RobotMap.elevator);
		oi = RobotMap.oi;
	}

	/**
	 * This method is called just before this Command runs the first time.
	 */
	protected void initialize() {
		RobotMap.elevator.goTo(RobotMap.elevator.getPoint());
	}

	/**
	 * This method is called repeatedly when this Command is scheduled to run.
	 */
	protected void execute() {
		if (RobotMap.elevator.hitBottom()) {
			RobotMap.ELEVATOR_ENCODER.reset();
		}
		/*if (oi.getLevel(0)) {
			elevator.goTo(levelZero);
		} else if (oi.getLevel(1)) {
			elevator.goTo(levelOne);
		} else if (oi.getLevel(2)) {
			elevator.goTo(levelTwo);
		} else if (oi.getLevel(3)) {
			elevator.goTo(levelThree);
		} else {
		*/
		RobotMap.elevator.drive(oi.elevatorDir());
		//}

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
		RobotMap.elevator.stop();
	}

	/**
	 * This method called when another command which requires one or more of the same
	 * subsystems is scheduled to run
	 */
	protected void interrupted() {
		end();
	}
}
