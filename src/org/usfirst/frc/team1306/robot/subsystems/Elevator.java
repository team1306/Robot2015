package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	
	private final DigitalInput topLimit;
	private final DigitalInput bottomLimit;
	
	public Elevator() {
    	topLimit = new DigitalInput(RobotMap.ELEVATOR_TOP);
    	bottomLimit = new DigitalInput(RobotMap.ELEVATOR_BOTTOM);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

