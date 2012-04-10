package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;


    /* Tank Drive */
    public static final int RIGHT_JOYSTICK_PORT = 1;
    public static final int LEFT_JOYSTICK_PORT = 2;
    public static final int LEFT_MOTOR = 7; //1
    public static final int RIGHT_MOTOR = 3;

    /* Gear Shifting */
    public static final int RIGHT_GEAR_SHIFTER = 5;
    public static final int LEFT_GEAR_SHIFTER = 6;



}
