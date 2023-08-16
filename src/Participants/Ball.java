// 206945107 Yuval Arbel
package Participants;

import Geometry.Line;
import Geometry.Point;

import Initilazeres.GameLevel;
import Initilazeres.GameEnvironment;
import biuoop.DrawSurface;
import collides.CollisionInfo;
import collides.Sprite;

import java.awt.Color;

/**
 * Participants.Ball class for making a ball from center point radius and velocity.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity vel;
    private int top;
    private int bottom;
    private int left;
    private int right;
    private GameEnvironment gameEnvironment;
    private static final double THRESHOLD = 0.00000000001;


    /**
     * The function Participants.Ball is a constructor.
     * <p>
     * The function making a ball from center point radius velocity and color
     * </p>
     *
     * @param center the center point of the ball
     * @param r      the radius of the ball
     * @param color  the color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        setCenter(center);
        setSize(r);
        setColor(color);

    }

    /**
     * The function Participants.Ball is a constructor.
     * <p>
     * The function making a ball from x and y coordination (center of the ball) radius velocity and color
     * </p>
     *
     * @param x     the coordination of the center point
     * @param y     the coordination of the center point
     * @param r     the radius of the ball
     * @param color the color of the ball
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        Point center = new Point(x, y);
        setSize(r);
        setColor(color);
        setCenter(center);

    }


    /**
     * The function getX.
     * <p>
     * getX returns the x value of this point
     * </p>
     *
     * @return Returns the x value of this point
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * The function getY.
     * <p>
     * getY returns the y value of this point
     * </p>
     *
     * @return Returns the y value of this point
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * The function getCenter.
     * <p>
     * getCenter returns the center point of the ball
     * </p>
     *
     * @return Returns the center point of the ball
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * The function getCenter.
     * <p>
     * getter of gameEnvironment.
     * </p>
     *
     * @return the gameEnvironment.
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * The function getSize.
     * <p>
     * getSize returns the radius of the ball
     * </p>
     *
     * @return Returns the radius of the ball
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * The function getColor.
     * <p>
     * getColor returns the color of the ball
     * </p>
     *
     * @return Returns the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * The function drawOn.
     * <p>
     * drawOn draw the ball on the given DrawSurface
     * </p>
     *
     * @param d given DrawSurface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillCircle((int) this.getX(), (int) this.getY(), this.getSize());
    }

    /**
     * The function setGameEnvironment.
     * <p>
     * setter the game, add the ball to the game.
     * </p>
     *
     * @param gameEnvironment the game we want to the ball to participant.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * The function setBounds.
     * <p>
     * setBounds set the bounds of the screen
     * </p>
     *
     * @param top    the top bound of the screen
     * @param bottom the bottom bound of the screen
     * @param left   the left bound of the screen
     * @param right  the right bound of the screen
     */
    public void setBounds(int top, int bottom, int left, int right) {
        setTop(top);
        setBottom(bottom);
        setLeft(left);
        setRight(right);
    }

    /**
     * The function setCenter.
     * <p>
     * setCenter set the center point of the ball
     * </p>
     *
     * @param point the center of the ball
     */
    public void setCenter(Point point) {
        if (point.getX() + THRESHOLD >= 780) {
            point.setX(778);
        } else if (point.getX() - THRESHOLD <= 20) {
            point.setX(22);
        }
        if (point.getY() - THRESHOLD <= 22) {
            point.setY(22);
        }
        this.center = point;
    }

    /**
     * The function setTop.
     * <p>
     * setTop set the  top bound of the screen
     * </p>
     *
     * @param top the top bound of the screen
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * The function setBottom.
     * <p>
     * setBottom set the  top bottom of the screen
     * </p>
     *
     * @param bottom the top bound of the screen
     */
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    /**
     * The function setLeft.
     * <p>
     * setLeft set the  top left of the screen
     * </p>
     *
     * @param left the top bound of the screen
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     * The function setRight.
     * <p>
     * setRight set the  top right of the screen
     * </p>
     *
     * @param right the top bound of the screen
     */
    public void setRight(int right) {
        this.right = right;
    }


    /**
     * The function setSize.
     * <p>
     * setSize set the radius of the ball
     * </p>
     *
     * @param size1 the radius of the ball
     */
    public void setSize(int size1) {
        this.radius = size1;
    }

    /**
     * The function setColor.
     * <p>
     * setColor set the color of the ball
     * </p>
     *
     * @param color the color of the ball
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * The function setVelocity.
     * <p>
     * setVelocity set the speed of the ball
     * </p>
     *
     * @param v the speed of the ball
     */
    public void setVelocity(Velocity v) {
        this.vel = v;
    }

    /**
     * The function setVelocity.
     * <p>
     * setVelocity set the speed of the ball
     * </p>
     *
     * @param dx the speed of the ball
     * @param dy the speed of the ball
     */
    public void setVelocity(double dx, double dy) {
        this.vel = new Velocity(dx, dy);
    }

    /**
     * The function getVelocity.
     * <p>
     * getVelocity get the speed of the ball
     * </p>
     *
     * @return the velocity of this ball
     */
    public Velocity getVelocity() {
        return this.vel;
    }


    /**
     * The function collision.
     * <p>
     * collision check if the vector line of the ball collide with any obstacle.
     * </p>
     */
    public void collision() {
        //create new vector line of the ball
        Line trajectory = new Line(this.center.getX(), this.center.getY(),
                this.getVelocity().getDx() + this.center.getX(),
                this.getVelocity().getDy() + this.center.getY());
        CollisionInfo collisionInfo = getGameEnvironment().getClosestCollision(trajectory);
        if (collisionInfo != null) {
            Velocity velocity = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(),
                    this.getVelocity());
            setVelocity(velocity);
        }
    }

    /**
     * The function moveOneStep.
     * <p>
     * The function checks what the next point the ball should be at.
     * </p>
     */
    public void moveOneStep() {
        //create new vector line of the ball
        Line trajectory = new Line(this.center.getX(), this.center.getY(),
                getVelocity().getDx() + this.center.getX(), getVelocity().getDy() + this.center.getY());
        //get to potential collide point
        CollisionInfo collisionInfo = getGameEnvironment().getClosestCollision(trajectory);
        if (collisionInfo != null) {
            //check if we inside any block
            collision();
        }
        //check if the ball collide with the walls
        if (this.center.getX() >= 780 || this.center.getX() <= 20 || this.center.getY() <= 20) {
            Point point = new Point(this.getX(), this.getY());
            point = this.getVelocity().applyToPoint(point);
            this.setCenter(point);

        } else {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }


    /**
     * The function timePassed.
     * <p>
     * the function call to  moveOneStep() function.
     * </p>
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }


    /**
     * The function addToGame.
     * <p>
     * the function add the ball to the sprites collection of the game.
     * </p>
     *
     * @param game the current game that the ball is participant.
     */
    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        this.setGameEnvironment(game.getGameEnvironment());
    }

    /**
     * Remove this sprite from the game.
     *
     * @param game The game object that the sprite is being removed from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

}
