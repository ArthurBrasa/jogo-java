package GameConfigs;

/**
 *
 * @author arthu
 */
public class GlobalVariables {
    
    // Screen Settings
    static final int ORIGINAL_TILE_SIZE = 32;
    static final int SCALE = 2;
    public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
    
    // columns & rows
    static final int MAX_SCREEN_COL = 10;
    static final int MAX_SCRENN_ROW = 12;
    
    // width & height
    public static int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    public static int SCREEN_HEIGHT = TILE_SIZE *MAX_SCRENN_ROW;
    
    // 
    public static float JUMP_VELOCITY = 0.01f;
    public static float VELOCITY = 0.2f;
    
    // gravity Game
    public static float GRAVITY = 0.011f;
}
