
package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MecanumDrive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final RobotDrive robotDrive;
	private final Accelerometer accel;
	
	public MecanumDrive() {
		robotDrive = new RobotDrive(RobotMap.FRONT_LEFT, RobotMap.REAR_LEFT, RobotMap.FRONT_RIGHT, RobotMap.REAR_RIGHT);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		
		accel = new BuiltInAccelerometer();
	}

    public void initDefaultCommand() {
        setDefaultCommand(new TeleopDrive());
    }
    
    public void drive(double x, double y, double rotation) {
    	SmartDashboard.putNumber("X", x);
    	SmartDashboard.putNumber("Y", y);
    	SmartDashboard.putNumber("Accel X", accel.getX());
    	SmartDashboard.putNumber("Accel Y", accel.getY());
    	SmartDashboard.putNumber("Accel Z", accel.getZ());
    	SmartDashboard.putNumber("Velocity", Math.sqrt(x*x + y*y));
    	robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0.0);
    }
    
    public void stop() {
    	robotDrive.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
    }
}

