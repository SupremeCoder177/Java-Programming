package Games.Game1.Code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements KeyListener {

    private final int windowWidth = 800;
    private final int windowHeight = 468;

    private final int FPS = 30;
    private final long frameTime = 1000000000 / FPS;

    private BufferedImage ground;
    private BufferedImage sky;

    private Player player;

    GamePanel(){
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(this);
        this.setFocusable(true);

        // loading bg images
        try {
            this.ground = ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/background/ground.png"));
            this.sky = ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/background/Sky.png"));
        } catch (IOException e) {
            System.out.println("Failed to load background graphics");
        }

        // setting the player
        this.player = new Player(100, this.windowHeight - this.ground.getHeight() - 84);
    }

    public void run(){
        while(true){

            long startTime = System.nanoTime();

            update();
            repaint();

            long endTime = System.nanoTime();

            if(endTime - startTime < frameTime){
                try{
                    Thread.sleep( (frameTime - (endTime - startTime)) / 1000000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }

    private void update(){
        this.player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // drawing the background
        g2.drawImage(this.sky, 0, 0, this.windowWidth, this.sky.getHeight(), null);
        g2.drawImage(this.ground, 0, this.sky.getHeight(), this.windowWidth, this.ground.getHeight(), null);

        this.player.draw(g2);

        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            this.player.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
