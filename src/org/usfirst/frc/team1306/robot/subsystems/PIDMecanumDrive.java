package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDMecanumDrive extends PIDSubsystem {
	
	private final RobotDrive robotDrive;
	private final Gyro gyro;


    // Initialize your subsystem here
    public PIDMecanumDrive() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	
    	super("Drivetrain", 0.0005, 0.0, 0.0);
    	
		robotDrive = new RobotDrive(RobotMap.FRONT_LEFT, RobotMap.REAR_LEFT, RobotMap.FRONT_RIGHT, RobotMap.REAR_RIGHT);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		
		gyro = new Gyro(RobotMap.GYRO);
		
		pidOut = 0.0;
		
	    getPIDController().setContinuous();
		setInputRange(0.0, 360.0);
		setOutputRange(-1.0, 1.0);
		setAbsoluteTolerance(5.0);
		changeSetpoint();
		
		SmartDashboard.putData("PID", getPIDController());
		
		enable();
		
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TeleopDrive());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return gyro.getAngle();
    }
    
    private double pidOut;
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
    	pidOut = -output;
    	
    }
        
    public void drive(double x, double y, double rotation) {
    	if (rotation == 0.0) {
    		rotation = pidOut;
    	} else {
    		changeSetpoint();
    	}
    	robotDrive.mecanumDrive_Cartesian(x, y, rotation, gyro.getAngle());
    	SmartDashboard.putNumber("Rotation", rotation);
    	
    	SmartDashboard.putNumber("Gyro", gyro.getAngle());
    }
    
    public void stop() {
    	robotDrive.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
    }
    
    private void changeSetpoint() {
    	setSetpoint((int)Math.round(gyro.getAngle()) % 360);
    }
}
