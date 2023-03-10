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
    private Rectangle platform2;
    
    private boolean isJumping;
    private boolean jump; 
    private float jumpVelocity;
    private float gravity;
    private float rangeJumping;

    @Override
    public void init(GameContainer gc) throws SlickException {
        
        // Criando objetos do jogo
        player = new Rectangle(50, 50, 50, 50);
        platform = new Rectangle(0, gc.getHeight() - 50, gc.getWidth(), 50);
        platform2 = new Rectangle(0, 100, 200, 50);
        
        isJumping = true;
        jumpVelocity = 0.1f;
        gravity = 0.001f;
        
        
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
        
        // Verifica Colisão com a plataforma
        boolean isOnGround = player.intersects(platform);
        boolean isOnGround2 = player.intersects(platform2);
        
        if(isOnGround || isOnGround2) {
            isJumping = false;
            if(gc.getInput().isKeyPressed(Input.KEY_UP)){
                jumpVelocity = -0.5f;
                isJumping = true;
            }
              
        }else {
            isJumping = true;
            
        }
        
        System.out.println(jumpVelocity);
        System.out.println("y player : " + player.getY());
        // GRAVIDADE GAME
        if(isJumping){
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
        g.fill(platform2);
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
