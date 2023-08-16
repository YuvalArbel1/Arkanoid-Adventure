// 206945107 Yuval Arbel
package Animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * PauseScreen this class is to pause.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * This is the constructor of the class.
     *
     * @param k the k
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }


    /**
     * If the space key is pressed, the animation should stop.
     *
     * @param d the surface to draw on
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }


    /**
     * ShouldStop() returns true if the stop variable is true, and false otherwise.
     *
     * @return The boolean value of the variable stop.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}