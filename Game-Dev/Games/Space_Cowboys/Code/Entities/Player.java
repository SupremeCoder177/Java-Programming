package Games.Space_Cowboys.Code.Entities;

import java.awt.image.BufferedImage;

public class Player extends Entity{

    // the player has 2 extra images for shooting while looking up
    private BufferedImage shoot_up1, shoot_up2;

    public Player(int x, int y){
        super(x, y);
        this.loadSprites("Game-Dev/Games/Space_Cowboys/Graphics/player.png");
        this.shoot_up1 = this.fullImage.getSubimage(512, 0, 32, 32);
        this.shoot_up2 = this.fullImage.getSubimage(544, 0, 32, 32);
    }

}
