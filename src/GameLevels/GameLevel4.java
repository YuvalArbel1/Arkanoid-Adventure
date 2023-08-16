// 206945107 Yuval Arbel
package GameLevels;

import Geometry.Point;
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
 * GameLevel3 class.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class GameLevel4 extends BasicLevel implements Sprite {
    /**
     * This is the constructor of the class. It calls the constructor of the super class and then adds a block and ball
     * to the game.
     */
    public GameLevel4() {
        super("Final Four", 12, 120);
        int blockHeight = 30, spaceFromCeiling = 90;
        double blockWidth = 63.333;

        for (int i = 0; i < 7; i++) {
            Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN, Color.WHITE, Color.PINK, Color.CYAN};
            for (int j = 0; j < 12; j++) {
                super.addBlocks(new Block(new Geometry.Rectangle(new Point((780 - blockWidth) - (blockWidth * j),
                        spaceFromCeiling
                                + blockHeight * i),
                        blockWidth, blockHeight), colors[i]));
            }
        }
        super.addBall(new Ball(340, 450, 6, Color.WHITE));
        super.addBall(new Ball(460, 450, 6, Color.WHITE));
        super.addBall(new Ball(400, 430, 6, Color.WHITE));

    }

    /**
     * It returns a list of velocities for the balls.
     *
     * @return a list of velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            velocityList.add(new Velocity(2 * -i, 2));
        }
        velocityList.add(new Velocity(1, 4));
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
                for (int i = 0; i < 65; i++) {
                    d.setColor(new Color(30 + i + 5, 140 + i + 5, 212));
                    d.fillRectangle(0, 600 - i * 10, 800, 10);
                }


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
                for (int i = 0; i < 10; i++) {
                    d.drawLine(510 + i * 10, 520, 570 + i * 10, 600);
                }
                for (int j = 0; j < 10; ++j) {
                    d.drawLine(220 + j * 10, 445, 180 + j * 10, 600);
                }

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
