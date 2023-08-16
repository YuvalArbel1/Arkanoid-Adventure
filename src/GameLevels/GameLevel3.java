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
public class GameLevel3 extends BasicLevel implements Sprite {
    /**
     * This is the constructor of the class. It calls the constructor of the super class and then adds a block and ball
     * to the game.
     */
    public GameLevel3() {
        super("Green 3", 8, 150);
        //blocks
        int counter = 10;
        int blockHeight = 30, blockWidth = 50, spaceFromCeiling = 160;
        for (int i = 0; i < 6; i++) {
            Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.PINK, Color.GREEN};
            for (int j = 0; j < counter; j++) {
                super.addBlocks(new Block(new Geometry.Rectangle(new Point((780 - blockWidth) - (blockWidth * j),
                        spaceFromCeiling
                                + blockHeight * i),
                        blockWidth, blockHeight), colors[i]));

            }
            counter--;
        }
        super.addBall(new Ball(300, 350, 7, Color.WHITE));
        super.addBall(new Ball(500, 350, 7, Color.WHITE));

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
            velocityList.add(new Velocity(2 * -i, 3));
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
                for (int i = 0; i < 65; i++) {
                    d.setColor(new Color(70 + i * 2, 120 + i * 2, 92));
                    d.fillRectangle(0, 600 - i * 10, 800, 10);
                }


                d.setColor(new Color(72, 57, 58));
                d.fillRectangle(115, 200, 10, 200);
                d.setColor(new Color(4, 68, 42));
                d.fillCircle(120, 200, 15);
                d.setColor(new Color(91, 155, 190));
                d.fillCircle(120, 200, 10);
                d.setColor(new Color(238, 236, 15));
                d.fillCircle(120, 200, 5);
                d.setColor(new Color(44, 88, 99));
                d.fillRectangle(106, 380, 30, 200);
                d.setColor(new Color(241, 206, 179));
                d.fillRectangle(70, 450, 100, 200);
                d.setColor(new Color(127, 227, 190));
                d.fillRectangle(80, 460, 30, 25);
                d.setColor(new Color(37, 192, 135));
                d.fillRectangle(130, 460, 30, 25);
                d.setColor(new Color(196, 8, 77));
                d.fillRectangle(115, 480, 10, 25);
                d.setColor(new Color(222, 229, 160));
                d.fillRectangle(90, 530, 50, 25);

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
