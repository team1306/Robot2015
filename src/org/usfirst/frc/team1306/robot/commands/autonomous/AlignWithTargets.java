package org.usfirst.frc.team1306.robot.commands.autonomous;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AlignWithTargets extends PIDCommand {

	Command driveToTote;
	
    public AlignWithTargets() {
    	super(0.6, 0.0, 1.0);
    	SmartDashboard.putData("Alignment", getPIDController());
    	
        driveToTote = new DriveToTote();
    	setInputRange(-3.0, 3.0);
    	getPIDController().setAbsoluteTolerance(0.3);
    	getPIDController().setOutputRange(-0.8, 0.8);
        // Use requires() here to declare subsystem dependencies
    	
    	startedDriving = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setSetpoint(0.0);
    }
    
    private boolean startedDriving;

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putBoolean("Close?", DriveToTote.isClose());
    	
    	if (!DriveToTote.isClose()) {
    		RobotMap.DRIVETRAIN_SUBSYSTEM.driveWithPID();
    		SmartDashboard.putBoolean("On Target", getPIDController().onTarget());
        	if (getPIDController().onTarget() && !driveToTote.isRunning()) {
        		driveToTote.start();
        		startedDriving = true;
        	}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return startedDriving && !driveToTote.isRunning();
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
		//return RobotMap.vision.getXTranslation();
		return 0.0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// may need to negate this value
		RobotMap.DRIVETRAIN_SUBSYSTEM.setXTranslation(output);
		SmartDashboard.putNumber("translation", output);
		
	}

}
