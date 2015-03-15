package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.grabber.DriveRightIntake;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RightIntake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveRightIntake());
    }
    
    public void drive(double speed) {
    	RobotMap.RIGHT_INTAKE_MOTOR.set(speed);
    }
    
    public void reverse() {
    	RobotMap.RIGHT_INTAKE_MOTOR.set(-1.0);
    }
    
    public void stop() {
    	RobotMap.RIGHT_INTAKE_MOTOR.set(0.0);
    }

}

