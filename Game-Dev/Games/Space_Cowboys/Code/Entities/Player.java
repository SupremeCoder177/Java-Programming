package Games.Space_Cowboys.Code.Entities;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    // the player has 2 extra images for shooting while looking up
    private BufferedImage shoot_up1, shoot_up2;

    public Player(int x, int y){
        super(x, y);
        this.loadSprites("Game-Dev/Games/Space_Cowboys/Graphics/player.png");
        this.groupImages();
        this.shoot_up1 = this.fullImage.getSubimage(512, 0, 32, 32);
        this.shoot_up2 = this.fullImage.getSubimage(544, 0, 32, 32);
    }

    public void update(int inputCode){

        if(inputCode == 0){
            this.moving = false;
        }
        else{
            if(inputCode == KeyEvent.VK_UP || inputCode == KeyEvent.VK_W) {
                this.direction = "up";
                this.moving = true;
            }
            else if(inputCode == KeyEvent.VK_DOWN || inputCode == KeyEvent.VK_S) {
                this.direction = "down";
                this.moving = true;
            }
            else if(inputCode == KeyEvent.VK_LEFT || inputCode == KeyEvent.VK_A) {
                this.direction = "left";
                this.moving = true;
            }
            else if(inputCode == KeyEvent.VK_RIGHT || inputCode == KeyEvent.VK_D) {
                this.direction = "right";
                this.moving = true;
            }
        }

        super.update();
    }

    public void paint(Graphics2D g){
        super.draw(g);
    }

}
