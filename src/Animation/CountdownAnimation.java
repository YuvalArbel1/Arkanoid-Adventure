// 206945107 Yuval Arbel
package Animation;

import Initilazeres.LevelInformation;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import collides.SpriteCollection;


import java.awt.Color;

/**
 * CountdownAnimation this class is responsible for 3 2 1  on the screen.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean isOneFrame;
    private Sleeper sleeper;
    private int timeLeft;
    private LevelInformation levelInformation;


    /**
     * This is the constructor of the class.
     *
     * @param numOfSeconds     the num of seconds
     * @param countFrom        the count from
     * @param gameScreen       the game screen
     * @param levelInformation the level information
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen,
                              LevelInformation levelInformation) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.timeLeft = this.countFrom;
        this.isOneFrame = true;
        this.sleeper = new Sleeper();
        this.levelInformation = levelInformation;

    }

    /**
     * The function draws the game screen and the countdown timer on the screen.
     *
     * @param d the surface to draw on
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.timeLeft == 0) {
            this.isOneFrame = false;
        }

        this.gameScreen.drawAllOn(d);
        d.setColor(Color.BLACK);
        d.drawText(550, 17, "Level Name: " + this.levelInformation.levelName(), 17);
        d.setColor(Color.RED);
        d.drawText(375, 300, "" + this.timeLeft, 100);
        if (this.timeLeft != this.countFrom) {
            this.sleeper.sleepFor((int) (this.numOfSeconds * 1000) / this.countFrom);
        }

        this.timeLeft--;

    }


    /**
     * If the animation is not one frame, then the animation should stop.
     *
     * @return The boolean value of the statement.
     */
    @Override
    public boolean shouldStop() {
        return !this.isOneFrame;
    }
}


