package org.usfirst.frc.team1306.robot;
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
	public static final int FRONT_LEFT = 3;
	public static final int REAR_LEFT = 2;
	public static final int FRONT_RIGHT = 1;
	public static final int REAR_RIGHT = 0;
	
	// Misc inputs
	public static final int ELEVATOR_BOTTOM = 0;
	public static final int ELEVATOR_TOP = 1;
	public static final int GYRO = 2;
	
	// Manipulator actuators
	public static final int ELEVATOR_MOTOR = 4;
	
	// Driver station
	public static final int LEFT_STICK = 1;
	public static final int RIGHT_STICK = 2;
	public static final int XBOX_CONTROLLER = 0;
}
