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
 * GameLevel1 class.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class GameLevel1 extends BasicLevel implements Sprite {


    /**
     * This is the constructor of the class. It calls the constructor of the super class and then adds a block and ball
     * to the game.
     */
    public GameLevel1() {
        super("Direct Hit", 5, 150);
        super.addBlocks(new Block(new Rectangle(new Point(385, 195), 30, 30), Color.RED));
        super.addBall(new Ball(new Point(398, 550), 5, Color.white));
    }

    /**
     * It returns a list of velocities for the balls.
     *
     * @return a list of velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(new Velocity(0, 4));
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
                    d.setColor(new Color(50 + i / 2, 20 + i * 3, 140 + i));
                    d.fillRectangle(0, 600 - i * 10, 800, 10);
                }
                //d.setColor(new Color(200,20,198));
                d.setColor(Color.black);
                d.drawCircle(400, 210, 100);
                d.drawCircle(400, 210, 70);
                d.drawCircle(400, 210, 40);
                d.drawLine(400, 240, 400, 320);
                d.drawLine(400, 180, 400, 100);
                d.drawLine(430, 215, 510, 215);
                d.drawLine(370, 215, 290, 215);
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
     *
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
