package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorUp extends Command {

    public ElevatorUp() {
        // Use requires() here to declare subsystem dependencies
        requires(RobotMap.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.elevator.goTo(SETPOINT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.elevator.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    private static final int SETPOINT = 5000;
}
