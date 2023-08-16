// 206945107 Yuval Arbel
package Animation;

import biuoop.DrawSurface;

/**
 * Animation interface.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public interface Animation {
    /**
     * Draw one frame of the animation on the given surface.
     *
     * @param d The surface to draw on.
     */
    void doOneFrame(DrawSurface d);

    /**
     * ShouldStop() returns true if the program should stop, and false otherwise.
     *
     * @return A boolean value.
     */
    boolean shouldStop();
}
