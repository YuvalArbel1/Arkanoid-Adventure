// 206945107 Yuval Arbel
package Animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * KeyPressStoppableAnimation this class is decorated.
 *
 * @author Yuval Arbel
 * @version ass6
 */

public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;

    /**
     * This is the constructor of the class.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
        this.isAlreadyPressed = true;
    }


    /**
     * If the key is pressed, the animation will be played.
     *
     * @param d the surface to draw on
     */
    @Override
    public void doOneFrame(DrawSurface d) {

        this.animation.doOneFrame(d);
        if ((this.sensor.isPressed(this.key))) {
            this.isAlreadyPressed = false;
        }
    }


    /**
     * If the button is not already pressed, then we should stop.
     *
     * @return The boolean value of the statement.
     */
    @Override
    public boolean shouldStop() {
        return !this.isAlreadyPressed;
    }

}
