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
    
    public void start() {
    	RobotMap.ELEVATOR_MOTOR.set(0.0);
    }
    
    public void stop() {
    	RobotMap.ELEVATOR_MOTOR.set(0.0);
    }
    
    public void up() {
    	RobotMap.ELEVATOR_MOTOR.set(0.5*direction);
    }
    
    public void up(double speed) {
    	RobotMap.ELEVATOR_MOTOR.set(speed*direction);
    }
    
    public void down() {
    	RobotMap.ELEVATOR_MOTOR.set(-0.5*direction);
    }
    
    public void down(double speed) {
    	RobotMap.ELEVATOR_MOTOR.set(-speed*direction);
    }
    
    public boolean hitTop() {
    	return RobotMap.ELEVATOR_TOP_LIMIT.get();
    }
    
    public boolean hitBottom() {
    	return RobotMap.ELEVATOR_BOTTOM_LIMIT.get();
    }
}

