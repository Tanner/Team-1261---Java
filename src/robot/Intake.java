/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author tanner
 */
public class Intake {
    //private enum mode {INTAKE, STOP, FIRE}

    private Joystick joystick;
    private Victor beltMotorOne, beltMotorTwo, unobtaniumMotor;
    private int intakeMode;

    /**
     * Creates our intake system.
     * @param joystick Joystick of which it is to be controlled by.
     * @param intakeMotorOne First belt motor.
     * @param intakeMotorTwo Second belt motor.
     * @param unobtaniumMotor Unobtanium motor.
     */
    public Intake(Joystick joystick, Victor beltMotorOne, Victor beltMotorTwo, Victor unobtaniumMotor) {
        this.joystick = joystick;
        this.beltMotorOne = beltMotorOne;
        this.beltMotorTwo = beltMotorTwo;
        this.unobtaniumMotor = unobtaniumMotor;

        intakeMode = 0;
    }

    /**
     * Perform the actions that the mode we are in requires.
     */
    public void doAction() {
        //TODO: Check whether these buttons are correct.

        double beltSpeed = 0;
        double unobtaniumSpeed = 0;

        if (joystick.getRawButton(2)) {
            //Intake Button
            if (intakeMode == 1) {
                //Mode is at intake, ergo stop.
                intakeMode = 0;
            } else {
                //Mode is not at intake
                intakeMode = 1;
            }
        } else if (joystick.getRawButton(3)) {
            //Reverse Button

            //Check our mode, and change
        } else if (joystick.getRawButton(1)) {
            //Fire Button

            //Check our mode, and change
        }

        //Put mode into action
        setBeltSpeed(beltSpeed);
        setUnobtaniumSpeed(unobtaniumSpeed);
    }

    /**
     * Set the speed of the both belt motors.
     * @param speed Value of motor speed from -1 to 1
     */
    public void setBeltSpeed(double speed) {
        //As a safety measure of un-tested code, the following line is commented out to prevent *boom*
        //beltMotorOne.set(speed);
        beltMotorTwo.set(speed);
    }

    /**
     * Set the speed of the unobtanium motor for easy access.
     * @param speed Value of motor speed from -1 to 1
     */
    public void setUnobtaniumSpeed(double speed) {
        unobtaniumMotor.set(speed);
    }
}
