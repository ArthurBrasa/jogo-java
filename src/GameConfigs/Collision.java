
package GameConfigs;

import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author arthu
 */
public interface Collision {
    
    /**
     *
     * @param object
     * @return
     */
    public boolean collisionDetection(Rectangle object);
    
}
