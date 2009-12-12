/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class LoganRover extends IterativeRobot {
    private Joystick joystickOne;
    private DigitalInput leftAutoSwitch;
    private DigitalInput rightAutoSwitch;
    
    private RobotDrive drivetrain;
    private Intake intake;

    private Jaguar leftDrive, rightDrive;           //Drivetrain Motors
    private Victor intakeMotorOne, intakeMotorTwo;  //Intake Motors
    private Victor unobtaniumMotor;                 //Also part of intake system

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        joystickOne = new Joystick(1);
        leftAutoSwitch = new DigitalInput(1);
        rightAutoSwitch = new DigitalInput(2);

        leftDrive = new Jaguar(3);
        rightDrive = new Jaguar(1);
        intakeMotorOne = new Victor(2);
        intakeMotorTwo = new Victor(4);
        unobtaniumMotor = new Victor(5);

        drivetrain = new RobotDrive(leftDrive, rightDrive);
        drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);

        intake = new Intake(joystickOne, intakeMotorOne, intakeMotorTwo, unobtaniumMotor);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //TODO: Add old Logan Rover autonomous
        //drivetrain.arcadeDrive(0, 0);

        if (leftAutoSwitch.get() == true)
        {
            //Put us into left autonomous
        } else if (rightAutoSwitch.get() == true) {
            //Put us into right autonomous
        } else {
            //Middle position
        }
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drivetrain.arcadeDrive(joystickOne);

        intake.doAction();
    }
    
}
