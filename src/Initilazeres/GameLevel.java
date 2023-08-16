// 206945107 Yuval Arbel
package Initilazeres;


import Animation.Animation;
import Geometry.Point;
import Geometry.Rectangle;
import Participants.Ball;
import Participants.Block;
import Participants.Paddle;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import collides.Collidable;
import collides.Sprite;
import collides.SpriteCollection;
import listeners.BlockRemover;
import listeners.Counter;
import listeners.BallRemover;
import listeners.ScoreTrackingListener;
import listeners.ScoreIndicator;
import Animation.AnimationRunner;
import Animation.PauseScreen;
import Animation.KeyPressStoppableAnimation;
import Animation.CountdownAnimation;


import java.awt.Color;

/**
 * Initilazeres.Game class for initialize the game.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class GameLevel implements Animation {
    private final SpriteCollection sprites;
    private final GameEnvironment environment;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter score;
    private GUI gui;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;


    /**
     * The function addCollidable.
     * <p>
     * the functiom add collidable for the environment member of the class.
     * </p>
     *
     * @param c the collidable we want to add.
     */
    public void addCollidable(Collidable c) {
        if (c != null) {
            this.environment.addCollidable(c);
        }
    }

    /**
     * The function addSprite.
     * <p>
     * the function add sprite for the sprites member.
     * </p>
     *
     * @param s the spirte we want to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }


    /**
     * This is the constructor of the class.
     *
     * @param runner           the runner
     * @param keyboard         the keyboard
     * @param levelInformation the level information
     * @param scoreCounter     the score counter
     */
    public GameLevel(AnimationRunner runner, KeyboardSensor keyboard, LevelInformation levelInformation,
                     Counter scoreCounter) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.score = scoreCounter;
        this.runner = runner;
        this.running = true;
        this.keyboard = keyboard;
        this.levelInformation = levelInformation;
        this.blockCounter = new Counter();
        this.blockCounter.increase(this.levelInformation.numberOfBlocksToRemove());
        this.ballCounter = new Counter();
        ballCounter.increase(this.levelInformation.numberOfBalls());
    }

    /**
     * The function Initilazeres.GameEnvironment.
     * <p>
     * Initilazeres.GameEnvironment getter for the gamernvironment member.
     * </p>
     *
     * @return the environment.
     */
    public GameEnvironment getGameEnvironment() {
        return this.environment;
    }


    /**
     * It adds the background, the boundaries, the death block, the score indicator, the paddle,
     * the balls and the blocks to the game by the order given by the level info list.
     */
    public void initialize() {
        BlockRemover blockRemover = new BlockRemover(this, this.blockCounter);
        BallRemover ballRemover = new BallRemover(this, this.ballCounter);
        PrintingHitListener printingHitListener = new PrintingHitListener();
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        this.addSprite(this.levelInformation.getBackground());

        //Boundaries
        Point upBorder = new Point(0, 20);
        Point leftBorder = new Point(0, 40);
        Point rightBorder = new Point(780, 40);
        Point downBorder = new Point(20, 600);
        new Block(new Rectangle(upBorder, 800, 20), Color.GRAY).addToGame(this);
        new Block(new Rectangle(leftBorder, 20, 560), Color.GRAY).addToGame(this);
        new Block(new Rectangle(rightBorder, 20, 560), Color.GRAY).addToGame(this);
        new Block(new Rectangle(new Point(0, 0), 800, 20), Color.LIGHT_GRAY).addToGame(this);
        Block deathBlock = new Block(new Rectangle(downBorder, 780, 20), Color.GRAY);
        deathBlock.addToGame(this);
        deathBlock.addHitListener(ballRemover);

        // It creates a new score indicator with the given score and adds it to the game.
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        scoreIndicator.addToGame(this);
        // It creates a new paddle with the given rectangle and keyboard.
        Paddle paddle = new Paddle(new Rectangle(new Point(
                400 - (double) this.levelInformation.paddleWidth() / 2, 565),
                this.levelInformation.paddleWidth(), 15), this.keyboard);
        paddle.addToGame(this);
        // Adding the balls to the game.
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball = this.levelInformation.balls().get(i);
            ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
            ball.addToGame(this);
            paddle.addBalls(ball);
        }
        // This is a for loop that goes over all the blocks in the level and adds them to the game.
        for (int i = 0; i < levelInformation.numberOfBlocksToRemove(); i++) {
            Block block = this.levelInformation.blocks().get(i);
            block.addToGame(this);
            block.addHitListener(printingHitListener);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
        }
    }

    /**
     * If the given collidable is not null, remove it from the list of collidables.
     *
     * @param c The collidable object to be removed from the environment.
     */
    public void removeCollidable(Collidable c) {
        if (c != null) {
            this.environment.getCollidableList().remove(c);
        }
    }

    /**
     * If the sprite is not null, remove it from the list of sprites.
     *
     * @param s The sprite to be removed.
     */
    public void removeSprite(Sprite s) {
        if (s != null) {
            this.sprites.getList().remove(s);
        }
    }


    /**
     * The function runs the game by running the countdown animation and then running the game level.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites, this.levelInformation));
        this.running = true;
        this.runner.run(this);

    }


    /**
     * The function draws all the sprites on the surface, notifies all the sprites that time has passed,
     * draws the level name, checks if the user pressed the "p" key and if so, runs a new animation,
     * and checks if the game is over.
     *
     * @param d the surface to draw on
     */
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        d.drawText(550, 17, "Level Name: " + this.levelInformation.levelName(), 17);

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, this.keyboard.SPACE_KEY,
                    new PauseScreen(this.keyboard)));
        }

        if (this.ballCounter.getValue() > 0 && this.blockCounter.getValue() <= 0) {
            this.score.increase(100);
            this.running = false;
        }
        if (this.ballCounter.getValue() <= 0 || this.blockCounter.getValue() <= 0) {
            this.running = false;
        }
    }


    /**
     * If the running variable is false, return true, otherwise return false.
     *
     * @return The boolean value of the variable running.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * This function returns the value of the blockCounter variable.
     *
     * @return The value of the blockCounter variable.
     */
    public int getBlockCounter() {
        return blockCounter.getValue();
    }

    /**
     * This function returns the value of the ballCounter variable.
     *
     * @return The value of the ballCounter variable.
     */
    public int getBallCounter() {
        return ballCounter.getValue();
    }
}