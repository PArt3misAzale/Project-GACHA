package main;

import java.awt.*;

public class Ui {

    GamePanel gp;
    Font arial_40; // exemple

    int tileSize;

    public Ui(GamePanel gp) {

        this.gp = gp;
        tileSize = gp.tileSize;

        arial_40 = new Font("Arial", Font.PLAIN, 40); // exemple

    }

    public void draw(Graphics2D g2) {

        // Essais //
        g2.setColor(Color.WHITE);
        g2.fillRect((int)(0.25*tileSize), (int)(0.25*tileSize), (int)(0.75*tileSize), (int)(0.75*tileSize)); // menu

        g2.setColor(Color.CYAN);
        g2.fillRect((int)(1.15*tileSize), (int)(0.25*tileSize), (int)(2.5*tileSize), (int)(2.5*tileSize)); // mini-map

        g2.setColor(Color.YELLOW);
        g2.fillRect((int)(0.25*tileSize), (int)(2*tileSize), (int)(0.75*tileSize), (int)(0.75*tileSize)); // quetes
        g2.fillRect((int)(0.25*tileSize), (int)(3*tileSize), (int)(0.25*tileSize), (int)(0.25*tileSize));
        g2.fillRect((int)(0.6*tileSize), (int)(3*tileSize), (int)(3*tileSize), (int)(0.25*tileSize));
        g2.fillRect((int)(0.6*tileSize), (int)(3.30*tileSize), (int)(tileSize), (int)(0.2*tileSize));

        g2.setColor(Color.PINK);
        g2.fillRect((int)(23*tileSize), (int)(0.25*tileSize), (int)(0.75*tileSize), (int)(0.75*tileSize)); // characters
        g2.fillRect((int)(22*tileSize), (int)(0.25*tileSize), (int)(0.75*tileSize), (int)(0.75*tileSize)); // inventory
        g2.fillRect((int)(21*tileSize), (int)(0.25*tileSize), (int)(0.75*tileSize), (int)(0.75*tileSize)); // "cahier de l'aventurier" ( nom à changer )
        g2.fillRect((int)(20*tileSize), (int)(0.25*tileSize), (int)(0.75*tileSize), (int)(0.75*tileSize)); // pass
        g2.fillRect((int)(19*tileSize), (int)(0.25*tileSize), (int)(0.75*tileSize), (int)(0.75*tileSize)); // appels
        g2.fillRect((int)(18*tileSize), (int)(0.25*tileSize), (int)(0.75*tileSize), (int)(0.75*tileSize)); // evenements

        g2.setColor(Color.green);

    }

}
