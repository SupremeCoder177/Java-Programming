package basics;

import basics.entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //SCREEN Settings
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    final int maxCol = 16;
    final int maxRow = 12;

    final int window_width = tileSize * maxCol;
    final int window_height = tileSize * maxRow;

    final int FPS = 60;

    Thread gameThread;
    keyHandler handler = new keyHandler();
    Player player = new Player(this, handler);

    // player positions
    // int player_x = 100, player_y = 100, playerSpeed = 10;

    public GamePanel(){

        // setting the screen size
        this.setPreferredSize(new Dimension(window_width, window_height));

        // setting the bg color
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        // adding a key listener to the panel
        this.addKeyListener(handler);

        // this makes sure the key handler class is listening to ths input
        // on this panel
        this.setFocusable(true);
    }

    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        // the run method is automatically called by the gameThread (don't ask why)

        // getting the time a single frame should take to render
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){
            // System.out.println("The game is running");

            // getting the current system time
            long currentTime = System.nanoTime();

            // We do two things in the game loop
            // 1 update : update the positions, images and collision detection
            update();

            // 2 draw : draw the updated screen

            // the repaint method calls the paintComponent method
            repaint();

            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime / 1000000;

            // checking if no time is left
            if(remainingTime < 0) remainingTime = 0;

            try {
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }

    public void update(){
        player.update();
    }

    // the paint component is a built-in method in Java
    public  void paintComponent(Graphics g){
        super.paintComponent(g);

        // Graphics2D is a more useful class than graphics g
        Graphics2D g2 = (Graphics2D) g;

        // drawing a rectangle on the screen
        /*
        g2.setColor(Color.WHITE);
        g2.fillRect(player_x, player_y, tileSize, tileSize);
        */

        player.draw(g2);

        // remember to dispose the Graphics2D object
        g2.dispose();
    }
}
