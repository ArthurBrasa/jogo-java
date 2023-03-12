package tile;

import GameConfigs.Collision;
import GameConfigs.GlobalVariables;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


/**
 *
 * @author arthur
 */
public class Tile implements Collision{
    protected Rectangle area;
    protected boolean collision = false;
    private Image img = null;
    public boolean is = false;
    

    public Tile(boolean collision) {
        this.collision = collision;
    }
    
    public boolean isCollision(){
        return this.collision;
    }
    
    public void setIs(){
        this.is = true;
    }
    public boolean getIs(){
        return this.is;
    }
    
    public void initTileCollision(int x, int y){
        this.area = new Rectangle(x, y, GlobalVariables.TILE_SIZE, GlobalVariables.TILE_SIZE);
    }

    @Override
    public boolean collisionDetection(Rectangle object) {
        return area.intersects(object);
    }

    public void setImg(String img) throws SlickException {
        this.img = new Image(img);

    }

    public Image getImage() {
        return this.img;
    }
    
    public Rectangle getAre(){
        return this.area;
    }
    
}
