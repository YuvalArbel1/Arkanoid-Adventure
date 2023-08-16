// 206945107 Yuval Arbel
package listeners;

import Animation.AnimationRunner;
import Animation.EndScreen;
import Animation.KeyPressStoppableAnimation;
import Initilazeres.GameLevel;
import Initilazeres.LevelInformation;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * GameFlow class , to make the flow of the game.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class GameFlow {

    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter scoreCounter;

    /**
     * constructor for a new GameFlow.
     *
     * @param ar the ar
     * @param ks the ks
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.scoreCounter = new Counter();
    }

    /**
     * The function runs the levels in the list, and if the player loses, the game ends.
     *
     * @param levels a list of LevelInformation objects.
     */
    public void runLevels(List<LevelInformation> levels) {

        boolean winOrLose = true;

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(this.animationRunner, this.keyboardSensor, levelInfo, this.scoreCounter);

            level.initialize();

            while (level.getBlockCounter() > 0 && level.getBallCounter() > 0) {
                level.run();
            }

            if (level.getBallCounter() <= 0) {
                winOrLose = false;
                break;
            }

        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, this.keyboardSensor.SPACE_KEY,
                new EndScreen(this.keyboardSensor, this.scoreCounter, winOrLose)));
        this.animationRunner.getGui().close();


    }
}