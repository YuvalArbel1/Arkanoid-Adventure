// 206945107 Yuval Arbel
package listeners;

import Participants.Ball;
import Participants.Block;

/**
 * HitListener interface for all the events in the game.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public interface HitListener {


    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit The block that is being hit.
     * @param hitter   The ball that hit the block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}