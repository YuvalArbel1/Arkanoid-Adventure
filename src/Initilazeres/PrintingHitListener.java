// 206945107 Yuval Arbel
package Initilazeres;

import Participants.Ball;
import Participants.Block;
import listeners.HitListener;


/**
 * PrintingHitListener class for print when block was hit.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class PrintingHitListener implements HitListener {


    /**
     * When a Block is hit by a Ball, print a message to the console.
     *
     * @param beingHit the block that was hit
     * @param hitter   The Ball that's doing the hitting.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}
