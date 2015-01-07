package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.subsystems.Elevator;
import org.usfirst.frc.team1306.robot.subsystems.MecanumDrive;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

    private static OI oi;
    public static OI getOI() {
        return oi;
    }

    // Create a single static instance of all of your subsystems
    public final static MecanumDrive drivetrain = new MecanumDrive();
    public final static Elevator elevator = new Elevator();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard

        
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
