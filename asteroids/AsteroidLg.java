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
public class AsteroidLg extends Polygon {

    public static int DEFAULT_SIZE = 80;
    private Point curLoc;
    public static final int speed = 3;
    private float orientation;

    private enum Direction {
        NORTH, NORTHEAST, EAST, SOUTHEAST,
        SOUTH, SOUTHWEST, WEST, NORTHWEST
    };
    private Direction direction;
    private Color curColor;
    private static final int pointValue = 20;
    private int hitPoints;
    private static Random rand;
    private int curSize;

    public AsteroidLg(int x, int y) {
        this(DEFAULT_SIZE, x, y);
    }

    public AsteroidLg(int r, int x, int y) {
        super();
        npoints = 11;
        curSize = r;
        xpoints = new int[npoints];
        ypoints = new int[npoints];
        xpoints[0] = x + r / 4;
        ypoints[0] = y + r / 8;
        xpoints[1] = x + r / 2;
        ypoints[1] = y + r / 4;
        xpoints[2] = x + r / 2;
        ypoints[2] = y;
        xpoints[3] = x + 7 * r / 8;
        ypoints[3] = y + r / 8;
        xpoints[4] = x + r;
        ypoints[4] = y + 5 * r / 8;
        xpoints[5] = x + 7 * r / 8;
        ypoints[5] = y + 7 * r / 8;
        xpoints[6] = x + 5 * r / 8;
        ypoints[6] = y + r;
        xpoints[7] = x + r / 4;
        ypoints[7] = y + 7 * r / 8;
        xpoints[8] = x + r / 8;
        ypoints[8] = y + 3 * r / 4;
        xpoints[9] = x + r / 4;
        ypoints[9] = y + 5 * r / 8;
        xpoints[10] = x;
        ypoints[10] = y + r / 2;

        // set up the rest of the characteristics
        curLoc = new Point(x, y);
        rand = new Random();
        orientation = rand.nextFloat() * 2 * (float) Math.PI;
        switch (rand.nextInt(8)) {
            case 0:
                direction = Direction.NORTH;
                break;
            case 1:
                direction = Direction.NORTHWEST;
                break;
            case 2:
                direction = Direction.WEST;
                break;
            case 3:
                direction = Direction.SOUTHWEST;
                break;
            case 4:
                direction = Direction.SOUTH;
                break;
            case 5:
                direction = Direction.SOUTHEAST;
                break;
            case 6:
                direction = Direction.EAST;
                break;
            default:
                direction = Direction.NORTHEAST;
        }

        curColor = Color.RED;
        
        hitPoints = 3;

    }

    public Color getColor() {
        return curColor;
    }

    public float getOrientation() {
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

    public void move() {

        switch (direction) {
            case NORTH:
                translate(0, -speed);
                curLoc.y -= speed;
                break;

            case NORTHEAST:
                translate(speed, -speed);
                curLoc.x += speed;
                curLoc.y -= speed;
                break;

            case EAST:
                translate(speed, 0);
                curLoc.x += speed;
                break;

            case SOUTHEAST:
                translate(speed, speed);
                curLoc.x += speed;
                curLoc.y += speed;
                break;

            case SOUTH:
                translate(0, speed);
                curLoc.y += speed;
                break;

            case SOUTHWEST:
                translate(-speed, speed);
                curLoc.x -= speed;
                curLoc.y += speed;
                break;

            case WEST:
                translate(-speed, 0);
                curLoc.x -= speed;
                break;
            case NORTHWEST:
                translate(-speed, -speed);
                curLoc.x -= speed;
                curLoc.y -= speed;
                break;

        }

    }

} 
