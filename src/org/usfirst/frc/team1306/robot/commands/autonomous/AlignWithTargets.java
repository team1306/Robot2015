package org.usfirst.frc.team1306.robot.commands.autonomous;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class AlignWithTargets extends PIDCommand {

    public AlignWithTargets() {
    	super(1.0, 0.0, 0.0);
    	setInputRange(-1.0, 1.0);
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setSetpoint(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.SONIC.getVoltage() <= 0.300;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.DRIVETRAIN_SUBSYSTEM.setXTranslation(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	protected double returnPIDInput() {
		//RobotMap.DRIVETRAIN_SUBSYSTEM.getPIDController().setSetpoint(RobotMap.vision.getAngle());
		return RobotMap.vision.getXTranslation();
	}

	@Override
	protected void usePIDOutput(double output) {
		RobotMap.DRIVETRAIN_SUBSYSTEM.setXTranslation(output);
		
	}

}
