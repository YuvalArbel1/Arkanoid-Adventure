// 206945107 Yuval Arbel
package Geometry;

import java.util.ArrayList;
import java.util.List;


/**
 * Geometry.Rectangle class for making a rectangle shape.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class Rectangle {
    private Point upperLeft;
    private Point upperRight;
    private Point lowerLeft;
    private Point lowerRight;
    private double width;
    private double height;
    private Line[] recArray;


    /**
     * The  function Geometry.Rectangle
     * <p>
     * the function is a  constructor.
     * </p>
     *
     * @param upperLeft the upper left point of the rectangle.
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        setHeight(height);
        setWidth(width);
        setUpperLeft(upperLeft);
        setUpperRight(new Point(getUpperLeft().getX() + getWidth(), getUpperLeft().getY()));
        setLowerLeft(new Point(getUpperLeft().getX(), getUpperLeft().getY() + getHeight()));
        setLowerRight(new Point(getUpperLeft().getX() + getWidth(), getUpperLeft().getY() + getHeight()));
        setRecArray();
    }

    /**
     * The function setRecArray.
     * <p>
     * the function set the recarray member in the class.
     * </p>
     */
    public void setRecArray() {
        Line[] recArray = new Line[4];
        //up line
        recArray[0] = new Line(getUpperLeft(), getUpperRight());
        //lower line
        recArray[1] = new Line(getLowerLeft(), getLowerRight());
        //left line
        recArray[2] = new Line(getUpperLeft(), getLowerLeft());
        //right line
        recArray[3] = new Line(getUpperRight(), getLowerRight());
        this.recArray = recArray;
    }

    /**
     * The function setNewRac
     * <p>
     * the function set new recarray from ew rectangle.
     * </p>
     *
     * @param rectangle a new rectnagle we need to sed is recarray
     */
    public void setNewRac(Rectangle rectangle) {
        setUpperLeft(rectangle.getUpperLeft());
        setUpperRight(rectangle.getUpperRight());
        setLowerRight(rectangle.getLowerRight());
        setLowerLeft(rectangle.getLowerLeft());
        setRecArray();
    }


    // Return a (possibly empty) List of intersection points
    // with the specified line.

    /**
     * The function intersectionPoints.
     * <p>
     * the function get all the intersection point of line with this rectangle.
     * </p>
     *
     * @param line the line we want if intersect with the rectangle
     * @return array of the intersection point.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Line[] lines = this.recArray;
        List<Point> interPoint = new ArrayList<>();
        //run on akk the lines of the rectangle shape
        for (int i = 0; i < lines.length; i++) {
            if (line.intersectionWith(lines[i]) != null) {
                interPoint.add(line.intersectionWith(lines[i]));
            }
        }
        return interPoint;
    }

    /**
     * The function setNewMove.
     * <p>
     * change the position of the rectangle (paddle)
     * </p>
     *
     * @param move the number of movement
     */
    public void setNewMove(double move) {
        Point point = new Point(getUpperLeft().getX() + move, getUpperLeft().getY());
        Rectangle rectangle = new Rectangle(point, getWidth(), getHeight());
        setNewRac(rectangle);
    }


    /**
     * The function getRecArray.
     * <p>
     * the function is a getter.
     * </p>
     *
     * @return the rectangle lines array.
     */
    public Line[] getRecArray() {
        setRecArray();
        return this.recArray;
    }

    /**
     * The function getWidth.
     * <p>
     * the function is a getter of the width.
     * </p>
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * The function getHeight.
     * <p>
     * the function is a getter of the height.
     * </p>
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * The function getUpperLeft.
     * <p>
     * the function is a getter of upper left point of the rectangle shape
     * </p>
     *
     * @return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * The function getUpperLeft.
     * <p>
     * the function is a getter of upper left point of the rectangle shape
     * </p>
     *
     * @return the upper left point of the rectangle.
     */
    public Point getUpperRight() {
        return upperRight;
    }

    /**
     * The function getLowerLeft.
     * <p>
     * the function is a getter of lower left point of the rectangle shape
     * </p>
     *
     * @return the lower left point of the rectangle.
     */
    public Point getLowerLeft() {
        return lowerLeft;
    }

    /**
     * The function getLowerRight.
     * <p>
     * the function is a getter of lower right point of the rectangle shape
     * </p>
     *
     * @return the lower right point of the rectangle.
     */
    public Point getLowerRight() {
        return lowerRight;
    }

    /**
     * The function setHeight.
     * <p>
     * the function is a setter for the height member in the class.
     * </p>
     *
     * @param height the height of the rectangle.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * The function setUpperLeft.
     * <p>
     * the function is a setter for the upperLeft member in the class.
     * </p>
     *
     * @param upperLeft the upperLeft point of the rectangle
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    /**
     * The function setUpperRight.
     * <p>
     * the function is a setter for the upperRight member in the class.
     * </p>
     *
     * @param upperRight the upperRight point of the rectangle
     */
    public void setUpperRight(Point upperRight) {
        this.upperRight = upperRight;
    }

    /**
     * The function setLowerLeft.
     * <p>
     * the function is a setter for the lowerLeft member in the class.
     * </p>
     *
     * @param lowerLeft the lowerLeft point of the rectangle
     */
    public void setLowerLeft(Point lowerLeft) {
        this.lowerLeft = lowerLeft;
    }

    /**
     * The function setLowerRight.
     * <p>
     * the function is a setter for the lowerRight member in the class.
     * </p>
     *
     * @param lowerRight the lowerRight point of the rectangle
     */
    public void setLowerRight(Point lowerRight) {
        this.lowerRight = lowerRight;
    }

    /**
     * The function setWidth.
     * <p>
     * the function is a setter for the width member in the class.
     * </p>
     *
     * @param width the width of the rectangle.
     */
    public void setWidth(double width) {
        this.width = width;
    }
}