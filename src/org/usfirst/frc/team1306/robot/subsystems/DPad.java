package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class DPad extends Trigger {
    
    public boolean get() {
        return RobotMap.oi.getPOV() >= 0;
    }
}
