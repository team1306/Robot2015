package org.usfirst.frc.team1306.robot.commands.autonomous;

import org.usfirst.frc.team1306.robot.commands.elevator.ElevatorUp;
import org.usfirst.frc.team1306.robot.commands.grabber.ClampGrabber;
import org.usfirst.frc.team1306.robot.commands.grabber.UnclampGrabber;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Picks up one tote
 * Brings it to the Auto zone
 * Sets it down
 */
public class OneToteAuto extends CommandGroup {
    
    public  OneToteAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new DriveToTote());
    	
    	addSequential(new ClampGrabber());
    	
    	addParallel(new ElevatorUp());
    	addSequential(new RevToAutoZone());
    	
    	addSequential(new UnclampGrabber());
    }
}
