
package entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import GameConfigs.Colision;
import java.util.ArrayList;
import org.newdawn.slick.geom.Rectangle;


/**
 *
 * @author arthur
 */
public class Player extends Entity implements Colision{
    

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
        if(gc.getInput().isKeyDown(Input.KEY_LEFT) || gc.getInput().isKeyDown(Input.KEY_A) ){
            colision.setX(colision.getX() - velocity);
        }
        if(gc.getInput().isKeyDown(Input.KEY_RIGHT) || gc.getInput().isKeyDown(Input.KEY_D)){
            colision.setX(colision.getX() + velocity);
        }
        
        for(Rectangle ground : grounds){
            this.jump(gc, ground, gravity);
            if(!isJumping){
                break;
            }
        }
        System.out.println(jumpVelocity);
        // GRAVIDADE GAME
        if(isJumping){
            jumpVelocity += gravity;
            colision.setY(colision.getY() + jumpVelocity);
            
        }
    }
    
    private void jump(GameContainer gc, Rectangle ground, float gravity){
        boolean isOnGround = this.collisionDetection(ground);
        if(isOnGround && jumpVelocity>0){ // cross platform
            isJumping = false;
            jumpVelocity = 0;
            // Player JUMP
            if(gc.getInput().isKeyPressed(Input.KEY_UP) || gc.getInput().isKeyPressed(Input.KEY_W)){
                jumpVelocity = -1.5f;
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
