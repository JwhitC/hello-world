// Author       : David Collins
// Date Created : 01/31/2017
// Last Modified: 01/31/2017
// Description  : The actual asteroid object (small)
package asteroids;

import static asteroids.AsteroidLg.speed;
import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Random;

/**
 *
 * @author student
 */
public class AsteroidSm extends AsteroidLg {

    public static int DEFAULT_SIZE = 30;
    private Point curLoc;
    public static final int speed = 5;
    private float orientation;

    private enum Direction {
        NORTH, NORTHEAST, EAST, SOUTHEAST,
        SOUTH, SOUTHWEST, WEST, NORTHWEST
    };
    private Direction direction;
    private Color curColor;
    private static final int pointValue = 100;
    private int hitPoints;
    private static Random rand;
    private int curSize;

    public AsteroidSm(int x, int y) {
        this(DEFAULT_SIZE, x, y);
    }

    public AsteroidSm(int r, int x, int y) {
        super(r, x, y);
        npoints = 7;
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
       

        // set up the rest of the characteristics
        //curLoc;
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

        curColor = Color.WHITE;
        hitPoints = 3;

    }
}
