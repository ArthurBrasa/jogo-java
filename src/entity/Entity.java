package entity;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author arthur
 */
public abstract class Entity {
    
    protected Rectangle colision;
    protected Image sprite;
    protected float velocity;
    protected float jumpVelocity;
    protected boolean isJumping = false;

    public Entity(int x, int y, int tileSize, float velocity, float jumpVelocity) {
        this.velocity = velocity;
        this.jumpVelocity = jumpVelocity;
        colision = new Rectangle(x, y, tileSize, tileSize);
        
    }
    
    protected Rectangle getCollision(){
        return this.colision;
    }
    
    public void setY(float y){
        this.colision.setY(y);
    }
    
    public float getX(){
        return this.colision.getX();
    }
    
    public float getY(){
        return colision.getY();
    }
    
    
    public abstract void render(Graphics g);
    public abstract void update(GameContainer gc, float gravity, ArrayList<Rectangle> grounds);
    
    
    
    
}
