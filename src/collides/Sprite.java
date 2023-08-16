// 206945107 Yuval Arbel
package collides;

import Initilazeres.GameLevel;
import biuoop.DrawSurface;

/**
 * collides.Sprite interface for all the sprite object in the game.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public interface Sprite {
    // draw the sprite to the screen

    /**
     * The function drawOn.
     * <p>
     * draw the sprite to the screen.
     * </p>
     *
     * @param d the surface the given.
     */
    void drawOn(DrawSurface d);


    /**
     * The function timePassed.
     * <p>
     * notify the sprite that time has passed.
     * </p>
     */
    void timePassed();

    /**
     * The function addToGame.
     * <p>
     * add all object to the game.
     * </p>
     *
     * @param game the game we want to add the object to.
     */
    void addToGame(GameLevel game);
}