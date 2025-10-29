package Games.Space_Cowboys.Code.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Settings {

    // window and tile dimensions

    public final int TILE_SIZE = 50;
    public final int NUM_ROWS = 15;
    public final int NUM_COLS = 24;
    public final int WINDOW_WIDTH = NUM_COLS * TILE_SIZE;
    public final int WINDOW_HEIGHT = NUM_ROWS * TILE_SIZE;

    // FPS

    public final int FPS = 30;
    public final int FRAME_TIME = 1000000000 / FPS;

    public Map<String, ArrayList<BufferedImage>> imgMap = new HashMap<>();

    public void loadImages(String name) {
        this.imgMap.put("tree1", this.loadSprites("Game-Dev/Games/Space_Cowboys/Graphics/" + name + ".png", 3));
    }

    private ArrayList<BufferedImage> loadSprites(String fp, int length){
        ArrayList<BufferedImage> temp = new ArrayList<>();
        try {
            BufferedImage fullImage = ImageIO.read(new File(fp));

            for(int i = 0; i < length; i++){
                temp.add(fullImage.getSubimage(i * 32, 0, 32, 32));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return temp;
    }
}
