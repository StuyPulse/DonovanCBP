package edu.wpi.first.wpilibj.templates.subsystems;

import edu.stuy.util.VictorRobotDrive;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class Drivetrain extends Subsystem {

    public RobotDrive drive;
    public Servo leftServo;
    public Servo rightServo;
    public boolean isHigh;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Drivetrain() {
        drive = new VictorRobotDrive(RobotMap.LEFT_MOTOR, RobotMap.RIGHT_MOTOR);
        drive.setSafetyEnabled(false);
        leftServo = new Servo(RobotMap.LEFT_GEAR_SHIFTER);
        rightServo = new Servo(RobotMap.RIGHT_GEAR_SHIFTER);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickTankControl());
    }

    public void tankDrive(double leftValue, double rightValue) {
        drive.tankDrive(leftValue, rightValue);
    }

    public void setGear(boolean high) {
        isHigh = high;
        leftServo.set(high?1:0);
        rightServo.set(high?1:0);
    }

    public boolean getGear() {
        return isHigh;
    }
}
