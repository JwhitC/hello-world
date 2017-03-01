// Author       : Jonathan Whitmore
// Date Created : 1/31/2017
// Last Modified: 1/31/2017
// Description  : Control the flow of the Asteroid game.
package asteroids;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Jonat
 */
public class Game {

    private JFrame window;
    private Space space;
    private Timer timer;
    private int count;

    public Game() {
        window = new JFrame("Asteroids 1.0");
        window.setSize(800, 600);
//        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        //Create the space
        space = new Space();

        // Add the space and display the game
        window.add(space);
        window.setVisible(true);
        space.setAsteroids();
        space.setShip();

        // Create the keyboard listener
        window.addKeyListener(new MoveShip());

        // Create the Timer
        timer = new Timer(32, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            space.moveAsteroids();
        }

    }

    private class MoveShip implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    System.out.println("FIRE!");
                    break;
                case KeyEvent.VK_UP:
                    Ship.moveUP = true;
                    if (Ship.moveUP == true)
                        Ship.velocityY = -1;
                    System.out.println("Accelerate!");
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("Deccelerate...");
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("Rotate clockwise");
                    break;
                case KeyEvent.VK_LEFT:
                    System.out.println("Rotate counterclockwise");
                    break;
                case KeyEvent.VK_I:
                    System.out.println("Toggle Invincibility");
                    break;
//    KEY PRESSED - turn flags on (use flags rather than method calls)
//    switch(KeyEvent k) {
//    case KeyEvent.VK_SPACE:
//    case KeyEvent.VK_UP: movingUp-true;
//    case KeyEvent.VK_
//}
//    KEY RELEASED - turn flags off...
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    System.out.println("FIRE!");
                    break;
                case KeyEvent.VK_UP:
                    Ship.moveUP = false;
                    if (Ship.moveUP == false)
                        Ship.velocityY = 0;
                    System.out.println("Accelerate!");
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("Deccelerate...");
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("Rotate clockwise");
                    break;
                case KeyEvent.VK_LEFT:
                    System.out.println("Rotate counterclockwise");
                    break;
                case KeyEvent.VK_I:
                    System.out.println("Toggle Invincibility");
                    break;
            }
            //fireBullet() - initialize bullet
        }

    }
} 
