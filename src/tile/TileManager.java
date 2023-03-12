package tile;

import GameConfigs.GlobalVariables;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author arthur
 */
public class TileManager {
    ArrayList<Rectangle> arrayTile;
    Tile[] tile;
    int mapTileNum[][];
    int mapTileColision[][];

    public TileManager() throws IOException, SlickException {
        this.arrayTile = new ArrayList<>();
        this.tile = new Tile[GlobalVariables.TILES];
        this.mapTileNum = new int[GlobalVariables.MAX_SCREEN_COL][GlobalVariables.MAX_SCRENN_ROW];
        this.mapTileColision = new int[GlobalVariables.MAX_SCREEN_COL][GlobalVariables.MAX_SCRENN_ROW];
        this.getTileImage();
        this.loadMap();
    }
    
    private void getTileImage() throws SlickException{
        
        tile[0] = new Tile(true);
        //BufferedImage bufferImagem = ImageIO.read(getClass().getResourceAsStream("/assents/imgTile/ground/land.png"));
        tile[0].setImg("assents/imgTile/ground/land.png");
        
        tile[1] = new Tile(false);

        //BufferedImage bufferImagem = ImageIO.read(new File("/assents/imgTile/sky/sky_1.png"));
        tile[1].setImg("assents/imgTile/sky/sky_1.png");   
    }
    
    private void loadMap() throws IOException{
        InputStream is = getClass().getResourceAsStream("/assents/maps/mapTeste.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        int col = 0;
        int row = 0;
        
        while(col < GlobalVariables.MAX_SCREEN_COL && row < GlobalVariables.MAX_SCRENN_ROW){
            
            String line = br.readLine();
            
            while(col < GlobalVariables.MAX_SCREEN_COL){
                String numbers[] = line.split(" ");
                
                int num = Integer.parseInt(numbers[col]);
                
                mapTileNum[col][row] = num;
                col++;
            }
            if(col == GlobalVariables.MAX_SCREEN_COL){
                col = 0;
                row++;
            }
        }
        br.close();
        
    }

    public int[][] getMapTileColision() {
        return mapTileColision;
    }
    
    public void render(){
        
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        
        while(col < GlobalVariables.MAX_SCREEN_COL && row < GlobalVariables.MAX_SCRENN_ROW){
            
            int tileNum = mapTileNum[col][row];
            Image img = tile[tileNum].getImage();

            img.draw(x, y, GlobalVariables.SCALE);
            if(tile[tileNum].isCollision()){
                Rectangle tile = new Rectangle(x, y, GlobalVariables.TILE_SIZE, GlobalVariables.TILE_SIZE);
               if(arrayTile.size() < 24){
                    arrayTile.add(tile);
               } 
            }
            
            
            x += GlobalVariables.TILE_SIZE;
            col++;

            if(col == GlobalVariables.MAX_SCREEN_COL){
                col = 0;
                x = 0;
                row++;
                y += GlobalVariables.TILE_SIZE;
            }
        }
        
    }

    public ArrayList<Rectangle> getArrayRectangle() {
        return this.arrayTile;
    }
}
