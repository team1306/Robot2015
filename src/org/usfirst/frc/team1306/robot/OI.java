package org.usfirst.frc.team1306.robot;

import org.usfirst.frc.team1306.robot.commands.ResetGyro;
import org.usfirst.frc.team1306.robot.commands.grabber.ClampGrabber;
import org.usfirst.frc.team1306.robot.commands.grabber.UnclampGrabber;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	private final XboxController xboxDrive;
	private final XboxController xboxAux;

	//private final Button buttonADrive;
	//private final Button buttonBDrive;
	//private final Button buttonXDrive;
	//private final Button buttonYDrive;
	//private final Button buttonLBDrive;
	//private final Button buttonRBDrive;
	//private final Button buttonBackDrive;
	private final Button buttonStartDrive;
	//private final Button buttonLSDrive;
	//private final Button buttonRSDrive;

	//private final Button buttonAAux;
	//private final Button buttonBAux;
	//private final Button buttonXAux;
	//private final Button buttonYAux;
	//private final Button buttonLBAux;
	//private final Button buttonRBAux;
	private final Button buttonBackAux;
	private final Button buttonStartAux;
	//private final Button buttonLSAux;
	//private final Button buttonRSAux;

	public OI() {

		xboxDrive = new XboxController(0);
		xboxAux = new XboxController(1);

		//buttonADrive = new JoystickButton(xboxDrive, XboxController.A);
		//buttonBDrive = new JoystickButton(xboxDrive, XboxController.B);
		//buttonXDrive = new JoystickButton(xboxDrive, XboxController.X);
		//buttonYDrive = new JoystickButton(xboxDrive, XboxController.Y);
		//buttonLBDrive = new JoystickButton(xboxDrive, XboxController.LB);
		//buttonRBDrive = new JoystickButton(xboxDrive, XboxController.RB);
		//buttonBackDrive = new JoystickButton(xboxDrive, XboxController.BACK);
		buttonStartDrive = new JoystickButton(xboxDrive, XboxController.START);
		//buttonLSDrive = new JoystickButton(xboxDrive, XboxController.LS);
		//buttonRSDrive = new JoystickButton(xboxDrive, XboxController.RS);

		//buttonAAux = new JoystickButton(xboxAux, XboxController.A);
		//buttonBAux = new JoystickButton(xboxAux, XboxController.B);
		//buttonXAux = new JoystickButton(xboxAux, XboxController.X);
		//buttonYAux = new JoystickButton(xboxAux, XboxController.Y);
		//buttonLBAux = new JoystickButton(xboxAux, XboxController.LB);
		//buttonRBAux = new JoystickButton(xboxAux, XboxController.RB);
		buttonBackAux = new JoystickButton(xboxAux, XboxController.BACK);
		buttonStartAux = new JoystickButton(xboxAux, XboxController.START);
		//buttonLSAux = new JoystickButton(xboxAux, XboxController.LS);
		//buttonRSAux = new JoystickButton(xboxAux, XboxController.RS);
		
		buttonStartAux.whenPressed(new ClampGrabber());
		buttonBackAux.whenPressed(new UnclampGrabber());
		
		buttonStartDrive.whenPressed(new ResetGyro());

	}

	/**
	 * Gets the speed at which the grabber should be moving
	 * @return grabber speed (double)
	 */
	public double getGrabberSpeed() {
		return xboxAux.getRT() - xboxAux.getLT();
	}
	
	/**
	 * Sets the left rumble of the Xbox controller to a value between 0 and 1
	 */
	public void setRumble(double x) {
		xboxDrive.setRumble(RumbleType.kLeftRumble, (float)x);
	}


	/**
	 * Returns the direction to be moved in the x-axis based on the displacement
	 * in the x-axis of the left hand joystick.
	 * 
	 * @return X component of movement
	 */
	public double moveX() {
		double multiplier = 1.0 - (1.0 - PRECISION_SPEED) * xboxDrive.getLT();
		return multiplier * deadband(xboxDrive.getX(Hand.kLeft));
	}

	/**
	 * Returns the direction to be moved in the y-axis based on the displacement
	 * in the y-axis of the left hand joystick.
	 * 
	 * @return Y component of movement
	 */
	public double moveY() {
		double multiplier = 1.0 - (1.0 - PRECISION_SPEED) * xboxDrive.getLT();
		return multiplier * deadband(xboxDrive.getY(Hand.kLeft));
	}

	/**
	 * Returns the amount of rotation specified by the movement in the x-axis of
	 * the right hand joystick.
	 * 
	 * @return Amount of rotation
	 */
	public double rotation() {
		double multiplier = 1.0 - (1.0 - PRECISION_SPEED) * xboxDrive.getRT();
		return multiplier * deadband(xboxDrive.getX(Hand.kRight));
	}

	/**
	 * Returns how fast and in what direction the elevator should go based on
	 * the y-axis of the right joystick of the auxiliary xbox controller.
	 * 
	 * @return Elevator movement
	 */
	public double elevatorDir() {
		return deadband(xboxAux.getY(Hand.kRight));
	}

	/**
	 * Returns if a given button is pressed, specifying which to which level the
	 * elevator should go.
	 * 
	 * @param level
	 *            Which level's button to check
	 * @return State of button
	 */
	/*public boolean getLevel(int level) {
		switch (level) {
		case 0:
			return buttonYAux.get();
		case 1:
			return buttonBAux.get();
		case 2:
			return buttonAAux.get();
		case 3:
			return buttonXAux.get();
		}
		return false;
	}
	*/

	/**
	 * Returns the input rounded to zero within the pre-specified deadband.
	 * 
	 * @param value
	 *            Initial value to be rounded
	 * @return Rounded value
	 */
	private double deadband(double original) {
		if (original < -DEADBAND) {
			return (original + DEADBAND) / (1.0 - DEADBAND);
		} else if (original > DEADBAND) {
			return (original - DEADBAND) / (1.0 - DEADBAND);
		} else {
			return 0.0;
		}
	}

	private static final double DEADBAND = 0.15;
	private static final double PRECISION_SPEED = 0.25;

}
