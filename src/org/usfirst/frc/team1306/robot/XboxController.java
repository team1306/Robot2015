package org.usfirst.frc.team1306.robot;

import edu.wpi.first.wpilibj.Joystick;

public class XboxController extends Joystick{

    public XboxController(int port) {
        super(port);
    }
    
    public double getX(Hand hand) {
        if (hand.equals(Hand.kLeft)) {
            return -getRawAxis(0);
        } else {
            return -getRawAxis(4);
        }
    }
    
    public double getY(Hand hand) {
        if (hand.equals(Hand.kLeft)) {
            return -getRawAxis(1);
        } else {
            return -getRawAxis(5);
        }
    }
    
    public final static int A = 1;
    public final static int B = 2;
    public final static int X = 3;
    public final static int Y = 4;
    public final static int LB = 5;
    public final static int RB = 6;
    public final static int BACK = 7;
    public final static int START = 8;
    public final static int LS = 9;
    public final static int RS = 10;
}
