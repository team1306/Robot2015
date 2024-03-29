package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MecanumDrive extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public MecanumDrive() {
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}

	public void drive(double x, double y, double rotation) {
		SmartDashboard.putNumber("X", x);
		SmartDashboard.putNumber("Y", y);
		RobotMap.DRIVETRAIN.mecanumDrive_Cartesian(-x, y, -rotation, 0.0);
	}

	public void stop() {
		RobotMap.DRIVETRAIN.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
	}
}
