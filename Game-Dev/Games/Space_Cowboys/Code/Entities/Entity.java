package Games.Space_Cowboys.Code.Entities;

import Games.Space_Cowboys.Code.utils.Settings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Entity {

    protected int x, y;
    protected BufferedImage stand_up1, stand_up2, stand_down1, stand_down2, stand_left1, stand_left2, stand_right1, stand_right2;
    protected BufferedImage walk_up1, walk_up2, walk_down1, walk_down2, walk_left1, walk_left2, walk_right1, walk_right2, fullImage;
    protected String[] directions = {"up", "down", "left", "right"};
    protected String direction = "up";
    protected boolean moving = false;
    protected int move_speed = 5;
    protected float imgIndex = 0;
    protected float animSpeed = 0.1f;
    protected HashMap<String, ArrayList<BufferedImage[]>> imageMap;
    protected BufferedImage currentImage;
    private Settings settings = new Settings();

    protected Entity(int x, int y){
        this.x = x;
        this.y = y;
        this.imageMap = new HashMap<>();
    }

    // the sprite sheet should be in the correct order
    // looks into the graphics folder and player.png file to see the correct order
    protected void loadSprites(String fp){
        try {
            this.fullImage = ImageIO.read(new File(fp));

            this.stand_down1 = fullImage.getSubimage(0, 0, 32, 32);
            this.stand_down2 = fullImage.getSubimage(32, 0, 32, 32);
            this.stand_up1 = fullImage.getSubimage(64, 0, 32, 32);
            this.stand_up2 = fullImage.getSubimage(96, 0, 32, 32);
            this.stand_right1 = fullImage.getSubimage(128, 0, 32, 32);
            this.stand_right2 = fullImage.getSubimage(160, 0, 32, 32);
            this.stand_left1 = fullImage.getSubimage(192, 0, 32, 32);
            this.stand_left2 = fullImage.getSubimage(224, 0, 32, 32);

            this.walk_right1 = fullImage.getSubimage(256, 0, 32, 32);
            this.walk_right2 = fullImage.getSubimage(288, 0, 32, 32);
            this.walk_left1 = fullImage.getSubimage(320, 0, 32, 32);
            this.walk_left2 = fullImage.getSubimage(352, 0, 32, 32);
            this.walk_down1 = fullImage.getSubimage(384, 0, 32, 32);
            this.walk_down2 = fullImage.getSubimage(416, 0, 32, 32);
            this.walk_up1 = fullImage.getSubimage(448, 0, 32, 32);
            this.walk_up2 = fullImage.getSubimage(480, 0, 32, 32);

        }catch (IOException e){
            System.out.println("Failed to load entity resources");
        }
    }

    // only call this after calling the loadSprites method
    protected void groupImages(){

        BufferedImage[][] groups = {
                {this.stand_up1, this.stand_up2},
                {this.walk_up1, this.walk_up2},
                {this.stand_down1, this.stand_down2},
                {this.walk_down1, this.walk_down2},
                {this.stand_left1, this.stand_left2},
                {this.walk_left1, this.walk_left2},
                {this.stand_right1, this.stand_right2},
                {this.walk_right1, this.walk_right2}
        };

        for(int i = 0; i < 4; i++) {
            ArrayList<BufferedImage[]> container = new ArrayList<>();
            container.add(groups[2 * i]);
            container.add(groups[2 * i + 1]);
            this.imageMap.put(this.directions[i], container);
        }
    }

    protected void update(){
        // moving sprite
        if(this.moving){
            switch(this.direction){
                case "up":
                    this.y -= this.move_speed;
                    break;
                case "down":
                    this.y += this.move_speed;
                    break;
                case "left":
                    this.x -= this.move_speed;
                    break;
                case "right":
                    this.x += this.move_speed;
                    break;
            }
        }
        // updating img index
        this.imgIndex += this.animSpeed;
        this.imgIndex %= 2;

        // changing current img
        int temp = this.moving ? 1 : 0;
        this.currentImage = this.imageMap.get(this.direction).get(temp)[(int) this.imgIndex];

    }

    protected void draw(Graphics2D g){
        g.drawImage(this.currentImage, this.x, this.y, this.settings.TILE_SIZE, this.settings.TILE_SIZE, null);
    }
}
