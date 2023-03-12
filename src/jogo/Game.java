package jogo;

import entity.Player;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import GameConfigs.GlobalVariables;
/**
 *
 * @author arthu
 */
public class Game extends BasicGame {   
    
    // OBJECTS GAME
    Player player;
    ArrayList<Rectangle> grounds;
    
//    private Rectangle player;
    private Rectangle platform;
    private Rectangle platform2;
    
    @Override
    public void init(GameContainer gc) throws SlickException {
        grounds = new ArrayList<>();
        
        platform = new Rectangle(0, gc.getHeight() - 50, gc.getWidth(), 50);
        platform2 = new Rectangle(0, 100, 200, 50);
        
        grounds.add(platform2);
        grounds.add(platform);
        
        

        
        player = new Player(50, 50, GlobalVariables.TILE_SIZE, GlobalVariables.VELOCITY, GlobalVariables.JUMP_VELOCITY);
  
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        player.update(gc, GlobalVariables.GRAVITY, grounds);      
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        player.render(g);
        g.setColor(Color.yellow);
        g.fill(platform);
        g.fill(platform2);
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
        
        
        
        app.setShowFPS(false);
    
        app.start();
        
    }
    
}
