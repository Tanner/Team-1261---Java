/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class LoganRover extends IterativeRobot {
    private RobotDrive drivetrain;
    private Joystick joystickOne;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        joystickOne = new Joystick(1);

        drivetrain = new RobotDrive(3, 1);
        drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        drivetrain.arcadeDrive(0, 0);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drivetrain.arcadeDrive(joystickOne);
    }
    
}
