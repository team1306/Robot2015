package org.usfirst.frc.team1306.robot.commands.autonomous;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 * Runs driveWithPID when the claw is not closed
 * Drives forward at half speed when claw is closed
 * Stops robot movement when a tote is detected in the claw
 */
public class DriveToTote extends PIDCommand {

    public DriveToTote() {
    	super(1.0, 0.0, 0.0);
    	setInputRange(0.293, 4.885);
    	
        // Use requires() here to declare subsystem dependencies
        requires(RobotMap.DRIVETRAIN_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setSetpoint(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isClose()) {
    		RobotMap.DRIVETRAIN_SUBSYSTEM.drive(0.0, 0.5, 0.0);
    	} else {
    		RobotMap.DRIVETRAIN_SUBSYSTEM.driveWithPID();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.TOTE_SWITCH.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.DRIVETRAIN_SUBSYSTEM.setYTranslation(0.0);
    	RobotMap.DRIVETRAIN_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	protected double returnPIDInput() {
	    
		return RobotMap.SONIC.getVoltage();
	}

	@Override
	protected void usePIDOutput(double output) {
		RobotMap.DRIVETRAIN_SUBSYSTEM.setYTranslation(output);
		
	}
	
	private boolean isClose() {
		return RobotMap.SONIC.getVoltage() <= 0.300;
	}
}
