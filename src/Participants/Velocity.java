// 206945107 Yuval Arbel
package Participants;


import Geometry.Point;

/**
 * Participants.Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * The function Participants.Velocity.
     * <p>
     * the function is a constructor.
     * </p>
     *
     * @param dx the dx of velocity
     * @param dy the dy of velocity.
     */
    public Velocity(double dx, double dy) {
        setDx(dx);
        setDy(dy);
    }

    /**
     * The function fromAngleAndSpeed.
     * <p>
     * the function purpose is to calculate the dx and the dy by the given angle and speed.
     * </p>
     *
     * @param angle the angle we get.
     * @param speed the speed we get.
     * @return dx and dy.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle %= 360;
        angle = Math.toRadians(angle);
        double dx = speed * Math.sin(angle);
        double dy = speed * (-1) * Math.cos(angle);
        return new Velocity(dx, dy);
    }

    /**
     * The function applyToPoint.
     * <p>
     * the function take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy)
     * </p>
     *
     * @param p the point we want to change.
     * @return the point after the changing.
     */
    public Point applyToPoint(Point p) {
        double x = p.getX();
        double y = p.getY();
        Point newPosition = new Point(x + this.dx, y + this.dy);
        return newPosition;
    }

    /**
     * The function getDx.
     * <p>
     * the function is a getter for the dx member in the class.
     * </p>
     *
     * @return the dx value.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * The function getDy.
     * <p>
     * the function is a getter for the dy member in the class.
     * </p>
     *
     * @return the dy value.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * The function setDx.
     * <p>
     * the function is a setter to set the dx member in the calss.
     * </p>
     *
     * @param dx1 the value we want to set for the dx member in the class.
     */
    public void setDx(double dx1) {
        this.dx = dx1;
    }

    /**
     * The function setDx.
     * <p>
     * the function is a setter to set the dy member in the calss.
     * </p>
     *
     * @param dy1 the value we want to set for the dy member in the class.
     */
    public void setDy(double dy1) {
        this.dy = dy1;
    }

}