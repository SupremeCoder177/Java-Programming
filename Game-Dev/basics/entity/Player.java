package basics.entity;

import basics.GamePanel;
import basics.keyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    keyHandler handler;

    public Player(GamePanel gp, keyHandler handler){
        this.gp = gp;
        this.handler = handler;
        setDefaultValues();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 10;
        direction = "down";
    }

    public void getPlayerImages(){
        try{

            up1 = ImageIO.read(getClass().getResourceAsStream(""));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(handler.upPressed) y -= speed;
        else if(handler.downPressed) y += speed;
        else if(handler.leftPressed) x -= speed;
        else if(handler.rightPressed) x += speed;
    }

    public void draw(Graphics2D g2){

        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
