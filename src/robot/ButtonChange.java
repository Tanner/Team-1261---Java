/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Class which only returns true if the button changes state from one to another
 * @author Tanner Smith (creator)
 */
public class ButtonChange {

    Joystick joystick;
    int buttonNumber;

    boolean previousState;

    /**
     * Constructor.
     * @param joystick The desired joystick holding the button.
     * @param buttonNumber The desired button number to monitor.
     */
    public ButtonChange(Joystick joystick, int buttonNumber) {
        this.joystick = joystick;
        this.buttonNumber = buttonNumber;
    }

    /**
     * Sets the previous state of the button after you check if it changed.
     */
    public void setPreviousState() {
        previousState = joystick.getRawButton(buttonNumber);
    }

    /**
     * Check whether or not the button changed.
     * @param actOnRelease Did we release it or did we press it?
     * @return Whether or not the button changed.
     */
    public boolean didButtonChange(boolean actOnRelease) {
        boolean currentState = joystick.getRawButton(buttonNumber);

        System.out.println("Current State: "+currentState+" - Previous State: "+previousState+" Act On Release: "+actOnRelease);

        if (actOnRelease) {
            if (currentState == false) {
                if (previousState == false) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            if (currentState) {
                if (previousState == false) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
