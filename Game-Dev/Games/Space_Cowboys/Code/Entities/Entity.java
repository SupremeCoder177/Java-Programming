package Games.Space_Cowboys.Code.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Entity {

    protected int x, y, width, height;
    protected BufferedImage stand_up1, stand_up2, stand_down1, stand_down2, stand_left1, stand_left2, stand_right1, stand_right2;
    protected BufferedImage walk_up1, walk_up2, walk_down1, walk_down2, walk_left1, walk_left2, walk_right1, walk_right2, fullImage;

    protected Entity(int x, int y){
        this.x = x;
        this.y = y;
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
}
