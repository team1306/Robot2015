package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.subsystems.Grabber;
import org.usfirst.frc.team1306.robot.subsystems.PIDElevator;
import org.usfirst.frc.team1306.robot.subsystems.PIDMecanumDrive;
import org.usfirst.frc.team1306.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

	private static OI oi;

	// Create a single static instance of all of your subsystems
	public static final PIDMecanumDrive drivetrain = new PIDMecanumDrive();
	public static final PIDElevator elevator = new PIDElevator();
	public static final Grabber grabber = new Grabber();
	public static final Vision vision = new Vision();

	public static void init() {
		// This MUST be here. If the OI creates Commands (which it very likely
		// will), constructing it during the construction of CommandBase (from
		// which commands extend), subsystems are not guaranteed to be
		// yet. Thus, their requires() statements may grab null pointers. Bad
		// news. Don't move it.
		oi = new OI();

	}

	public CommandBase(String name) {
		super(name);
	}

	public CommandBase() {
		super();
	}

	public static OI getOI() {
		return oi;
	}
}
