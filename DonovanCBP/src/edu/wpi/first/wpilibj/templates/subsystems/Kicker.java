package edu.wpi.first.wpilibj.templates.subsystems;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Cock;

/**
 *NEED TO PORT OVER FOR CBP
 * @author 694
 */
public class Kicker extends Subsystem {

    DigitalInput limSwitch;
    boolean limSwitchBroken;
    boolean cocked;
    Victor kicker;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Kicker(int channel) {
        kicker = new Victor(channel);
        limSwitch = new DigitalInput(RobotMap.LIMSWITCH_CHANNEL);
        limSwitchBroken = false;
        cocked = false;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Cock());
    }

    public void stop() {
        kicker.set(0.0);
    }

    /**
     * Used for testing when the limit switch is not properly installed
     */
    public void runKicker() {
        kicker.set(1.0);
    }

    public void shoot() {
        if (limSwitchBroken) {
            //System.out.println("manual control - running kicker");
            runKicker();
            return;
        }

        cock();
        double time = Timer.getFPGATimestamp();
        //System.out.println("kicking");
        kicker.set(1.0);
        Timer.delay(0.5);
//            while (limSwitch.get() == NOT_COCKED && (Timer.getUsClock() - time < 2000000)) {
//                set(1.0);
//            }
//            set(0.0);
        cock();
    }

     public void cock() {
        if (limSwitchBroken) {
            //System.out.println("manaual control - cock button disabled");
            return ;
        }
        //System.out.println("cocking");
        double time = Timer.getFPGATimestamp();
        while (limSwitch.get() == false && (Timer.getFPGATimestamp() - time < 2000000)) { //COCKED defined in Ports
            kicker.set(0.75);
            //may need a short delay?

        }
        kicker.set(0.0);
    }

     public boolean getLimSwitch(){
         return limSwitch.get();
     }

}
