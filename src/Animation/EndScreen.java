// 206945107 Yuval Arbel
package Animation;


import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import listeners.Counter;

/**
 * CountdownAnimation this class is responsible for 3 2 1  on the screen.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter scoreCounter;
    private boolean winOrLose;

    /**
     * This is the constructor of the class.
     *
     * @param k            the k
     * @param scoreCounter the score counter
     * @param winOrLose    the win or lose
     */
    public EndScreen(KeyboardSensor k, Counter scoreCounter, boolean winOrLose) {
        this.keyboard = k;
        this.stop = false;
        this.scoreCounter = scoreCounter;
        this.winOrLose = winOrLose;
    }


    /**
     * If the player won, the function will print "You Win!" and the player's score. If the player lost,
     * the function will print "You Lost!" and the player's score
     *
     * @param d the surface to draw on
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.winOrLose) {
            d.drawText(330, 265, "You Win!", 32);
            d.drawText(270, 315, "You have " + this.scoreCounter.getValue() + " points!", 32);

        } else {
            d.drawText(330, 265, "You Lost!", 32);
            d.drawText(270, 315, "You have " + this.scoreCounter.getValue() + " points!", 32);

        }
    }


    /**
     * ShouldStop() returns true if the stop variable is true, and false otherwise.
     *
     * @return The boolean value of the stop variable.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}
