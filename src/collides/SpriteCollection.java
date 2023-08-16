// 206945107 Yuval Arbel
package collides;

import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * collides.SpriteCollection class for all the sprite in the game.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class SpriteCollection {
    private java.util.ArrayList<Sprite> list;


    /**
     * The function collides.SpriteCollection.
     * <p>
     * the function is a constructor.
     * </p>
     */
    public SpriteCollection() {
        this.list = new ArrayList<>();
    }

    /**
     * The function addSprite.
     * <p>
     * the function add sprite to the list of sprite (list).
     * </p>
     *
     * @param s the sprite we add.
     */
    public void addSprite(Sprite s) {
        if (s != null) {
            this.list.add(s);
        }
    }

    /**
     * The function notifyAllTimePassed.
     * <p>
     * call timePassed() on all sprites.
     * </p>
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).timePassed();
        }
    }

    /**
     * The function createSpriteList.
     * <p>
     * initialize the list of sprites.
     * </p>
     */
    public void createSpriteList() {
        this.list = new ArrayList<>();
    }

    /**
     * The function drawAllOn
     * <p>
     * call drawOn(d) on all sprites.
     * </p>
     *
     * @param d the surface that given where we draw all the sprites.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).drawOn(d);
        }
    }

    /**
     * This function returns the list of sprites.
     *
     * @return The list of sprites.
     */
    public ArrayList<Sprite> getList() {
        return this.list;
    }
}
