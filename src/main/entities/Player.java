package main.entities;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 16;
        solidArea.y = gp.tileSize - 17;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 16;
        solidArea.height = 16;

        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues() {

        worldX = 23 * gp.tileSize;
        worldY = 21 * gp.tileSize;
        speed = 3;
        direction = "down";

    }

    public void getPlayerImage() {
/*
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/entities/player/boy_up_1.png")); // exemple

        } catch (IOException e) {

            e.printStackTrace();

        }
*/
    }

    public void update() {

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed ) {

            if (keyH.upPressed) {

                direction = "up";

            }

            if (keyH.downPressed) {

                direction = "down";

            }

            if (keyH.leftPressed) {

                direction = "left";

            }

            if (keyH.rightPressed) {

                direction = "right";

            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // IF THE COLLISION IS FALSE, PLAYER CAN MOVE
            if (collisionOn == false) {

                switch (direction) {

                    case "up" :

                        worldY -= speed;
                        break;

                    case "down" :

                        worldY += speed;
                        break;

                    case "left" :

                        worldX -= speed;
                        break;

                    case "right" :

                        worldX += speed;
                        break;

                }

            }

            spriteCounter++;
            if (spriteCounter > 12) {

                if (spriteNum == 2) {

                    spriteNum = 1;

                } else if (spriteNum == 1) {

                    spriteNum = 2;

                }

                spriteCounter = 0;
            }

        }

        System.out.println("\nworldX : " + worldX/gp.tileSize + "\nworldY : " + worldY/gp.tileSize);
    }

    public void pickUpObject(int index) {



    }

    public void draw(Graphics2D g2) {

        /*
        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
         */

        BufferedImage image = null;
        /*switch(direction) {
            case "up" :

                if (spriteNum == 1) {
                    image = up1;
                    break;
                }

                if (spriteNum == 2) {
                    image = up2;
                    break;
                }

        }*/

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }

}
