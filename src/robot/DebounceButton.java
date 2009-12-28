package robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 * Class to prevent the debouncing of a button.
 * @author Tanner Smith (creator)
 */
public class DebounceButton {
    public static final long DEBOUNCE_DELAY = 105000;

    private Joystick joystick;
    private int buttonNumber;

    private Timer timer;

    private long lastDebounceTime;
    private boolean lastButtonState;
    private boolean buttonState;

    /**
     * Constructor for the class.
     * @param joystick The joystick that holds the button.
     * @param buttonNumber The specific button number.
     */
    public DebounceButton(Joystick joystick, int buttonNumber) {
        this.joystick = joystick;
        this.buttonNumber = buttonNumber;

        timer = new Timer();
        buttonState = false;
        lastButtonState = true;
        lastDebounceTime = 0;
    }

    public void checkButton() {
        long currentTime = timer.getUsClock();
        boolean reading = joystick.getRawButton(buttonNumber);

        if (reading != lastButtonState)
        {
            lastDebounceTime = currentTime;
        }

        if (currentTime - lastDebounceTime > DEBOUNCE_DELAY)
        {
            System.out.println("Debounce Time: "+(currentTime - lastDebounceTime)+" vs "+DEBOUNCE_DELAY+" - "+reading);
            //Button state has been there for longer than the debounce delay
            buttonState = reading;
        }
    }

    public boolean getButtonValue() {
        return buttonState;
    }
}