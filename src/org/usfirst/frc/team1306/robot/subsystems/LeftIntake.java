package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.grabber.DriveLeftIntake;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LeftIntake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveLeftIntake());
    }
    
    public void drive(double speed) {
    	RobotMap.LEFT_INTAKE_MOTOR.set(speed);
    }
    
    public void reverse() {
    	RobotMap.LEFT_INTAKE_MOTOR.set(-1.0);
    }
    
    public void stop() {
    	RobotMap.LEFT_INTAKE_MOTOR.set(0.0);
    }
}

