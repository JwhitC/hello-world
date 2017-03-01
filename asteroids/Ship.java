// Author       : David Collins
// Date Created : 01/31/2017
// Last Modified: 01/31/2017
// Description  : The actual asteroid object (large)
package asteroids;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Random;

/**
 *
 * @author student
 */
public class Ship extends Polygon {

    public static int DEFAULT_SIZE = 25;
    private Point curLoc;
    public static final int speed = 3;
    public static int velocityX;
    public static int velocityY;
    private double orientation;
    public static boolean moveUP;

    private enum Direction {
        NORTH, NORTHEAST, EAST, SOUTHEAST,
        SOUTH, SOUTHWEST, WEST, NORTHWEST
    };
    private Direction direction;
    private Color curColor;
    private int hitPoints;
    private int curSize;

    public Ship(int x, int y) {
        this(DEFAULT_SIZE, x, y);
    }

    public Ship(int r, int x, int y) {
        super();
        npoints = 5;
        curSize = r;
        xpoints = new int[npoints];
        ypoints = new int[npoints];
        xpoints[0] = x + (r / 2);
        ypoints[0] = y + r * 2;
        xpoints[1] = x + r;
        ypoints[1] = y;
        xpoints[2] = x + r * 2 - (r / 2);
        ypoints[2] = y + r * 2;
        xpoints[3] = x + r * 2 - (r / 2) - 8;
        ypoints[3] = y + r * 2 - (r / 3);
        xpoints[4] = x + (r / 2) + 8;
        ypoints[4] = y + r * 2 - (r / 3);
        

        // set up the rest of the characteristics
        curLoc = new Point(x, y);
        orientation = (float) (Math.PI / 2);
        curColor = Color.WHITE;
        hitPoints = 3;

    }

    public Color getColor() {
        return curColor;
    }

    public double getOrientation() {
        return orientation;
    }

    public int getCenterX() {
        return xpoints[0] + curSize / 4;
    }

    public int getCenterY() {
        return ypoints[0] + 3 * curSize / 8;
    }

    public Point getPoint() {
        return curLoc;
    }

    public void setPoint(int x, int y) {
        curLoc.x = x;
        curLoc.y = y;
    }

    public boolean moveUp() {
        velocityY = -1;
        return true;
    }
    public boolean rotateLeft(){
        orientation = Math.PI;
        return true;
    }
    public boolean rotateRight(){
        orientation = -Math.PI;
        return true;
    }

}





