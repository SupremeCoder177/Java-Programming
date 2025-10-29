package Games.Space_Cowboys.Code.StaticObjects;

import Games.Space_Cowboys.Code.utils.Settings;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {

    private String name;
    private float imgIndex = 0;
    private int x, y;
    private float animSpeed = 0.1f;
    private ArrayList<BufferedImage> images;
    private int numImages = 0;
    private Settings settings = new Settings();

    public GameObject(String name, int x, int y){
         this.name = name;
         this.images = new ArrayList<>();
         this.x = x;
         this.y = y;
    }

    public void loadImages(){
        this.settings.loadImages(this.name);
        this.images = this.settings.imgMap.get(this.name);
        this.numImages = this.images.size();
        System.out.println(this.images);
    }

    public void update(){
        this.imgIndex += this.animSpeed;
        this.imgIndex %= this.numImages;
    }

    public void draw(Graphics2D g){
        g.drawImage(this.images.get((int) this.imgIndex),this.x, this.y, this.settings.TILE_SIZE, this.settings.TILE_SIZE, null);
    }

    public void setAnimSpeed(float animSpeed) {
        this.animSpeed = animSpeed;
    }
}
