package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.subsystems.Elevator;
import org.usfirst.frc.team1306.robot.subsystems.PIDMecanumDrive;
import org.usfirst.frc.team1306.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

	private static OI oi;

	public static OI getOI() {
		return oi;
	}

	// Create a single static instance of all of your subsystems
	public static PIDMecanumDrive drivetrain;
	public static Elevator elevator;
	public static Vision vision;

	public static void init() {
		// This MUST be here. If the OI creates Commands (which it very likely
		// will), constructing it during the construction of CommandBase (from
		// which commands extend), subsystems are not guaranteed to be
		// yet. Thus, their requires() statements may grab null pointers. Bad
		// news. Don't move it.
		oi = new OI();

		drivetrain = new PIDMecanumDrive();
		elevator = new Elevator();
		vision = new Vision();

		// Show what command your subsystem is running on the SmartDashboard

	}

	public CommandBase(String name) {
		super(name);
	}

	public CommandBase() {
		super();
	}
}
