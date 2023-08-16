// 206945107 Yuval Arbel
package GameLevels;

import Geometry.Point;
import Geometry.Rectangle;
import Initilazeres.GameLevel;
import Participants.Ball;
import Participants.Block;
import Participants.Velocity;
import biuoop.DrawSurface;
import collides.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * GameLevel2 class.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class GameLevel2 extends BasicLevel implements Sprite {

    /**
     * This is the constructor of the class. It calls the constructor of the super class and then adds a block and ball
     * to the game.
     */
    public GameLevel2() {
        super("Wise Easy", 5, 350);
        int blockHeight = 30;
        double blockWidth = 63.333;

        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.PINK, Color.GREEN};
        for (int j = 0; j < 12; j++) {
            super.addBlocks(new Block(new Rectangle(new Point((780 - blockWidth) - (blockWidth * j),
                    300),
                    blockWidth, blockHeight), colors[j / 3]));
        }
        double ballWidth = 70;
        double spaceCelling = 10;
        for (int i = 0; i < 10; i++) {
            super.addBall(new Ball(new Point((780 - ballWidth) - (ballWidth * i),
                    (450 - spaceCelling) - (spaceCelling * i)
            ), 8, colors[i / 3]));
        }

    }

    /**
     * It returns a list of velocities for the balls.
     *
     * @return a list of velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            velocityList.add(new Velocity(8 - i * 2, 2));
        }
        return velocityList;
    }

    /**
     * It creates the background for this specific level.
     *
     * @return A Sprite object.
     */
    @Override
    public Sprite getBackground() {
        Sprite backGround = new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                for (int i = 0; i < 60; i++) {
                    d.setColor(new Color(53 + i * 2, 123 + i * 2, 255));
                    d.fillRectangle(0, 600 - i * 10, 800, 10);
                }
                d.setColor(new Color(250, 250, 100));
                d.fillCircle(150, 150, 100);
                for (int i = 0; i < 100; i++) {
                    d.drawLine(150, 150, 680 - i * 7, 300);
                }
                d.setColor(new Color(238, 236, 15));
                d.fillCircle(150, 150, 90);
                d.setColor(new Color(197, 196, 74, 255));
                d.fillCircle(150, 150, 80);
                d.setColor(new Color(160, 196, 255));
                d.fillCircle(250, 400, 25);
                d.fillCircle(280, 400, 25);
                d.fillCircle(300, 420, 25);
                d.fillCircle(270, 420, 25);
                d.fillCircle(235, 420, 25);
                d.setColor(new Color(223, 231, 253));
                d.fillCircle(550, 500, 25);
                d.fillCircle(580, 500, 25);
                d.fillCircle(600, 520, 25);
                d.fillCircle(570, 520, 25);
                d.fillCircle(535, 520, 25);

            }

            @Override
            public void timePassed() {

            }

            @Override
            public void addToGame(GameLevel game) {

            }
        };
        return backGround;
    }

    /**
     * This function does nothing, we implement sprite and because of that we need that function.
     *
     * @param d the surface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {

    }

    /**
     * This function does nothing, we implement sprite and because of that we need that function.
     */
    @Override
    public void timePassed() {

    }

    /**
     * This function does nothing, we implement sprite and because of that we need that function.
     *
     * @param game The game object.
     */
    @Override
    public void addToGame(GameLevel game) {

    }
}
