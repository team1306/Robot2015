package org.usfirst.frc.team1306.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDMotor extends PIDSubsystem implements SpeedController {
	private final Encoder encoder;
	private final SpeedController motor;
	private double set;
	
    // Initialize your subsystem here
	public PIDMotor(SpeedController mot, Encoder enc) {

		super("Drivetrain", 0.01, 0.0, 0.0);

		getPIDController().setContinuous();
		setInputRange(-1.0, 1.0);
		setOutputRange(-1.0, 1.0);
		setAbsoluteTolerance(1.0);
		setSetpoint(0.0);

		SmartDashboard.putData("PID", getPIDController());
		
		encoder = enc;
		motor = mot;
		set = 0.0;
		
		enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return encoder.getRate();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	double newSpeed = set + output;
    	motor.set(newSpeed);
    	set = newSpeed;
    }

	public void pidWrite(double output) {
		set(output);
	}

	public double get() {
		return set;
	}

	public void set(double speed, byte syncGroup) {
		set(speed);
	}

	public void set(double speed) {
		setSetpoint(speed);
		set = speed;
	}
}
