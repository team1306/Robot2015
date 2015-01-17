package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.commands.UpdateDriverImage;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.ColorMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ParticleInfoMode;
import com.ni.vision.NIVision.Range;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriverCamera extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new UpdateDriverImage());
	}

	private final int session;
	private final Image frame;

	public DriverCamera() {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		session = NIVision.IMAQdxOpenCamera("cam0",
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxConfigureGrab(session);
	}

	public void startAcquisition() {
		NIVision.IMAQdxStartAcquisition(session);
	}

	public void sendImage() {
		NIVision.IMAQdxGrab(session, frame, 1);
		CameraServer.getInstance().setImage(frame);
	}

	public void stopAcquisition() {
		NIVision.IMAQdxStopAcquisition(session);
	}

}
