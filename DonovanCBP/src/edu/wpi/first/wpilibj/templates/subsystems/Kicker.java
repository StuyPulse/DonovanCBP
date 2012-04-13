/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.IdleKicker;

/**
 *
 * @author admin
 */
public class Kicker extends Subsystem {
    DigitalInput kickInput;
    IdleKicker idle;
    Victor cam;

    public Kicker()
    {
        kickInput = new DigitalInput(RobotMap.KICKER_SENSOR);
        cam = new Victor(RobotMap.KICKER_MOTOR);
    }
    
    public void initDefaultCommand() {
        idle = new IdleKicker();
        setDefaultCommand(idle);
    }
    
    public void kick()
    {
        idle.kick();
    }
    
    public void run()
    {
        cam.set(1);
    }
    
    public void stop()
    {
        cam.set(0);
    }
    
    public boolean isCocked()
    {
        return !kickInput.get();
    }
}
