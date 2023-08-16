// 206945107 Yuval Arbel
package collides;

import Geometry.Point;
import Geometry.Rectangle;
import Participants.Ball;
import Participants.Velocity;

/**
 * interface collides.Collidable all the collidable object in the game.
 *
 * @author Yuval Arbel.
 */
public interface Collidable {


    // Return the "collision shape" of the object.

    /**
     * The function getCollisionRectangle.
     * <p>
     * getter method.
     * </p>
     * getter method.
     *
     * @return the rectangle
     */
    Rectangle getCollisionRectangle();


    /**
     * The function hit.
     * <p>
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     * </p>
     * the method calculate new velocity for the object after he hit collidable.
     *
     * @param collisionPoint  the point that we might collide
     * @param currentVelocity the current velocity of the object.
     * @param hitter ball object.
     * @return The return is the new velocity after the hit occurs
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}