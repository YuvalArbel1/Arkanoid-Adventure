// 206945107 Yuval Arbel
package Participants;

import Geometry.Point;
import Geometry.Rectangle;
import Initilazeres.GameLevel;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import collides.Collidable;
import collides.Sprite;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Participants.Paddle class for making a paddle.
 *
 * @author Yuval Arbel
 * @version ass6
 */

public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle shape;
    private static final double STEP = 5;
    private static final double THRESHOLD = 0.00000000001;
    private java.util.ArrayList<Ball> gameBalls;

    /**
     * The function Participants.Paddle.
     * <p>
     * the function is a constructor.
     * </p>
     *
     * @param rectangle the paddle shape.
     * @param k the keyboardSensor.
     */
    public Paddle(Rectangle rectangle, KeyboardSensor k) {
        setPaddle(rectangle);
        setGameBalls(this.gameBalls);
        this.keyboard = k;
    }

    /**
     * The function addBalls.
     * <p>
     * the function add balls in the balls list member.
     * </p>
     *
     * @param s a ball.
     */
    public void addBalls(Ball s) {
        if (s != null) {
            this.gameBalls.add(s);
        }
    }

    /**
     * The function moveLeft.
     * <p>
     * the function move the paddle left.
     * </p>
     */
    public void moveLeft() {
        if (this.getCollisionRectangle().getUpperLeft().getX() > 22) {
            this.shape.setNewMove(-STEP);
        }
    }

    /**
     * The function moveRight.
     * <p>
     * the function move the paddle right.
     * </p>
     */
    public void moveRight() {
        if (this.getCollisionRectangle().getUpperLeft().getX() < 778 - getCollisionRectangle().getWidth()) {
            this.shape.setNewMove(STEP);
        }
    }


    /**
     * The function timePassed.
     * <p>
     * the function call to move methods if the user pressed right ot lest and check if the ball inside the paddle.
     * </p>
     */
    @Override
    public void timePassed() {
        ballInsidePaddle();
        //check if the ball inside the paddle
        if (this.keyboard.isPressed(keyboard.RIGHT_KEY)) {
            moveRight();

        }
        if (this.keyboard.isPressed(keyboard.LEFT_KEY)) {
            moveLeft();
        }
    }

    /**
     * The function drawOn.
     * <p>
     * the function draw the paddle on the given surface.
     * </p>
     *
     * @param d the given surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.ORANGE);
        d.fillRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(), (int) getCollisionRectangle().getWidth(),
                (int) getCollisionRectangle().getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(), (int) getCollisionRectangle().getWidth(),
                (int) getCollisionRectangle().getHeight());
    }


    /**
     * The function getCollisionRec.
     * <p>
     * the function is a getter.
     * </p>
     *
     * @return the rectangle.
     */
    public Rectangle getCollisionRec() {
        return this.shape;
    }


    /**
     * The function setKeyboard.
     * <p>
     * the function is a setter for the keyboard member in the class.
     * </p>
     *
     * @param gui the keyboard gui.
     */
    public void setKeyboard(GUI gui) {
        this.keyboard = gui.getKeyboardSensor();
    }


    /**
     * The function getCollisionRectangle.
     * <p>
     * the function is a getter.
     * </p>
     *
     * @return the rectangle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    /**
     * The function getGameBalls
     * <p>
     * the function is a getter.
     * </p>
     *
     * @return gameBalls list.
     */
    public ArrayList<Ball> getGameBalls() {
        return this.gameBalls;
    }

    /**
     * The function setPaddle.
     * <p>
     * the function set the shape for the paddle
     * </p>
     *
     * @param rectangle the shape of the paddle
     */

    public void setPaddle(Rectangle rectangle) {
        this.shape = rectangle;
    }

    /**
     * The function setGameBalls.
     * <p>
     * the function is a setter for the gameballs list.
     * </p>
     *
     * @param gameBalls the list of balls
     */
    public void setGameBalls(ArrayList<Ball> gameBalls) {
        this.gameBalls = new ArrayList<Ball>();
    }

    /**
     * The function getPaddleHitSpace.
     * <p>
     * the function check where the balls hits the paddle
     * </p>
     *
     * @param colX the x value of the collision point.
     * @return a number that indicate which action we need to do.
     */
    public int getPaddleHitSpace(double colX) {
        int xPaddle = (int) this.getCollisionRectangle().getUpperLeft().getX();
        int paddleWidth = (int) this.shape.getWidth();
        paddleWidth /= 5;
        if (((xPaddle) - THRESHOLD <= colX)
                && (colX - THRESHOLD <= xPaddle + paddleWidth)) {
            return 1;
        }
        if (((xPaddle + paddleWidth) - THRESHOLD <= colX)
                && (colX - THRESHOLD <= xPaddle + paddleWidth * 2)) {
            return 2;
        }
        if (((xPaddle + paddleWidth * 2) - THRESHOLD <= colX)
                && (colX - THRESHOLD <= xPaddle + paddleWidth * 3)) {
            return 3;
        }
        if (((xPaddle + paddleWidth * 3) - THRESHOLD <= colX)
                && (colX - THRESHOLD <= xPaddle + paddleWidth * 4)) {
            return 4;
        }
        if (((xPaddle + paddleWidth * 4) - THRESHOLD <= colX)
                && (colX - THRESHOLD <= xPaddle + paddleWidth * 5)) {
            return 5;
        }
        return 3;
    }

    /**
     * The function hit.
     * <p>
     * the function set new velocity for the ball after he hit the paddle.
     * </p>
     *
     * @param collisionPoint  the point that the balls intersect with the paddle.
     * @param currentVelocity the current velocity of the ball.
     * @return the new velocity.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double newDx = currentVelocity.getDx();
        double newDy = currentVelocity.getDy();
        double colX = collisionPoint.getX();
        //switch case that change the velocity according to the int number came from getPaddleHitSpace function.
        switch (this.getPaddleHitSpace(colX)) {
            case 1:
                return Velocity.fromAngleAndSpeed(300, 6);
            case 2:
                return Velocity.fromAngleAndSpeed(330, 6);
            case 3:
                return new Velocity(newDx, newDy * -1);
            case 4:
                return Velocity.fromAngleAndSpeed(30, 6);
            case 5:
                return Velocity.fromAngleAndSpeed(60, 6);
            default:
                return currentVelocity;
        }
    }


    /**
     * The function ballInsidePaddle.
     * <p>
     * the function check if the ball inside the paddle borders.
     * </p>
     */
    public void ballInsidePaddle() {
        int i;
        for (i = 0; i < this.gameBalls.size(); i++) {
            Point point = getCollisionRec().getUpperLeft();
            double newDx = getGameBalls().get(i).getVelocity().getDx();
            double newDy = getGameBalls().get(i).getVelocity().getDy();
            //check if the ball inside the paddle borders
            if ((getGameBalls().get(i).getX() + THRESHOLD >= point.getX() + getCollisionRectangle().getWidth() / 2
                    && getGameBalls().get(i).getX() - THRESHOLD <= (point.getX() + getCollisionRectangle().getWidth())
                    && getGameBalls().get(i).getY() > point.getY()
                    && getGameBalls().get(i).getY() - THRESHOLD
                    <= point.getY() + getCollisionRectangle().getHeight())) {
                getGameBalls().get(i).setCenter(
                        new Point((getGameBalls().get(i).getX() + 2 * STEP), getGameBalls().get(i).getY()));
                getGameBalls().get(i).setVelocity(-newDx, newDy);
                //check if the center point of the ball inside the paddle.
            } else if (getGameBalls().get(i).getX() + THRESHOLD >= point.getX()
                    && getGameBalls().get(i).getX() - THRESHOLD
                    <= (point.getX() + getCollisionRectangle().getWidth() / 2)
                    && getGameBalls().get(i).getY() > point.getY()
                    && getGameBalls().get(i).getY() - THRESHOLD <= point.getY() + getCollisionRectangle().getHeight()) {
                getGameBalls().get(i).setCenter(
                        new Point((getGameBalls().get(i).getX() - 2 * STEP), getGameBalls().get(i).getY()));
                getGameBalls().get(i).setVelocity(-newDx, newDy);
            }
        }

    }

    /**
     * The function addToGame
     * <p>
     * add the paddle to the list of collides and list of the sprite.
     * </p>
     *
     * @param game the game we want to add paddle too.
     */
    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }
}