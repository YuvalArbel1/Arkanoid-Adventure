// 206945107 Yuval Arbel
package listeners;

import Participants.Ball;
import Participants.Block;

/**
 * ScoreTrackingListener class , add the score to the indicator.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;


    /**
     * Constructor a new ScoreTrackingListener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }


    /**
     * When a ball hits a block, increase the score by 5.
     *
     * @param beingHit The block that is being hit.
     * @param hitter The ball that hit the block.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}