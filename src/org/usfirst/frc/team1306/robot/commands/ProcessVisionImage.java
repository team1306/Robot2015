package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * THEORETICALLY turns image from camera into distance to tote
 */
public class ProcessVisionImage extends Command {

    public ProcessVisionImage() {
        // Use requires() here to declare subsystem dependencies
        requires(RobotMap.vision);
        setRunWhenDisabled(true);
    }

     //Called just before this Command runs the first time
    protected void initialize() {
    }

    
    //Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.vision.processImage();
    	SmartDashboard.putNumber("Ultrasonic", RobotMap.SONIC.getVoltage());
    	SmartDashboard.putNumber("Elevator Height", RobotMap.ELEVATOR_ENCODER.get());
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
    }

    /**Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
