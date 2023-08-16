// 206945107 Yuval Arbel
package collides;


import Geometry.Point;

/**
 * collides.CollisionInfo class for check where the collision occurs.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class CollisionInfo {
    private Point collidePoint;
    private Collidable collidable;


    /**
     * The function collides.CollisionInfo.
     * <p>
     * collides.CollisionInfo is a constructor.
     * </p>
     *
     * @param collidePoint the point the ball and the object Collided.
     * @param collidable   the object that the ball collide with.
     */
    public CollisionInfo(Point collidePoint, Collidable collidable) {
        setCollidePoint(collidePoint);
        setCollidable(collidable);
    }

    /**
     * The function setCollidable.
     * <p>
     * setCollidable set the collidable object.
     * </p>
     *
     * @param collidable the collidable object.
     */
    public void setCollidable(Collidable collidable) {
        this.collidable = collidable;
    }

    /**
     * The function setCollidePoint.
     * <p>
     * setCollidePoint set the point that the collide occurs
     * </p>
     *
     * @param collidePoint the point where the collide occurs.
     */
    public void setCollidePoint(Point collidePoint) {
        this.collidePoint = collidePoint;
    }

    /**
     * The function collisionPoint.
     * <p>
     * collisionPoint getter for the collisionPoint.
     * </p>
     *
     * @return the collisionPoint.
     */
    public Point collisionPoint() {
        return this.collidePoint;
    }

    /**
     * The function collisionObject.
     * <p>
     * collisionObject a getter  for the collidable object involved in the collision.
     * </p>
     *
     * @return objectThatCollided.
     */
    public Collidable collisionObject() {
        return this.collidable;
    }
}