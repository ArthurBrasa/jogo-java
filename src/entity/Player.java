
package entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import GameConfigs.Collision;
import GameConfigs.GlobalVariables;
import java.util.ArrayList;
import org.newdawn.slick.geom.Rectangle;


/**
 *
 * @author arthur
 */
public class Player extends Entity implements Collision{
    

    public Player(int x, int y, int tileSize, float velocity, float jumpVelocity) {
        super(x, y, tileSize, velocity, jumpVelocity);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fill(colision);
    }

    @Override
    public void update(GameContainer gc, float gravity, ArrayList<Rectangle> grounds) {
        if(gc.getInput().isKeyDown(Input.KEY_LEFT) || gc.getInput().isKeyDown(Input.KEY_A)){
            colision.setX(colision.getX() - velocity);          
            
        }
        if(gc.getInput().isKeyDown(Input.KEY_RIGHT) || gc.getInput().isKeyDown(Input.KEY_D)){
            colision.setX(colision.getX() + velocity);

        }

        
      
        for(Rectangle ground : grounds){
 
            this.jump(gc, ground);
            
            if(!isJumping){
                break;
            }
            
        }

        // GRAVIDADE GAME
        if(isJumping){
            jumpVelocity += gravity;
            colision.setY(colision.getY() + jumpVelocity);
            
        }
    
    
    }
    private boolean isOnGround(Rectangle object){
        return this.collisionDetection(object);
    }
    
    private void jump(GameContainer gc, Rectangle ground){
        
        
        if(isOnGround(ground) && jumpVelocity>0){ // cross platform
            isJumping = false;
            if(gc.getInput().isKeyPressed(Input.KEY_UP) || gc.getInput().isKeyPressed(Input.KEY_W)){
                jumpVelocity = GlobalVariables.JUMP_VELOCITY_UP;
                isJumping = true;
        }
        }else{
            isJumping = true;
        }  
    }

    @Override
    public boolean collisionDetection(Rectangle colision) {
        return getCollision().intersects(colision);
    }
    
}
