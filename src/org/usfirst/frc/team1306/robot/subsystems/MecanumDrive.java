
package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MecanumDrive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final RobotDrive robotDrive;
	
	public MecanumDrive() {
		robotDrive = new RobotDrive(RobotMap.FRONT_LEFT, RobotMap.REAR_LEFT, RobotMap.FRONT_RIGHT, RobotMap.REAR_RIGHT);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new TeleopDrive());
    }
    
    public void drive(double x, double y, double rotation) {
    	robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0.0);
    }
    
    public void stop() {
    	robotDrive.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
    }
}

