// 206945107 Yuval Arbel
package GameLevels;

import Initilazeres.LevelInformation;
import Participants.Ball;
import Participants.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * BasicLevel class.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public abstract class BasicLevel implements LevelInformation {
    private List<Ball> ballList;
    private List<Block> blockList;
    private String gameName;
    private int paddleSpeed;
    private int paddleWidth;


    /**
     * This is the constructor of the class.
     *
     * @param gameName    the game name
     * @param paddleSpeed the paddle speed
     * @param paddleWidth the paddle width
     */
    public BasicLevel(String gameName, int paddleSpeed, int paddleWidth) {
        this.ballList = new ArrayList<>();
        this.blockList = new ArrayList<>();
        this.gameName = gameName;
        this.paddleSpeed = paddleSpeed;
        this.paddleWidth = paddleWidth;
    }


    /**
     * Returns the number of balls in the game.
     *
     * @return The number of balls in the ballList.
     */
    @Override
    public int numberOfBalls() {
        return this.ballList.size();
    }


    /**
     * This function returns the speed of the paddle.
     *
     * @return The speed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }


    /**
     * This function returns the width of the paddle.
     *
     * @return The width of the paddle.
     */
    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }


    /**
     * This function returns the name of the game.
     *
     * @return The name of the game.
     */
    @Override
    public String levelName() {
        return this.gameName;
    }


    /**
     * This function returns a list of blocks.
     *
     * @return A list of blocks
     */
    @Override
    public List<Block> blocks() {
        return this.blockList;
    }


    /**
     * Return the list of balls.
     *
     * @return The list of balls.
     */
    @Override
    public List<Ball> balls() {
        return this.ballList;
    }


    /**
     * Returns the number of blocks to remove.
     *
     * @return The number of blocks in the blockList.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return this.blockList.size();
    }

    /**
     * If the block is not null, add it to the block list.
     *
     * @param block The block to add to the list.
     */
    public void addBlocks(Block block) {

        if (block != null) {
            this.blockList.add(block);
        }
    }

    /**
     * If the ball is not null, add it to the list.
     *
     * @param ball The ball to add to the list.
     */
    public void addBall(Ball ball) {
        if (ball != null) {
            this.ballList.add(ball);
        }
    }

}
