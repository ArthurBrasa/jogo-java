package jogo;

import entity.Player;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import GameConfigs.GlobalVariables;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tile.TileManager;
/**
 *
 * @author arthu
 */
public class Game extends BasicGame {   
    
    // OBJECTS GAME
    Player player;
    ArrayList<Rectangle> grounds;
    TileManager tileManager;
    
//    private Rectangle player;
    private Rectangle platform;
    private Rectangle platform2;
    Image img;
    
    @Override
    public void init(GameContainer gc) throws SlickException {
        try {
            tileManager = new TileManager();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        img = new Image("assents/imgTile/ground/land.png");

        player = new Player(50, 50, GlobalVariables.TILE_SIZE, GlobalVariables.VELOCITY, GlobalVariables.JUMP_VELOCITY_FALLING_DOW);
  
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        player.update(gc, GlobalVariables.GRAVITY, tileManager.getArrayRectangle());      
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        tileManager.render();
        player.render(g);
    }
    
    public Game (String title){
        super(title);
    }
    
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game("JumpGame"));
        app.setDisplayMode( GlobalVariables.SCREEN_WIDTH, GlobalVariables.SCREEN_HEIGHT, false);
        
        // FULL SCREEN
//         app.setDisplayMode( app.getScreenWidth(), app.getScreenHeight(), false);
//        app.setVSync(true);
        
        
   
    
        app.start();
        
    }
    
}
