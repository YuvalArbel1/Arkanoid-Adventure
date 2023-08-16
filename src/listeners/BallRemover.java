// 206945107 Yuval Arbel
package listeners;

import Initilazeres.GameLevel;
import Participants.Ball;
import Participants.Block;


/**
 * BallRemover class, remove the ball from the game.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;


    /**
     * constructor for a new Ball remover.
     *
     * @param game the game
     * @param remainingBalls the remaining balls
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        setGame(game);
        setRemainingBlocks(remainingBalls);

    }

    /**
     * This function returns the game object.
     *
     * @return The game object.
     */
    public GameLevel getGame() {
        return this.game;
    }

    /**
     * This function sets the game variable to the game variable passed in.
     *
     * @param gameLevel The game object that the player is in.
     */
    public void setGame(GameLevel gameLevel) {
        this.game = gameLevel;
    }

    /**
     * This function sets the remainingBalls variable to the value of the remainingBalls parameter.
     *
     * @param remainingBalls The number of balls that are left in the game.
     */
    public void setRemainingBlocks(Counter remainingBalls) {
        this.remainingBalls = remainingBalls;
    }

    /**
     * This function returns the remaining balls counter (numbers of balls).
     *
     * @return The number of remaining blocks.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBalls;
    }


    /**
     * Blocks that are hit should be removed from the game, and remove this listener from the block.
     * that is being removed from the game.
     *
     * @param beingHit the block that is being hit.
     * @param hitter   the ball that hit the block
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
