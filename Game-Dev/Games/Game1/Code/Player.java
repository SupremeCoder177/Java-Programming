package Games.Game1.Code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Player {

    private int y;
    private final int x;

    private int width, height;
    private final int jumpHeight = 15;

    private boolean inAir = false;
    private float imgIndex = 0;
    private final float animSpeed = 0.2f;
    private int fallSpeed = 5;
    private int gravity = 1;
    private int acc = fallSpeed;
    private int startY;

    private HashMap<String, BufferedImage> imageMap;

    private GamePanel panel;

    Player(int x, int y, GamePanel panel){
        this.x = x;
        this.y = y;
        this.startY = y;
        this.imageMap = new HashMap<>();
        this.panel = panel;
        this.loadImages();
    }

    private void loadImages(){
        try {
            this.imageMap.put("walk1", ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/playerGraphics/player_walk_1.png")));
            this.imageMap.put("walk2", ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/playerGraphics/player_walk_2.png")));
            this.imageMap.put("jump", ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/playerGraphics/jump.png")));
            this.imageMap.put("stand", ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/playerGraphics/player_stand.png")));

            this.width = this.imageMap.get("jump").getWidth();
            this.height = this.imageMap.get("jump").getHeight();

        }catch (IOException e){
            System.out.println("Failed to load player graphics");
            this.width = 0;
            this.height = 0;
        }
    }

    public void update(){
        this.imgIndex += this.animSpeed;
        this.imgIndex %= 2;

        this.applyGravity();

        if(this.y >= this.startY){
            this.y = this.startY;
            this.inAir = false;
            this.acc = this.fallSpeed;
        }
    }

    private void applyGravity(){
        this.y += this.acc;
        this.acc += this.gravity;
    }

    public void draw(Graphics2D g){
        if(this.panel.getRunning()) {
            if (this.inAir) {
                g.drawImage(this.imageMap.get("jump"), this.x, this.y, this.width, this.height, null);
            } else {
                if ((int) this.imgIndex == 0) {
                    g.drawImage(this.imageMap.get("walk1"), this.x, this.y, this.width, this.height, null);
                } else {
                    g.drawImage(this.imageMap.get("walk2"), this.x, this.y, this.width, this.height, null);
                }
            }
        }else{
            int x = this.panel.getWindowWidth() / 2 - (this.imageMap.get("stand").getWidth() / 2);
            int y = this.panel.getWindowHeight() / 2 - (this.imageMap.get("stand").getHeight() / 2);
            g.drawImage(this.imageMap.get("stand"), x, y, this.imageMap.get("stand").getWidth(), this.imageMap.get("stand").getHeight(), null);
        }
    }

    public void jump(){
        if(this.inAir) return;

        Music music = new Music();
        music.playEffect("Game-Dev/Games/Game1/Audio/jump.wav");

        this.inAir = true;
        this.acc = -this.jumpHeight;
    }

    public boolean checkCollide(Enemy enemy){

        int width = this.imageMap.get("walk1").getWidth();
        int height = this.imageMap.get("walk2").getHeight();

        int[][] points = {{this.x, this.y}, {this.x + width, this.y}, {this.x, this.y + height}, {this.x + width, this.y + height}};

        for(int[] point : points) {
            if (enemy.getX() <= point[0] && point[0] <= enemy.getX() + enemy.getWidth()) {
                if (enemy.getY() <= point[1] && point[1] <= enemy.getY() + enemy.getHeight()) {
                    return true;
                }
            }
        }

        return false;
    }

}
