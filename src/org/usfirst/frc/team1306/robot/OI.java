package org.usfirst.frc.team1306.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
    private final Joystick leftStick;
    private final Joystick rightStick;
    private final XboxController xbox;

    private final Button buttonA;
    private final Button buttonB;
    private final Button buttonX;
    private final Button buttonY;
    private final Button buttonLB;
    private final Button buttonRB;
    private final Button buttonBack;
    private final Button buttonStart;
    private final Button buttonLS;
    private final Button buttonRS;
    
    public OI() {
    	
        leftStick = new Joystick(1);
        rightStick = new Joystick(2);
        xbox = new XboxController(0);

        buttonA = new JoystickButton(xbox, XboxController.A);
        buttonB = new JoystickButton(xbox, XboxController.B);
        buttonX = new JoystickButton(xbox, XboxController.X);
        buttonY = new JoystickButton(xbox, XboxController.Y); 
        buttonLB = new JoystickButton(xbox, XboxController.LB);
        buttonRB = new JoystickButton(xbox, XboxController.RB);
        buttonBack = new JoystickButton(xbox, XboxController.BACK);
        buttonStart = new JoystickButton(xbox, XboxController.START);
        buttonLS = new JoystickButton(xbox, XboxController.LS);
        buttonRS = new JoystickButton(xbox, XboxController.RS);
        
    }
    
    //X axis for left side is moveX
    public double moveX() {
    	return deadband(xbox.getX(GenericHID.Hand.kLeft));
    }

    //Y axis for left side is moveY
    public double moveY() {
    	return deadband(xbox.getY(GenericHID.Hand.kLeft));
    }
    
    public double rotation() {
    	return deadband(xbox.getX(GenericHID.Hand.kRight));
    }
    
    public double leftTrigger() {
    	return deadband(xbox.getLeftTrigger());
    }
    
    public double rightTrigger() {
    	return deadband(xbox.getRightTrigger());
    }
    
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
}

