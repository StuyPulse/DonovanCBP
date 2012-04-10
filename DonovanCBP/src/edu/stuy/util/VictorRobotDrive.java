/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.stuy.util;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author 694
 */
public class VictorRobotDrive extends RobotDrive{

    public VictorRobotDrive(int leftMotor, int rightMotor) {
        super(new Victor(leftMotor), new Victor(rightMotor));
    }

    public void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
        m_isCANInitialized = false;
        super.setLeftRightMotorOutputs(leftOutput, rightOutput);
    }
}
