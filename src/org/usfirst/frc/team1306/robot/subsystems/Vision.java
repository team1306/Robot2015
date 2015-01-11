package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.commands.ProcessImage;

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
public class Vision extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ProcessImage());
	}

	private final int session;
	private final Image frame;

	public Vision() {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		session = NIVision.IMAQdxOpenCamera("cam0",
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxConfigureGrab(session);
	}

	public void startAcquisition() {
		NIVision.IMAQdxStartAcquisition(session);
	}

	public void processImage() {
		NIVision.IMAQdxGrab(session, frame, 1);
		// NIVision.imaqDrawShapeOnImage(frame, frame, rect,
		// DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
		NIVision.imaqColorThreshold(frame, frame, 255, ColorMode.HSV,
				new Range(95, 130), new Range(245, 255), new Range(80, 170));
		// NIVision.imaqInverse(frame, frame, null);
		// SmartDashboard.putNumber("Particle Count",
		// NIVision.imaqCountParticles(frame, 8));
		
		try {
	    NIVision.imaqGetParticleInfo(frame, 1,	ParticleInfoMode.ALL_INFO);
		} catch (Exception e) {
			
		}
	    
	    /*
			if (result.array.length > 0) {
				SmartDashboard.putNumber("Particle 1 Area",
						result.array[0].area);
			}
		*/
		// NIVision.imaqConvexHull(frame, frame, 1);

		CameraServer.getInstance().setImage(frame);
	}

	public void stopAcquisition() {
		NIVision.IMAQdxStopAcquisition(session);
	}

}
