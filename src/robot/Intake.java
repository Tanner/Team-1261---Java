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
    }

    public void doAction() {
        //TODO: Check whether these buttons are correct.
        //TODO: Figure out system other than enumerations? IDK, if they are allowed.
        if (joystick.getRawButton(2)) {
            //Intake Button
            
            //Check our mode
        } else if (joystick.getRawButton(3)) {
            //Reverse Button

            //Check our mode
        } else if (joystick.getRawButton(1)) {
            //Fire Button

            //Check our mode
        }

        //Put mode into action
        setBeltSpeed(0);
    }

    /**
     * Set the speed of the both belt motors.
     * @param speed Value of motor speed from -1 to 1
     */
    private void setBeltSpeed(double speed) {
        //As a safety measure of un-tested code, the following line is commented out to prevent *boom*
        //beltMotorOne.set(speed);
        beltMotorTwo.set(speed);
    }
}
