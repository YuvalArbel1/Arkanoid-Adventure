// 206945107 Yuval Arbel
package Participants;

import Geometry.Line;
import Geometry.Point;
import Geometry.Rectangle;
import Initilazeres.GameLevel;
import biuoop.DrawSurface;
import collides.Collidable;
import collides.Sprite;
import listeners.HitListener;
import listeners.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Participants.Block class for making a Participants.Block on the screen.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle shape;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * The function Participants.Block is a constructor.
     * <p>
     * constructor for block.
     * </p>
     *
     * @param shape block rectangle.
     * @param color of the block.
     */
    public Block(Rectangle shape, Color color) {
        this.hitListeners = new ArrayList<>();
        setShape(shape);
        setColor(color);
    }

    /**
     * The function Participants.Block is a constructor.
     * <p>
     * constructor for block.
     * </p>
     *
     * @param shape block rectangle.
     */
    public Block(Rectangle shape) {
        setShape(shape);
    }

    /**
     * The function addToGame.
     * <p>
     * add the block to the game.
     * </p>
     *
     * @param game the game we want to add the block to.
     */
    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * The function getCollisionRectangle.
     * <p>
     * a getter of rectangle.
     * </p>
     *
     * @return the rectangle shape.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }


    /**
     * The function setShape.
     * <p>
     * a setter for the shape member (rectangle).
     * </p>
     *
     * @param shape the rectangle shape
     */
    public void setShape(Rectangle shape) {
        this.shape = shape;
    }


    /**
     * The function setColor.
     * <p>
     * a setter for the color member (the color of the rectangle).
     * </p>
     *
     * @param color the color of the block
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * The function hit.
     * <p>
     * the function set new velocity (for the ball) after hitting the ball by checking where the hits occurs.
     * </p>
     *
     * @param collisionPoint  the point that the hit occurs
     * @param currentVelocity the velocity of the ball.
     * @return new velocity for the ball after the hit occurs.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        boolean horizontal = false, vertical = false;
        this.notifyHit(hitter);
        double newDx = currentVelocity.getDx(), newDy = currentVelocity.getDy();
        double collisionX = collisionPoint.getX(), collisionY = collisionPoint.getY();
        // if it occurs on the left side of the rectangle (block).
        if (Line.doubleEquals(collisionX, this.shape.getUpperLeft().getX())) {
            vertical = true;
            // if it occurs on the right side of the rectangle (block).
        } else if (Line.doubleEquals(collisionX, this.shape.getLowerRight().getX())) {
            vertical = true;
        }

        // if it occurs in the upper side of the rectangle(block)
        if (Line.doubleEquals(collisionY, this.shape.getUpperLeft().getY())) {
            horizontal = true;
            // if it occurs in the lower side of the rectangle(block)
        } else if (Line.doubleEquals(collisionY, this.shape.getLowerRight().getY())) {
            horizontal = true;
        }
        if (vertical && horizontal) {
            newDx *= -1;
            newDy *= -1;
        } else if (vertical) {
            newDx *= -1;
        } else if (horizontal) {
            newDy *= -1;
        }
        return new Velocity(newDx, newDy);
    }

    /**
     * The function drawOn.
     * <p>
     * the method draw the block on the given surface.
     * </p>
     *
     * @param d the surface we want to draw the block.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(), (int) getCollisionRectangle().getWidth(),
                (int) getCollisionRectangle().getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(), (int) getCollisionRectangle().getWidth(),
                (int) getCollisionRectangle().getHeight());
    }


    /**
     * This function removes the block from the game.
     *
     * @param game the game object.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }


    /**
     * The function timePassed.
     * <p>
     * maybe in the future the block will move.
     * </p>
     */
    @Override
    public void timePassed() {

    }

    /**
     * The function adds a hit listener to the list of hit listeners.
     *
     * @param hitListeners a list of HitListener objects.
     */
    public void setHitListeners(HitListener hitListeners) {
        this.hitListeners.add(hitListeners);
    }

    /**
     * Returns a list of all the hit listeners of the block.
     *
     * @return The list of hit listeners.
     */
    public List<HitListener> getHitListeners() {
        return this.hitListeners;
    }

    @Override
    public void addHitListener(HitListener hl) {
        setHitListeners(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        if (hl != null) {
            getHitListeners().remove(hl);
        }
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
