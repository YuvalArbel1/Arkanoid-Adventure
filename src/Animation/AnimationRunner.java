// 206945107 Yuval Arbel
package Animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * AnimationRunner this class is responsible for running the animation.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * This is the constructor of the class..
     *
     * @param gui the gui
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
    }

    /**
     * This function returns the GUI object.
     *
     * @return The GUI object.
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * While the animation should not stop, draw the animation on the surface, show the surface, and sleep for the
     * remaining time.
     *
     * @param animation the animation we want to run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}