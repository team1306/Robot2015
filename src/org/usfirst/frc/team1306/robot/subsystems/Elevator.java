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
	
	private final Talon elevatorMotor;
	
	private static final int direction = 1;
	
	public Elevator() {
    	topLimit = new DigitalInput(RobotMap.ELEVATOR_TOP);
    	bottomLimit = new DigitalInput(RobotMap.ELEVATOR_BOTTOM);
    	
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
}

