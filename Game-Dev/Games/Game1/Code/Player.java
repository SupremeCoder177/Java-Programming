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
    private final int jumpHeight = 100;

    private boolean inAir = false;
    private float imgIndex = 0;
    private final float animSpeed = 0.2f;
    private int fallSpeed = 10;
    private int gravity = 2;
    private int acc = fallSpeed;
    private int startY;

    HashMap<String, BufferedImage> imageMap;

    Player(int x, int y){
        this.x = x;
        this.y = y;
        this.startY = y;
        this.imageMap = new HashMap<>();
        this.loadImages();
    }

    private void loadImages(){
        try {
            this.imageMap.put("walk1", ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/playerGraphics/player_walk_1.png")));
            this.imageMap.put("walk2", ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/playerGraphics/player_walk_2.png")));
            this.imageMap.put("jump", ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/playerGraphics/jump.png")));

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

        if(this.inAir){
            this.y += this.acc;
            this.acc += this.gravity;
        }

        if(this.y >= this.startY){
            this.y = this.startY;
            this.inAir = false;
            this.acc = this.fallSpeed;
        }
    }

    public void draw(Graphics2D g){
        if(this.inAir){
            g.drawImage(this.imageMap.get("jump"), this.x, this.y, this.width, this.height, null);
        }else{
            if((int) this.imgIndex == 0){
                g.drawImage(this.imageMap.get("walk1"), this.x, this.y, this.width, this.height, null);
            }else{
                g.drawImage(this.imageMap.get("walk2"), this.x, this.y, this.width, this.height, null);
            }
        }
    }

    public void jump(){
        if(this.inAir) return;
        this.inAir = true;
        this.y -= this.jumpHeight;
    }

}
