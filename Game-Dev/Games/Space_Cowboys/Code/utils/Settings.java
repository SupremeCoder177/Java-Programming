package Games.Space_Cowboys.Code.utils;

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
}
