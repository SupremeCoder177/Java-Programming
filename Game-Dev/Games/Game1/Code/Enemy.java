package Games.Game1.Code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy {

    private BufferedImage[] images = new BufferedImage[2];
    private int x, y;
    private int moveSpeed = 8;
    public boolean reachedEnd = false;
    private int endX;
    private float imgIndex = 0;
    private final float imgAcc = 0.2f;

    public Enemy(String type, int x, int y, int endX){
        this.y = y;
        this.x = x;
        this.endX = endX;
        try {
            switch (type) {
                case "fly":
                    images[0] = ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/enemyGraphics/Fly1.png"));
                    images[1] = ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/enemyGraphics/Fly2.png"));
                    break;
                case "snail":
                    images[0] = ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/enemyGraphics/snail1.png"));
                    images[1] = ImageIO.read(new File("Game-Dev/Games/Game1/Graphics/enemyGraphics/snail2.png"));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(this.x >= this.endX){
            this.x -= this.moveSpeed;
            this.imgIndex += this.imgAcc;
            this.imgIndex %= 2;
        }else{
            this.reachedEnd = true;
        }
    }

    public void draw(Graphics2D g){
        int index = (int) this.imgIndex;
        g.drawImage(this.images[index], this.x, this.y, this.images[index].getWidth(), this.images[index].getHeight(), null );
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }

    public int getX()
    { return this.x; }

    public int getY()
    { return this.y; }

    public int getWidth()
    { return this.images[0].getWidth(); }

    public int getHeight()
    { return this.images[0].getHeight(); }
}
