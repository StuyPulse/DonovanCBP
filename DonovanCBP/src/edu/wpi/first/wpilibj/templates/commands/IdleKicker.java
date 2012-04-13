/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author admin
 */
public class IdleKicker extends CommandBase {
    
    boolean isKickScheduled;
    
    public IdleKicker() {
        requires(kicker);
    }
    
    public void kick()
    {
        if(kicker.isCocked())
        {
            isKickScheduled = true;
        }
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println(kicker.isCocked());
        if(isKickScheduled && !kicker.isCocked())
        {
            isKickScheduled = false;
        }
        
        if(isKickScheduled || !kicker.isCocked())
        {
            kicker.run();
        }
        else
        {
            kicker.stop();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
