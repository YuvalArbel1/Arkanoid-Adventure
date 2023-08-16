// 206945107 Yuval Arbel
package Initilazeres;

import Participants.Ball;
import Participants.Block;
import Participants.Velocity;
import collides.Sprite;

import java.util.List;

/**
 * LevelInformation interface.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public interface LevelInformation {
    /**
     * This function returns the number of balls in the game.
     *
     * @return The number of balls in the bag.
     */
    int numberOfBalls();


    /**
     * The initial velocity of each ball.
     *
     * @return List of Velocity objects.
     */
    List<Velocity> initialBallVelocities();

    /**
     * Returns the speed of the paddle.
     *
     * @return The speed of the paddle.
     */
    int paddleSpeed();

    /**
     * Returns the width of the paddle.
     *
     * @return The width of the paddle.
     */
    int paddleWidth();


    /**
     * The level name will be displayed at the top of the screen.
     *
     * @return The name of the level.
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return A Sprite object.
     */
    Sprite getBackground();


    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return A list of blocks.
     */
    List<Block> blocks();

    /**
     * Return a list of all the balls in the world.
     *
     * @return A list of all the balls in the game.
     */
    List<Ball> balls();


    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     *
     * @return The number of blocks to remove.
     */
    int numberOfBlocksToRemove();
}