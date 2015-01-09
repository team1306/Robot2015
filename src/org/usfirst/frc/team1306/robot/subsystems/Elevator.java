package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	
	private final DigitalInput topLimit;
	private final DigitalInput bottomLimit;
	private final DigitalInput stageOne;
	private final DigitalInput stageTwo;
	
	private final Talon elevatorMotor;
	
	private static final int direction = 1;
	private static final int level = 0;
	
	public static final int levelOne = 1; // this should be the encoder position
	public static final int levelTwo = 2;
	
	public Elevator() {
    	topLimit = new DigitalInput(RobotMap.ELEVATOR_TOP);
    	bottomLimit = new DigitalInput(RobotMap.ELEVATOR_BOTTOM);
    	
    	stageOne = new DigitalInput(RobotMap.LEVEL_ONE);
    	stageTwo = new DigitalInput(RobotMap.LEVEL_TWO);
    	
    	elevatorMotor = new Talon(RobotMap.ELEVATOR_MOTOR);
	}

    public void initDefaultCommand() {
    }
    
    public void start() {
    	elevatorMotor.set(0.0);
    }
    
    public void stop() {
    	elevatorMotor.set(0.0);
    }
    
    public void up() {
    	elevatorMotor.set(0.5*direction);
    }
    
    public void down() {
    	elevatorMotor.set(-0.5*direction);
    }
    
    public boolean hitTop() {
    	return topLimit.get();
    }
    
    public boolean hitBottom() {
    	return bottomLimit.get();
    }
    
    public int getLevel() {
    	return level;
    }
    
    public boolean hitLevel(int i) {
    	switch(i) {
    	case 0:
    		return hitBottom();
		case 1:
    		return stageOne.get();
    	case 2:
    		return stageTwo.get();
    	case 3:
    		return hitTop();
    	}
    	return false;
    }
}

