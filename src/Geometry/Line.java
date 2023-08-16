// 206945107 Yuval Arbel
package Geometry;
import java.util.List;

/**
 * Geometry.Line class for making a line from two points.
 *
 * @author Yuval Arbel
 * @version ass6
 */
public class Line {
    private Point start;
    private Point end;
    private double m;
    private static final double THRESHOLD = 0.00000000001;

    /**
     * The function Geometry.Line is a constructor.
     * <p>
     * The function making a line from two points
     * </p>
     *
     * @param start point
     * @param end   point
     */
    public Line(Point start, Point end) {
        setStart(start);
        setEnd(end);

    }

    /**
     * The function Geometry.Line is a constructor.
     * <p>
     * The function making a line from (x1,y1) and (x2,y2)
     * </p>
     *
     * @param x1 a value of the x in the start point
     * @param y1 a value of the y in the start point
     * @param x2 a value of the x in the end point
     * @param y2 a value of the x in the end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        setStart(start);
        setEnd(end);
    }


    /**
     * The function getM.
     * <p>
     * getM returns the slope of this line
     * </p>
     *
     * @param start the start point of this line
     * @param end   the end point of this line
     * @return Returns slope of this line
     */
    public double setM(Point start, Point end) {
        //checking if the slope exists
        if (Math.abs(end.getY() - start().getY()) < THRESHOLD) {
            return 0;
        }
        double m = (end().getY() - start.getY()) / (end.getX() - start.getX());
        this.m = m;
        return m;
    }

    /**
     * The function getB.
     * <p>
     * getB returns returns the cut with the Y-axis
     * </p>
     *
     * @param start the start point of this line
     * @param m     the slope of this line
     * @return Returns the cut with the Y-axis
     */
    public double getB(Point start, double m) {
        double b = (((-m) * start.getX()) + start.getY());
        return b;
    }

    /**
     * The function getM.
     * <p>
     * getM returns  the slope of the line
     * </p>
     *
     * @return Returns the slope of the line.
     */
    public double getM() {
        return m;
    }

    /**
     * The function setStart set the start point of the line.
     * <p>
     * The function setStart set the start point for this line
     * </p>
     *
     * @param start the point we want to set for the start point of this line
     */
    public void setStart(Point start) {
        this.start = start;
    }

    /**
     * The function setEnd set the end point of the line.
     * <p>
     * The function setEnd set the end point for this line
     * </p>
     *
     * @param end the point we want to set for the end point of this line
     */
    public void setEnd(Point end) {
        this.end = end;
    }

    /**
     * The function length.
     * <p>
     * length -- return the length of the line
     * </p>
     *
     * @return Return the length of the line.
     */
    public double length() {
        double x1 = start().getX(), y1 = start().getY();
        double x2 = end().getX(), y2 = end().getY();
        //the formula to calculate the length of a line
        double length = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
        return length;
    }

    /**
     * The function middle.
     * <p>
     * middle -- returns the middle point of the line
     * </p>
     *
     * @return Return the middle point of the line
     */
    public Point middle() {
        //the formula to calculate the middle
        Point middle = new Point(((start.getX() + end.getX()) / 2), ((start.getY() + end.getY()) / 2));
        return middle;
    }

    /**
     * The function start.
     * <p>
     * start returns the start point of the line
     * </p>
     *
     * @return Returns the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * The function end.
     * <p>
     * start returns the end point of the line
     * </p>
     *
     * @return Returns the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * The function intersecInf.
     * <p>
     * intersecInf returns the intersection point of one line with and infinity slope and other normal slope
     * (if there isn't intersection returns null)
     * </p>
     *
     * @param other the other line we want to check if intersect with this line
     * @param x     the x coordination of this line(start or end points)
     * @return Returns the intersection point of two line(if there isn't intersection returns null)
     */
    public Point intersecInf(Line other, double x) {
        Point intersectionPointInf;
        double interY;
        double otherM = other.setM(other.start, other.end);
        double otherB = getB(other.start, otherM);
        double otherX1 = other.start.getX(), otherY1 = other.start.getY();
        double otherX2 = other.end.getX(), otherY2 = other.end.getY();
        //check if other line x is in the domain  of this line x
        if ((x >= otherX1 && x <= otherX2) || (x <= otherX1 && x >= otherX2)
                && checkY(this.start.getY(), this.end.getY(), otherY1, otherY2)) {
            //the formula to check the intersection point
            interY = (otherM * x) + otherB;
            intersectionPointInf = new Point(x, interY);
            return intersectionPointInf;
        } else {
            return null;
        }
    }

    /**
     * The function intersectionPoint.
     * <p>
     * intersectionPoint returns the intersection point of two line(if there isn't intersection returns null)
     * </p>
     *
     * @param other the other line we want to check if intersect with this line
     * @return Returns the intersection point of two line(if there isn't intersection returns null)
     */
    public Point intersectionPoint(Line other) {
        Point intersectionPoint;
        double x, y;
        double otherM = other.setM(other.start, other.end), m = setM(this.start, this.end);
        double otherB = getB(other.start, otherM), b = getB(this.start, m);

        //check if the this.m(slope) and other.m(slope) different
        if ((otherM - m != 0)) {
            x = ((b - otherB) / (otherM - m));
            y = (m * x) + b;
        } else {
            //check if the cut with the Y-axis of the two line equals
            if ((Math.abs(b - otherB) < THRESHOLD) && Math.abs(otherM - m) < THRESHOLD && otherM != 0) {
                return new Point(this.start.getX(), this.start.getY());
            }
            if (Math.abs(b - otherB) < THRESHOLD) {
                return intersectionPointInf(this.start, this.end, other.start, other.end);
            } else {
                return null;
            }
        }
        intersectionPoint = new Point(x, y);
        return intersectionPoint;
    }

    /**
     * The function isInterX.
     * <p>
     * isInterX check if the x1 and x2 of this line are in the domain of other line x1 and other line x2 and both in
     * the domain of the x of the intersection point
     * </p>
     *
     * @param x1    this line (point)start x coordination
     * @param x2    this line (point)end x coordination
     * @param x3    other line (point)start x coordination
     * @param x4    other line  (point)end x coordination
     * @param check this is the x coordination of the intersection point
     * @return Returns true if the x1 and x2 in the domain of other x1 and other x2 and check
     */
    public boolean isInterX(double x1, double x2, double x3, double x4, double check) {
        return (((x1 + THRESHOLD >= check && x2 - THRESHOLD <= check)
                || (x1 - THRESHOLD <= check && x2 + THRESHOLD >= check))
                && ((x3 + THRESHOLD >= check && x4 - THRESHOLD <= check)
                || (x3 - THRESHOLD <= check && x4 + THRESHOLD >= check)));
    }

    /**
     * The function isInterY.
     * <p>
     * isInterX check if the y1 and y2 of this line are in the domain of other line y1 and other line y2 and both in
     * the domain of the y of the intersection point
     * </p>
     *
     * @param y1    this line (point)start y coordination
     * @param y2    this line (point)end y coordination
     * @param y3    other line (point)start y coordination
     * @param y4    other line  (point)end y coordination
     * @param check this is the x coordination of the intersection point
     * @return Returns true if the y1 and y2 in the domain of other y1 and other y2 and check
     */
    public boolean isInterY(double y1, double y2, double y3, double y4, double check) {
        return (((y1 + THRESHOLD >= check && y2 - THRESHOLD <= check)
                || (y1 - THRESHOLD <= check && y2 + THRESHOLD >= check))
                && ((y3 + THRESHOLD >= check && y4 - THRESHOLD <= check)
                || (y3 - THRESHOLD <= check && y4 + THRESHOLD >= check)));
    }

    /**
     * The function checkY.
     * <p>
     * isInterX check if the y1 and y2 of this line are in the domain of other line y1 and other line y2
     * </p>
     *
     * @param y1 this line (point)start y coordination
     * @param y2 this line (point)end y coordination
     * @param y3 other line (point)start y coordination
     * @param y4 other line  (point)end y coordination
     * @return Returns true if the y1 and y2 in the domain of other y1 and other y2
     */
    public boolean checkY(double y1, double y2, double y3, double y4) {
        return ((y3 + THRESHOLD >= y1 && y3 - THRESHOLD <= y2) || (y3 - THRESHOLD <= y1 && y3 + THRESHOLD >= y2))
                || ((y4 + THRESHOLD >= y1 && y4 - THRESHOLD <= y2) || (y4 - THRESHOLD <= y1 && y4 + THRESHOLD >= y1));
    }

    /**
     * The function intersectionPointInf.
     * <p>
     * intersectionPointInf returns the intersection point of two line with and infinity slope
     * </p>
     *
     * @param firstStart  the start point of this line
     * @param firstEnd    the end point of this line
     * @param secondStart the other line start point
     * @param secondEnd   the other line end point
     * @return Returns the intersection point of two line(if there isn't intersection returns null)
     */
    public Point intersectionPointInf(Point firstStart, Point firstEnd, Point secondStart, Point secondEnd) {
        //check the min and max point of each line
        Point firstMin = firstStart.minY(firstEnd);
        Point firstMax = firstStart.maxY(firstEnd);
        Point secondMin = secondStart.minY(secondEnd);
        Point secondMax = secondStart.maxY(secondEnd);
        //making a new line from the min point of the two line and the max point of the two line
        Point comboMin = firstMin.minY(secondMin);
        Point comboMax = firstMax.maxY(secondMax);
        //check if the line are equals
        if (firstMin.equals(secondMin) && firstMax.equals(secondMax)) {
            return firstMin;
        }
        double firstLine = firstMin.distance(firstMax);
        double secondLine = secondMin.distance(secondMax);
        double comboLine = comboMin.distance(comboMax);

        if (((firstLine + secondLine) - comboLine) < THRESHOLD) {
            if (firstMin.equals(secondMax)) {
                return firstMin;
            }
            if (firstMax.equals(secondMin)) {
                return firstMax;
            }
        }
        return null;
    }

    /**
     * The function isIntersecting.
     * <p>
     * isIntersecting returns true if the lines intersect, false otherwise
     * </p>
     *
     * @param other the other line that we want to check if intersect with this line
     * @return Returns true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        double x1 = start.getX(), y1 = start.getY(), x2 = end.getX(), y2 = end.getY();
        double otherX1 = other.start.getX(), otherY1 = other.start.getY();
        double otherX2 = other.end.getX(), otherY2 = other.end.getY();
        //check if line1 have infinity slope
        if (Math.abs(x2 - x1) < THRESHOLD) {
            //check if line 2 have an infinity slope
            if (Math.abs(otherX2 - otherX1) < THRESHOLD) {
                return (checkY(y1, y2, otherY1, otherY2) && Math.abs(x1 - otherX1) < THRESHOLD);
            }
            return ((Math.min(x1, x2) >= Math.min(otherX1, otherX2) && Math.max(x1, x2) <= Math.max(otherX1, otherX2))
                    && (this.intersecInf(other, x1) != null));

        }
        //check if line 2 have an infinity slope
        if (Math.abs(otherX2 - otherX1) < THRESHOLD) {
            //check if line1 have infinity slope
            if (Math.abs(x2 - x1) < THRESHOLD) {
                return (checkY(otherY1, otherY2, y1, y2) && Math.abs(x1 - otherX1) < THRESHOLD);
            }
            return ((Math.min(x1, x2) <= Math.min(otherX1, otherX2) && Math.max(x1, x2) >= Math.max(otherX1, otherX2))
                    && ((intersecInf(this, x1)) != null));
        }
        //if the point have normal slope we are checking the intersection point in other functions
        Point temp = intersectionPoint(other);
        if ((temp != null) && ((Math.abs((this.start.getX()) - temp.getX()) < THRESHOLD)
                && (Math.abs((this.start.getY()) - temp.getY()) < THRESHOLD))) {
            return true;
        }
        return ((temp != null) && isInterY(y1, y2, otherY1, otherY2, temp.getY())
                && isInterX(x1, x2, otherX1, otherX2, temp.getX()));
    }

    /**
     * The function intersectionWith.
     * <p>
     * isIntersecting Returns the intersection point if the lines intersect,
     * and null otherwise.
     * </p>
     *
     * @param other the other line that we want to check if intersect with this line
     * @return Returns the intersection point if the lines intersect,and null otherwise.
     */
    public Point intersectionWith(Line other) {
        boolean temp = false;
        double x1 = start.getX(), y1 = start.getY(), x2 = end.getX(), y2 = end.getY();
        double otherX1 = other.start.getX(), otherY1 = other.start.getY();
        double otherX2 = other.end.getX(), otherY2 = other.end.getY();
        //check if line1 have infinity slope
        if (Math.abs(x2 - x1) < THRESHOLD) {
            //check if line 2 have an infinity slope
            if (Math.abs(otherX2 - otherX1) < THRESHOLD) {
                temp = (checkY(y1, y2, otherY1, otherY2) && (x1 - otherX1) < THRESHOLD);
                if (temp) {
                    return intersectionPointInf(this.start, this.end, other.start, other.end);
                } else {
                    return null;
                }
            } else {
                //if only the first line have an infinity slope, check if there is intersection point
                if (this.intersecInf(other, x1) != null) {
                    Point inter = this.intersecInf(other, x1);
                    if (isInterX(x1, x2, otherX1, otherX2, inter.getX())
                            && (isInterY(y1, y2, otherY1, otherY2, inter.getY()))) {
                        return inter;
                    } else {
                        return null;
                    }
                }
            }
        }
        //check if line 2 have an infinity slope
        if (Math.abs(otherX2 - otherX1) < THRESHOLD) {
            //check if line1 have infinity slope
            if (Math.abs(x2 - x1) < THRESHOLD) {
                temp = (checkY(otherY1, otherY2, y1, y2) && (x1 - otherX1) < THRESHOLD);
                if (temp) {
                    return intersectionPointInf(this.start, this.end, other.start, other.end);
                } else {
                    return null;
                }
            } else {
                //if only the first line have an infinity slope, check if there is intersection point
                if (this.intersecInf(this, otherX1) != null) {
                    Point inter = this.intersecInf(this, otherX1);
                    if (isInterX(x1, x2, otherX1, otherX2, inter.getX())
                            && (isInterY(y1, y2, otherY1, otherY2, inter.getY()))) {
                        return inter;
                    } else {
                        return null;
                    }
                }
            }
        }
        //check if the lines equal
        if (Math.abs(x1 - otherX1) < THRESHOLD && Math.abs(y1 - otherY1) < THRESHOLD
                && Math.abs(x2 - otherX2) < THRESHOLD && Math.abs(y2 - otherY2) < THRESHOLD
                || this.start.equals(other.end) && this.end.equals(other.start)) {
            return null;
        }
        //if we reach to this if we know that the two line have a normal slope
        if (this.intersectionPoint(other) != null) {
            Point inter = this.intersectionPoint(other);
            if (isInterX(x1, x2, otherX1, otherX2, inter.getX())
                    && (isInterY(y1, y2, otherY1, otherY2, inter.getY()))) {
                return inter;
            }
            if ((isInterX(x1, x2, otherX1, otherX2, inter.getX())
                    || (checkY(y1, y2, otherY1, otherY2)))
                    && Math.abs(getM() - other.getM()) < THRESHOLD) {
                return inter;
            }
        }

        return null;
    }

    /**
     * The function equals.
     * <p>
     * equals -- return true is the lines are equal, false otherwise
     * </p>
     *
     * @param other is other line that we want to check if equals to this line.
     * @return Returns true if the lines are equal,false otherwise
     */
    public boolean equals(Line other) {
        Point otherStart = other.start;
        Point otherEnd = other.end;
        boolean temp1 = false, temp2 = false;
        if ((start.equals(otherStart) || start.equals(otherEnd))) {
            temp1 = true;
        }
        if ((end.equals(otherStart) || end.equals(otherEnd))) {
            temp2 = true;
        }
        return (temp1 && temp2);
    }

    /**
     * The function closestIntersectionToStartOfLine
     * <p>
     * the function check which of the intersection point is closer to the line.
     * </p>
     *
     * @param rect the rectangle that the line collied.
     * @return the closet point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> recArray;
        recArray = rect.intersectionPoints(this);
        Point interP;
        if (recArray.isEmpty()) {
            return null;
        }
        interP = recArray.get(0);
        int position = 0;
        for (int i = 0; i < recArray.size(); i++) {
            if (interP.distance(this.start) + THRESHOLD >= recArray.get(i).distance(this.start)) {
                interP = recArray.get(i);
                position = i;
            }
        }
        return recArray.get(position);
    }

    /**
     * The function doubleEquals.
     * <p>
     * the function check if two doubles are equal.
     * </p>
     *
     * @param a a double variable.
     * @param b a duuble variable.
     * @return true if a == b else otherwise
     */
    public static boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) < THRESHOLD;
    }
}





