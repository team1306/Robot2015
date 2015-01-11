package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	private static final int direction = 1;

	public static final int levelOne = 1; // this should be the encoder position
	public static final int levelTwo = 2;

	public Elevator() {
	}

	public void initDefaultCommand() {
	}

	/**
	 * Call this method once to start using the elevator safely.
	 */
	public void start() {
		RobotMap.ELEVATOR_MOTOR.set(0.0);
	}

	/**
	 * Call this method once to stop using the elevator safely.
	 */
	public void stop() {
		RobotMap.ELEVATOR_MOTOR.set(0.0);
	}

	/**
	 * Move the elevator up at a fixed speed.
	 */
	public void up() {
		RobotMap.ELEVATOR_MOTOR.set(0.5 * direction);
	}

	/**
	 * Move the elevator up at a given speed.
	 * 
	 * @param speed	Speed of elevator movement
	 */
	public void up(double speed) {
		RobotMap.ELEVATOR_MOTOR.set(speed * direction);
	}

	/**
	 * Move the elevator down at a fixed speed.
	 */
	public void down() {
		RobotMap.ELEVATOR_MOTOR.set(-0.5 * direction);
	}

	/**
	 * Move the elevator down at a given speed.
	 * 
	 * @param speed	Speed of elevator movement
	 */
	public void down(double speed) {
		RobotMap.ELEVATOR_MOTOR.set(-speed * direction);
	}

	/**
	 * 
	 * @return
	 */
	public boolean hitTop() {
		return RobotMap.ELEVATOR_TOP_LIMIT.get();
	}

	public boolean hitBottom() {
		return RobotMap.ELEVATOR_BOTTOM_LIMIT.get();
	}
}
