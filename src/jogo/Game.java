package jogo;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
/**
 *
 * @author arthu
 */
public class Game extends BasicGame {
    
    private Rectangle player;
    private Rectangle platform;
    
    private boolean isJumping;
    private float jumpVelocity;
    private float gravity;

    @Override
    public void init(GameContainer gc) throws SlickException {
        
        // Criando objetos do jogo
        player = new Rectangle(50, 50, 50, 50);
        platform = new Rectangle(0, gc.getHeight() - 50, gc.getWidth(), 50);
        
        isJumping = false;
        jumpVelocity = 0;
        gravity = 0.005f;
        
        
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
//        Movimentação do jogador  left/right
        if (gc.getInput().isKeyDown(Input.KEY_LEFT)) {
            player.setX(player.getX() - delta * 0.1f);
        }
        if (gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
            player.setX(player.getX() + delta * 0.1f);
        }
        
        System.out.println(player.getCenterY());
        if(!isJumping){
            if(gc.getInput().isKeyPressed(Input.KEY_UP)){
                gravity = - 0.005f;
            }
//            isJumping = false;
        }
        
        // VERIFICAR Colisao com a plataforma
        if(player.intersects(platform)) {
    
      
            if(player.getMaxY() > platform.getY() && player.getMaxY() - jumpVelocity * delta <= platform.getY()){
                isJumping = false;
                player.setY(platform.getY() - player.getHeight());
 
           
         
            }
              
        }else {
            isJumping = true;
            jumpVelocity += gravity * delta;
            player.setY(player.getY() + jumpVelocity * delta);
        }
        
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.fill(player);
        g.setColor(Color.yellow);
        g.fill(platform);
    }
    
    public Game (String title){
        super(title);
    }
    
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game("JumpGame"));
        app.setDisplayMode(640, 480, false);
        
        app.start();
        
    }
    
}
