package jogo;

import entity.Player;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import GameConfigs.GlobalVariables;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.geom.Shape;
import tile.TileManager;
/**
 *
 * @author arthu
 */
public class Game extends BasicGame {   
    
    // OBJECTS GAME
//    Player player;
    Rectangle player;
    ArrayList<Rectangle> grounds;
    TileManager tileManager;
    
//    private Rectangle player;
    private Rectangle platform;
    private Rectangle platform2;
    Image img;
    
    @Override
    public void init(GameContainer gc) throws SlickException {
//        try {;
//            tileManager = new TileManager();
//        } catch (IOException ex) {
//            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        img = new Image("assents/imgTile/ground/land.png");
//        player = new Player(50, 50, GlobalVariables.TILE_SIZE, GlobalVariables.VELOCITY, GlobalVariables.JUMP_VELOCITY_FALLING_DOW);
         platform = new Rectangle(gc.getWidth()/2, gc.getHeight()/2, 50, 50);
         player = new Rectangle(50, 50, 50, 50);
        
        
        
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
//        player.update(gc, GlobalVariables.GRAVITY, tileManager.getArrayRectangle()); 
          if(gc.getInput().isKeyDown(Input.KEY_W)){
               player.setY(player.getY() - GlobalVariables.VELOCITY);
          }
          if(gc.getInput().isKeyDown(Input.KEY_S)){
               player.setY(player.getY() + GlobalVariables.VELOCITY);
          }
          if(gc.getInput().isKeyDown(Input.KEY_A)){
               player.setX(player.getX() - GlobalVariables.VELOCITY);
          }
          if(gc.getInput().isKeyDown(Input.KEY_D)){
               player.setX(player.getX() + GlobalVariables.VELOCITY);
          }
          
//          Interação Simplista
          if(player.intersects(platform)){
//              System.out.println(player.getMinY());
//              System.out.println(player.getMaxY());
//              System.out.println(player.getMaxY()-player.getMinY());
                    System.out.println(player.getMaxX());
                  System.out.println( platform.getMinX() );
              if(player.getMaxX() >= platform.getMinX() && player.getMinX() < platform.getMinX()){
                  System.out.println("Colisão na Esquerda");
              }
              if(player.getMinX() <= platform.getMaxX() && player.getMaxX() > platform.getMaxX()){
                  System.out.println("Colisão na Direita");
              }
                  
//              System.exit(delta);
              System.out.println("Interação");
          }else {
              System.out.println("No Interação");
          }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        
//        tileManager.render();
//        player.render(g);
    g.setColor(Color.green);
    g.fill(player);
    g.setColor(Color.yellow);
    g.draw(platform);

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
