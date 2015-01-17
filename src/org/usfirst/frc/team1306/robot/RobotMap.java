package org.usfirst.frc.team1306.robot;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	// Drive train motors
	public static Talon DRIVE_FRONT_LEFT;
	public static Talon DRIVE_REAR_LEFT;
	public static Talon DRIVE_FRONT_RIGHT;
	public static Talon DRIVE_REAR_RIGHT;

	public static RobotDrive DRIVETRAIN;

	// Misc inputs
	public static DigitalInput ELEVATOR_BOTTOM_LIMIT;
	public static DigitalInput ELEVATOR_TOP_LIMIT;
	public static Gyro GYRO;
	public static Accelerometer ACCEL;

	// Manipulator actuators
	public static Talon ELEVATOR_MOTOR;
	public static Encoder ELEVATOR_ENCODER;
	public static Talon GRABBER_MOTOR;
	public static Encoder GRABBER_ENCODER;

	static {
		DRIVE_FRONT_LEFT = new Talon(3);
		DRIVE_REAR_LEFT = new Talon(2);
		DRIVE_FRONT_RIGHT = new Talon(1);
		DRIVE_REAR_RIGHT = new Talon(0);

		DRIVETRAIN = new RobotDrive(DRIVE_FRONT_LEFT, DRIVE_REAR_LEFT,
				DRIVE_FRONT_RIGHT, DRIVE_REAR_RIGHT);
		DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
		DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		ELEVATOR_BOTTOM_LIMIT = new DigitalInput(0);
		ELEVATOR_TOP_LIMIT = new DigitalInput(1);
		GYRO = new Gyro(0);
		ACCEL = new BuiltInAccelerometer();

		ELEVATOR_MOTOR = new Talon(4);
		ELEVATOR_ENCODER = new Encoder(2, 3);
		
		GRABBER_MOTOR = new Talon(5);
		GRABBER_ENCODER = new Encoder(4, 5);
		

	}
}
