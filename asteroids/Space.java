// Author       : Jonathan Whitmore
// Date Created : 1/31/2017
// Last Modified: 1/31/2017
// Description  : House the space and everything inside the space.
package asteroids;

import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Jonat
 */
public class Space extends JPanel {

    private AsteroidLg[] rockL;
    private int curLevel;
    private Random rand;
    private AsteroidMd[] rockM;
    private AsteroidSm[] rockS;
    private Ship ship;

    public Space() {
        setBackground(Color.BLACK);

        rand = new Random();
        curLevel = 1;

    }

    public void setAsteroids() {
        rockL = new AsteroidLg[curLevel * 2 + 3];
        for (int i = 0; i < rockL.length; i++) {
            rockL[i] = new AsteroidLg(rand.nextInt(getWidth()),
                    rand.nextInt(getHeight()));
        }

        rockM = new AsteroidMd[curLevel * 2 + 3];
        for (int i = 0; i < rockM.length; i++) {
            rockM[i] = new AsteroidMd(rand.nextInt(getWidth()),
                    rand.nextInt(getHeight()));
        }

        rockS = new AsteroidSm[curLevel * 2 + 3];
        for (int i = 0; i < rockS.length; i++) {
            rockS[i] = new AsteroidSm(rand.nextInt(getWidth()),
                    rand.nextInt(getHeight()));
        }
    }
    public void setShip() {
        ship = new Ship(getWidth()/2, getHeight()/2);
        }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw the Asteroids
        g2.setColor(rockL[0].getColor());
        for (AsteroidLg a : rockL) {
            g2.rotate(a.getOrientation(), a.getCenterX(), a.getCenterY());
            g2.draw(a);
            g2.rotate(-a.getOrientation(), a.getCenterX(), a.getCenterY());
        }

        g2.setColor(rockM[0].getColor());
        for (AsteroidMd a : rockM) {
            g2.rotate(a.getOrientation(), a.getCenterX(), a.getCenterY());
            g2.draw(a);
            g2.rotate(-a.getOrientation(), a.getCenterX(), a.getCenterY());
        }

        g2.setColor(rockS[0].getColor());
        for (AsteroidSm a : rockS) {
            g2.rotate(a.getOrientation(), a.getCenterX(), a.getCenterY());
            g2.draw(a);
            g2.rotate(-a.getOrientation(), a.getCenterX(), a.getCenterY());
        }
//        set color for bullet
//        paint bullet

        g2.setColor(ship.getColor());
        g2.draw(ship); 
    }

    public void moveAsteroids() {
        for (AsteroidLg a : rockL) {
            a.move();
            if (a.getPoint().x >= getWidth()) {
                a.translate(-getWidth() - a.DEFAULT_SIZE, 0);
                a.setPoint(a.getPoint().x - getWidth() - a.DEFAULT_SIZE, a.getPoint().y);
            }
            if (a.getPoint().x <= 0 - a.DEFAULT_SIZE) {
                a.translate(getWidth() + a.DEFAULT_SIZE, 0);
                a.setPoint(a.getPoint().x + getWidth() + a.DEFAULT_SIZE, a.getPoint().y);
            }

            if (a.getPoint().y > getHeight()) {
                a.translate(0, -getHeight() - a.DEFAULT_SIZE);
                a.setPoint(a.getPoint().x, a.getPoint().y - getHeight() - a.DEFAULT_SIZE);
            }

            if (a.getPoint().y + a.DEFAULT_SIZE < 0) {
                a.translate(0, getHeight() + a.DEFAULT_SIZE);
                a.setPoint(a.getPoint().x, a.getPoint().y + getHeight() + a.DEFAULT_SIZE);
            }
            repaint();
        }
        for (AsteroidMd a : rockM) {
            a.move();
            if (a.getPoint().x >= getWidth()) {
                a.translate(-getWidth() - a.DEFAULT_SIZE, 0);
                a.setPoint(a.getPoint().x - getWidth() - a.DEFAULT_SIZE, a.getPoint().y);
            }
            if (a.getPoint().x <= 0 - a.DEFAULT_SIZE) {
                a.translate(getWidth() + a.DEFAULT_SIZE, 0);
                a.setPoint(a.getPoint().x + getWidth() + a.DEFAULT_SIZE, a.getPoint().y);
            }

            if (a.getPoint().y > getHeight()) {
                a.translate(0, -getHeight() - a.DEFAULT_SIZE);
                a.setPoint(a.getPoint().x, a.getPoint().y - getHeight() - a.DEFAULT_SIZE);
            }

            if (a.getPoint().y + a.DEFAULT_SIZE < 0) {
                a.translate(0, getHeight() + a.DEFAULT_SIZE);
                a.setPoint(a.getPoint().x, a.getPoint().y + getHeight() + a.DEFAULT_SIZE);
            }

        }

        for (AsteroidSm a : rockS) {
            a.move();
            if (a.getPoint().x >= getWidth()) {
                a.translate(-getWidth() - a.DEFAULT_SIZE, 0);
                a.setPoint(a.getPoint().x - getWidth() - a.DEFAULT_SIZE, a.getPoint().y);
            }
            if (a.getPoint().x <= 0 - a.DEFAULT_SIZE) {
                a.translate(getWidth() + a.DEFAULT_SIZE, 0);
                a.setPoint(a.getPoint().x + getWidth() + a.DEFAULT_SIZE, a.getPoint().y);
            }

            if (a.getPoint().y > getHeight()) {
                a.translate(0, -getHeight() - a.DEFAULT_SIZE);
                a.setPoint(a.getPoint().x, a.getPoint().y - getHeight() - a.DEFAULT_SIZE);
            }

            if (a.getPoint().y + a.DEFAULT_SIZE < 0) {
                a.translate(0, getHeight() + a.DEFAULT_SIZE);
                a.setPoint(a.getPoint().x, a.getPoint().y + getHeight() + a.DEFAULT_SIZE);
            }
            repaint();
        }
    }
    
    public void moveShip() {
        ship.moveUp();
        ship.rotateLeft();
        ship.rotateRight();
        if (ship.getPoint().x >= getWidth()) {
                ship.translate(-getWidth() - ship.DEFAULT_SIZE, 0);
                ship.setPoint(ship.getPoint().x - getWidth() - ship.DEFAULT_SIZE, ship.getPoint().y);
            }
            if (ship.getPoint().x <= 0 - ship.DEFAULT_SIZE) {
                ship.translate(getWidth() + ship.DEFAULT_SIZE, 0);
                ship.setPoint(ship.getPoint().x + getWidth() + ship.DEFAULT_SIZE, ship.getPoint().y);
            }

            if (ship.getPoint().y > getHeight()) {
                ship.translate(0, -getHeight() - ship.DEFAULT_SIZE);
                ship.setPoint(ship.getPoint().x, ship.getPoint().y - getHeight() - ship.DEFAULT_SIZE);
            }

            if (ship.getPoint().y + ship.DEFAULT_SIZE < 0) {
                ship.translate(0, getHeight() + ship.DEFAULT_SIZE);
                ship.setPoint(ship.getPoint().x, ship.getPoint().y + getHeight() + ship.DEFAULT_SIZE);
            }
            repaint();
    }
}
