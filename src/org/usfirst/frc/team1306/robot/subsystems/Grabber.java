package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {

	public Grabber() {
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void open() {
		RobotMap.GRABBER_RESIZER.set(Value.kReverse);
	}

	public void close() {
		RobotMap.GRABBER_RESIZER.set(Value.kForward);
	}
	
	public void clamp() {
		RobotMap.GRABBER_CLAMP.set(Value.kForward);
	}
	
	public void unclamp() {
		RobotMap.GRABBER_CLAMP.set(Value.kReverse);
	}
}
