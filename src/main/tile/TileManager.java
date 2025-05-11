package main.tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;

    public int mapTileNum[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[10]; // 10 types of tiles
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();

        loadMap("/maps/map001.txt");

    }

    public void getTileImage() {
/*
        try {

            tile[1] = new Tile(); // exemple
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png")); // exemple
            tile[1].collision = true; // exemple

        } catch (IOException e) {

            e.printStackTrace();

        }
*/
    }

    public void loadMap(String filePath) {

        try {

            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldCol) {

                String line = br.readLine();

                while (col < gp.maxWorldCol) {

                    String numbers[] = line.split(" ");

                    int num;

                    if (numbers[col] == ""){

                        num = 9;

                    } else {

                        num = Integer.parseInt(numbers[col]);

                    }

                    mapTileNum[col][row] = num;
                    col ++;

                }

                if (col == gp.maxWorldCol) {

                    col = 0;
                    row ++;

                }

            }

            br.close();

        } catch (Exception e) {



        }

    }

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;

        while(col < gp.maxWorldCol && row < gp.maxWorldRow) {

            int tileNum = mapTileNum[col][row];

            int worldX = col * gp.tileSize;
            int worldY = row * gp.tileSize;

            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (
                    worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY
            ) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }

            col++;

            if(col == gp.maxWorldCol) {

                col = 0;

                row ++;

            }

        }


    }

}
