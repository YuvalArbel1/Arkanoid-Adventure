// 206945107 Yuval Arbel
package listeners;


/**
 * interface HitNotifier to add all the event object in the game.
 *
 * @author Yuval Arbel.
 * @version ass6
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl The listener to be added.
     */
    void addHitListener(HitListener hl);

    /**
     * The function remove hl from the list of listeners to hit events.
     *
     * @param hl the HitListener to remove
     */
    void removeHitListener(HitListener hl);
}