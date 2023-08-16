// 206945107 Yuval Arbel
package listeners;

import Initilazeres.GameLevel;
import Participants.Ball;
import Participants.Block;


/**
 * a listeners.BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;


    /**
     * constructor a new Block remover.
     *
     * @param game the game
     * @param remainingBlocks the remaining blocks
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        setGame(game);
        setRemainingBlocks(remainingBlocks);

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
     * @param game The game object that the player is in.
     */
    public void setGame(GameLevel game) {
        this.game = game;
    }

    /**
     * This function sets the remainingBlocks variable to the value of the remainingBlocks field.
     *
     * @param remainingBlocks The number of blocks left to be mined.
     */
    public void setRemainingBlocks(Counter remainingBlocks) {
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * This function returns the remainingBlocks variable.
     *
     * @return The remainingBlocks counter.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }


    /**
     * Blocks that are hit should be removed from the game. Remember to remove this listener from the block.
     * that is being removed from the game.
     *
     * @param beingHit the block that is being hit.
     * @param hitter   the Ball that's doing the hitting.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
    }
}