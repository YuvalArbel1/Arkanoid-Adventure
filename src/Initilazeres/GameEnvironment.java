// 206945107 Yuval Arbel
package Initilazeres;

import Geometry.Line;
import Geometry.Point;
import collides.Collidable;
import collides.CollisionInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * Initilazeres.GameEnvironment class.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class GameEnvironment {
    private ArrayList<Collidable> collidableList;
    private static final double THRESHOLD = 0.00000000001;

    /**
     * The function Initilazeres.GameEnvironment.
     * <p>
     * Initilazeres.GameEnvironment a constructor.
     * </p>
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<Collidable>();
    }


    /**
     * The function getCollidableList.
     * <p>
     * getCollidableList getter for the collidablelist member.
     * </p>
     *
     * @return the collidableList.
     */
    public ArrayList<Collidable> getCollidableList() {
        return collidableList;
    }

    /**
     * The function addCollidable
     * <p>
     * the function  add the given collidable to the environment.
     * </p>
     *
     * @param c the collidable that we want to add for to the list.
     */
    public void addCollidable(Collidable c) {
        if (c != null) {
            this.collidableList.add(c);
        }
    }
    /**
     * The function getClosestCollision.
     * <p>
     * the function check and return the closest intersection point from the ball to collidable object.
     * </p>
     *
     * @param trajectory the trajectory of the ball.
     * @return the point that suspect for intersection.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (collidableList.isEmpty()) {
            return null;
        }
        Point interP = null;
        List<Point> interPointList = new ArrayList<>();
        List<Integer> interPointPos = new ArrayList<>();
        //for that run for all the collidables in the list
        for (int i = 0; i < getCollidableList().size(); i++) {
            interP = trajectory.closestIntersectionToStartOfLine(getCollidableList().get(i).getCollisionRectangle());
            //check if the point is a real point
            if (interP != null) {
                interPointList.add(interP);
                interPointPos.add(i);
            }
        }
        //check if the intersection array not empty
        if (!(interPointList.isEmpty())) {
            Point minInter = interPointList.get(0);
            int position = 0;
            for (int i = 0; i < interPointList.size(); i++) {
                //check which point is the minimum point
                if (minInter.distance(trajectory.start()) + THRESHOLD
                        >= interPointList.get(i).distance(trajectory.start())) {
                    minInter = interPointList.get(i);
                    position = interPointPos.get(i);
                }
            }

            return new CollisionInfo(minInter, getCollidableList().get(position));
        }
        return null;
    }
}