package main;

import data.SaveLoad;
import main.combat.characters.CHARMAEL;
import main.tile.*;
import main.entities.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public int originalTileSize = 16; // 16x16 tile
    public int scale = 5;

    public int tileSize = originalTileSize * scale; // 48x48 tile

    public int maxScreenCol = 24;
    public int maxScreenRow = 15;
    public int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // WORLD SETTING //
    public final int maxWorldCol = 100;
    public final int maxWorldRow = 100;

    // FPS //
    int FPS = 60;

    // SYSTEM //
    TileManager tileM = new TileManager(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CheckCollision cChecker = new CheckCollision(this);
    KeyHandler keyH = new KeyHandler();
    public Ui ui = new Ui(this);
    SaveLoad saveLoad = new SaveLoad(this);
    Thread gameThread;

    // ENTITIES && OBJECTS //
    public Player player = new Player(this, keyH);

    // PLAYER //
    public int playerLevel = 1;
    public int worldLevel, worldExp;

    // CHARACTERS //
    // new double[0.5, 0.5036, 0.5085, 0.5151, 0.5241, 0.5364, 0.553, 0.5757, 0.6064, 0.6483, 0.7051]
    public CHARMAEL charMael = new CHARMAEL(130, 38, 102, 80,
            0.05, 0.5,
            1,
            0, 0,
            0, 0,
            0, 0,
            0,
            140, 7, 20);
    public boolean hasCharMael = true;

    public GamePanel() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight()));
        this.setBackground(Color.BLACK);

        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);

        this.setFocusable(true);

    }

    public void setupGame() {

    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

        saveLoad.saveProfileData();
        saveLoad.saveObtainedCharactersData();

    }

    @Override
    public void run() {

        double drawInteval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInteval;

        while (gameThread != null) {

            // UPDATE INFORMATIONS ( ex : character positions )
            update();

            // DRAW : draw the screen with the updated informations
            repaint();

            try {

                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0 ) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInteval;

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

    public void update() {

    }

    public void paintComponent(Graphics g) {

        // Set up //
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // essais // Personnage : 1.5 * tileSize = 1.5*5*16 = 120
        //g2.fillRect(4*tileSize, 4*tileSize, (int)(1.5*tileSize), (int)(1.5*tileSize));

        // TILES

        // OBJECTS

        // PLAYER

        // UI

        // Draw //
        ui.draw(g2);
        g2.dispose();

    }

    public void playMusic(int i) {

        music.setFile(i);
        music.play();
        music.loop();

    }

    public void stopMusic() {

        music.stop();

    }

    public void playSoundEffect(int i) {

        se.setFile(i);
        se.play();

    }

}
