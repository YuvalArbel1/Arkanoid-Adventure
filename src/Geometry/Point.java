// 206945107 Yuval Arbel
package Geometry;

/**
 * Geometry.Point class for making a point from x and y.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class Point {
    private double x;
    private double y;
    private static final double THRESHOLD = 0.00000000001;

    /**
     * The function setX for the x field in the class.
     * <p>
     * The function setX for the x field in the class.
     * </p>
     *
     * @param x1 the number we want to set to the field
     */
    public void setX(double x1) {
        this.x = x1;
    }

    /**
     * The function setY for the y field in the class.
     * <p>
     * The function setX for the y field in the class.
     * </p>
     *
     * @param y1 the number we want to set to the field
     */
    public void setY(double y1) {
        this.y = y1;
    }

    /**
     * The function Geometry.Point is a constructor.
     * <p>
     * The function making a point from x,y fields in the class
     * </p>
     *
     * @param x the x coordination to make a point
     * @param y the y coordination to make a point
     */
    public Point(double x, double y) {
        setX(x);
        setY(y);
    }

    /**
     * The function distance.
     * <p>
     * distance -- return the distance of this point to the other point
     * </p>
     *
     * @param other is other point that we want to measure this distance from this point to other point
     * @return Returns the distance between the two point.
     */
    public double distance(Point other) {
        double x1 = other.getX();
        double y1 = other.getY();
        return Math.sqrt((this.y - y1) * (this.y - y1) + (this.x - x1) * (this.x - x1));
    }

    /**
     * The function equals.
     * <p>
     * equals -- return true is the points are equal, false otherwise
     * </p>
     *
     * @param other is other point that we want to check if equals to this point.
     * @return Returns true if the points are equal,false otherwise
     */
    public boolean equals(Point other) {
        return ((Math.abs(this.x - other.getX()) < THRESHOLD) && (Math.abs(this.y - other.getY()) < THRESHOLD));
    }

    /**
     * The function minY.
     * <p>
     * minY returns the min y between two points
     * </p>
     *
     * @param other is the point that we want to check if other.getY() is bigger or smaller from this.y
     * @return Returns the point with minY
     */
    public Point minY(Point other) {
        if (Math.abs(this.x - other.x) < THRESHOLD) {
            if (Math.abs(this.y - other.getY()) < THRESHOLD) {
                return other;
            } else if (this.y < other.getY()) {
                return this;
            } else {
                return other;
            }
        } else {
            double minX = 0, minY = 0;
            if (Math.abs(this.y - other.getY()) < THRESHOLD) {
                minY = this.y;
            } else if (this.y < other.getY()) {
                minY = this.y;
            } else {
                minY = other.getY();
            }
            if (Math.abs(this.x - other.getX()) < THRESHOLD) {
                minX = this.x;
            } else if (this.x < other.getX()) {
                minX = this.x;
            } else {
                minX = other.getX();
            }
            return new Point(minX, minY);
        }
    }

    /**
     * The function maxY.
     * <p>
     * maxY returns the min y between two points
     * </p>
     *
     * @param other is the point that we want to check if other.getY() is bigger or smaller from this.y
     * @return Returns the point with maxY
     */
    public Point maxY(Point other) {
        if (Math.abs(this.x - other.x) < THRESHOLD) {
            if (Math.abs(this.y - other.getY()) < THRESHOLD) {
                return other;
            } else if (this.y > other.getY()) {
                return this;
            } else {
                return other;
            }
        } else {
            double maxX = 0, maxY = 0;
            if (Math.abs(this.y - other.getY()) < THRESHOLD) {
                maxY = this.y;
            } else if (this.y > other.getY()) {
                maxY = this.y;
            } else {
                maxY = other.getY();
            }
            if (Math.abs(this.x - other.getX()) < THRESHOLD) {
                maxX = this.x;
            } else if (this.x > other.getX()) {
                maxX = this.x;
            } else {
                maxX = other.getX();
            }
            return new Point(maxX, maxY);
        }
    }

    /**
     * The function getX.
     * <p>
     * getX returns the x value of this point
     * </p>
     *
     * @return Returns the x value of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * The function getY.
     * <p>
     * getY returns the y value of this point
     * </p>
     *
     * @return Returns the y value of this point
     */
    public double getY() {
        return this.y;
    }
}