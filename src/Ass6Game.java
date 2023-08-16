// 206945107 Yuval Arbel

import Animation.AnimationRunner;
import GameLevels.GameLevel1;
import GameLevels.GameLevel2;
import GameLevels.GameLevel3;
import GameLevels.GameLevel4;
import Initilazeres.LevelInformation;
import biuoop.GUI;
import listeners.GameFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * Ass6Game this class is the main where we ran the game from.
 *
 * @author Yuval Arbel
 * @version ass6
 */

public class Ass6Game {


    /**
     * The function receives a list of strings, and if the string is equal to 1, 2, 3 or 4, it adds
     * the corresponding level to the list of levels.
     * If the list is empty, or if the function didn't receive any arguments, it adds all the levels
     * to the list
     *
     * @param args list of strings.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        GameFlow game = new GameFlow(new AnimationRunner(gui), gui.getKeyboardSensor());
        List<LevelInformation> levels = new ArrayList<>();

        for (String arg : args) {
            if (arg.equals("1")) {
                levels.add(new GameLevel1());
            }
            if (arg.equals("2")) {
                levels.add(new GameLevel2());
            }
            if (arg.equals("3")) {
                levels.add(new GameLevel3());
            }
            if (arg.equals("4")) {
                levels.add(new GameLevel4());
            }

        }
        if (levels.isEmpty() || args.length <= 0) {
            levels.add(new GameLevel1());
            levels.add(new GameLevel2());
            levels.add(new GameLevel3());
            levels.add(new GameLevel4());
        }
        game.runLevels(levels);
    }

}

