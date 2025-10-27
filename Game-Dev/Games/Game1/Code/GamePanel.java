package Games.Game1.Code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel{

    private final int windowWidth = 800;
    private final int windowHeight = 468;

    private final int FPS = 30;
    private final long frameTime = 1000000000 / FPS;

    private BufferedImage ground;
    private BufferedImage sky;

    private Player player;
    private boolean running = false;

    private int score = 0;

    private KeyHandler handler = new KeyHandler(this);
    private final int enemyCount = 2;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Random random = new Random();

    GamePanel(){
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(new Color(100, 150, 200));
        this.addKeyListener(handler);
        this.setFocusable(true);

        // loading bg images
        try {
            this.ground = ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/background/ground.png"));
            this.sky = ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/background/Sky.png"));
        } catch (IOException e) {
            System.out.println("Failed to load background graphics");
        }

        // setting the player
        this.player = new Player(100, this.windowHeight - this.ground.getHeight() - 84, this);
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
        if(this.running) {
            this.player.update();
            this.score += 1;

            if(this.enemies.size() < this.enemyCount){
                int rand = this.random.nextInt(0, 2);
                int x = this.random.nextInt(100, 200);
                int endX = this.random.nextInt(100, 200);

                if(!this.enemies.isEmpty()) {
                    if (x - this.enemies.get(this.enemies.size() - 1).getX() < 100) {
                        x += this.random.nextInt(150, 250);
                    }
                }

                switch (rand) {
                    case 0:
                        this.enemies.add(new Enemy("fly", this.windowWidth + x, 130, -endX));
                        break;
                    case 1:
                        this.enemies.add(new Enemy("snail", this.windowWidth + x, this.windowHeight - this.ground.getHeight() - 36, -endX));
                        break;
                }
            }
            ArrayList<Enemy> temp = this.enemies;
            int count = 0;
            for(int i = 0; i < temp.size(); i++){
                if(temp.get(i).reachedEnd){
                    this.enemies.remove(i - count);
                    count++;
                }else{
                    this.enemies.get(i).update();
                }
            }

            for(Enemy enemy : this.enemies){
                if(this.player.checkCollide(enemy)) {
                    this.stop();
                    break;
                }
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Cascadia Mono", Font.BOLD, 24));
        // drawing the background
        if(this.running) {
            g2.drawImage(this.sky, 0, 0, this.windowWidth, this.sky.getHeight(), null);
            g2.drawImage(this.ground, 0, this.sky.getHeight(), this.windowWidth, this.ground.getHeight(), null);

            for(Enemy enemy : this.enemies){
                enemy.draw(g2);
            }

        }else{
            int x = this.windowWidth / 2 - (g2.getFontMetrics().stringWidth("Press Space to Continue") / 2);
            int y = this.windowHeight / 2 - (g2.getFontMetrics().getHeight() / 2) + 100;

            g2.drawString("Press Space to Continue", x, y);
        }
        this.player.draw(g2);
        g2.drawString("Score : " + this.score, this.windowWidth / 2 - (g2.getFontMetrics().stringWidth("Score : " + this.score) / 2), 30);

        g2.dispose();
    }

    public Player getPlayer()
    { return this.player; }

    public void stop() {
        this.running = false;
        this.enemies.clear();
    }

    public void start() {
        this.running = true;
        this.score = 0;
    }

    public boolean getRunning()
    { return this.running; }

    public int getWindowWidth()
    { return this.windowWidth; }

    public int getWindowHeight()
    { return this.windowHeight; }
}
