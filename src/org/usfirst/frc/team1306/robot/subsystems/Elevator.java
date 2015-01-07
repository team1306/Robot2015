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
	
	public Elevator() {
    	topLimit = new DigitalInput(RobotMap.ELEVATOR_TOP);
    	bottomLimit = new DigitalInput(RobotMap.ELEVATOR_BOTTOM);
    	
    	elevatorMotor = new Talon(RobotMap.ELEVATOR_MOTOR);
	}

    public void initDefaultCommand() {
    }
    
    public void start() {
    	
    }
    
    public void stop() {
    	
    }
    
    public void raise() {
    	
    }
    
    public void lower() {
    	
    }
}

