package org.usfirst.frc.team1306.robot.commands.grabber;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RunGrabber extends Command{
	
	public RunGrabber() {
		requires(RobotMap.grabber);
	}
	
	
	protected void end() {
		
		
	}


	protected void execute() {
		RobotMap.grabber.drive(OI.getGrabberSpeed());
	}

	
	protected void initialize() {
		
		
	}

	
	protected void interrupted() {
		
		
	}

	
	protected boolean isFinished() {
		
		return false;
	}

}
