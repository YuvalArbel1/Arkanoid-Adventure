// 206945107 Yuval Arbel
package listeners;

import Initilazeres.GameLevel;
import biuoop.DrawSurface;
import collides.Sprite;

import java.awt.Color;

/**
 * ScoreIndicator class , to indicate the score of the player.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class ScoreIndicator implements Sprite {
    private Counter score;


    /**
     * Constructor a new Score indicator.
     *
     * @param score the score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }


    /**
     * Draws the score on the screen.
     *
     * @param d The DrawSurface we're drawing on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(363, 17, "Score: " + this.score.getValue(), 17);
    }


    /**
     * This function is called every time the game updates.
     */
    @Override
    public void timePassed() {

    }


    /**
     * This function adds the sprite to the game.
     *
     * @param game The game object.
     */
    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
