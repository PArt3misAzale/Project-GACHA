package main;

import data.SaveLoad;
import main.combat.characters.CHAR_MAEL;
import main.combat.weapons.WEAP_GRANITCOLUMN;
import main.tile.*;
import main.entities.*;

import java.awt.event.KeyEvent;
import java.time.*;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

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
    MouseHandler mouseH = new MouseHandler(this);
    public Ui ui = new Ui(this);
    SaveLoad saveLoad = new SaveLoad(this);
    Thread gameThread;

    // TIME //
    public LocalDate date = LocalDate.now();
    public int year = date.getYear();
    public int month = date.getMonthValue();
    public int day = date.getDayOfMonth();
    public int dayOfYear = date.getDayOfYear();

    // GACHA SYSTEM //
    // Tempo
    public int maxFiveTempoChars = 0;
    public int maxFiveTempoWeapons = 0;
    public int maxFourTempoChars = 0;
    // Standard
    public int maxFiveStandardChars = 1;
    public int maxFiveStandardWeapons = 0;
    public int maxFourStandardChars = 0;
    public int getMaxFourStandardWeapons = 0;

    // ENTITIES && OBJECTS //
    public Player player = new Player(this, keyH);

    // PROFILES //
    public int nbProfiles = 16;
    public int profilePage;
    public String[] profilesNames = new String[nbProfiles];
    public int chosenProfile;
    // update
    boolean buttonForNextProfilePagePressed = false;
    boolean buttonForPreviousProfilePagePressed = false;

    // PLAYER //
    public int playerLevel = 1;
    public int worldLevel, worldExp, worldEvolutionLevel;
    public int worldLevelMaxExp;
    public double levelExpPercentage;
    public int[] birthdayDate = new int[2];

    // COMBAT //
    public int maxEffects = 4;

    // CHARACTERS //
    public CHAR_MAEL charMael = new CHAR_MAEL(130, 38, 102, 80,
            0.05, 0.5,
            1,
            0, 0,
            0, 0,
            0, 0,
            140, 7, 20,
            this);
    public boolean hasCharMael = true;

    // WEAPONS //
    public WEAP_GRANITCOLUMN weapGranitColumn = new WEAP_GRANITCOLUMN("Granit column", 860, "DEF%", this);
    public boolean hasWeaponGranitColumn = true;

    public GamePanel() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight()));
        this.setBackground(Color.BLACK);

        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);

        this.setFocusable(true);

    }

    public void setupGame() {

    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
/*
        saveLoad.saveProfileData(); // save profile data
        saveLoad.saveObtainedCharactersData(); // save obtained characters data
 */
        ui.inGame = false; ui.inCalls = false; ui.inMenu = false; ui.inEntranceMenu = true;

        this.levelExpPercentage = .7;
        this.birthdayDate[0] = 0; this.birthdayDate[1] = 0; // à enlever

        for (int i = 0; i < 12; i ++) {
            this.profilesNames[i] = "-EMPTY-";
        }

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

        mouseH.update();

        if (mouseH.isButtonDown(1)) { // left button
            System.out.println("LEFT DOWN");

            if (ui.inEntranceMenu) {
                if (mouseH.getMouseX() >= 1680 && mouseH.getMouseX() < 1840
                        && mouseH.getMouseY() >= 880 && mouseH.getMouseY() < 1040
                        && !this.buttonForNextProfilePagePressed
                        && this.profilePage < 3
                ) {
                    this.buttonForNextProfilePagePressed = true;
                } else if (mouseH.getMouseX() >= 60 && mouseH.getMouseX() < 220
                        && mouseH.getMouseY() >= 880 && mouseH.getMouseY() < 1040
                        && !this.buttonForNextProfilePagePressed
                        && this.profilePage > 0) {
                    this.buttonForPreviousProfilePagePressed = true;
                }

                if (mouseH.getMouseX() >= 80 && mouseH.getMouseX() < 440
                        && mouseH.getMouseY() >= 80 && mouseH.getMouseY() < 800
                ) {
                    this.chosenProfile = (4 *  this.profilePage);
                } else if (mouseH.getMouseX() >= 540 && mouseH.getMouseX() < 900
                        && mouseH.getMouseY() >= 80 && mouseH.getMouseY() < 800
                ) {
                    this.chosenProfile = 1 + (4 * this.profilePage);
                } else if (mouseH.getMouseX() >= 1000 && mouseH.getMouseX() < 1360
                        && mouseH.getMouseY() >= 80 && mouseH.getMouseY() < 800
                ) {
                    this.chosenProfile = 2 + (4 * this.profilePage);
                } else if (mouseH.getMouseX() >= 1460 && mouseH.getMouseX() < 1820
                        && mouseH.getMouseY() >= 80 && mouseH.getMouseY() < 800
                ) {
                    this.chosenProfile = 3 + (4 * this.profilePage);
                }
            }
        } else if (mouseH.isButtonDown(2)) { // middle button
            System.out.println("MIDDLE DOWN");
        } else if (mouseH.isButtonDown(3)) { // right button
            System.out.println("RIGHT DOWN");
        }

        if (mouseH.isButtonUp(1)) {
            System.out.println("LEFT UP");

            if (ui.inEntranceMenu) {
                if (this.buttonForNextProfilePagePressed
                        && this.profilePage < 3
                ) {
                    this.profilePage++;
                    this.buttonForNextProfilePagePressed = false;
                } else if (this.buttonForPreviousProfilePagePressed
                        && this.profilePage > 0
                ) {
                    this.profilePage--;
                    this.buttonForPreviousProfilePagePressed = false;
                }
            }
        } else if (mouseH.isButtonUp(2)) { // middle button
            System.out.println("MIDDLE UP");
        } else if (mouseH.isButtonUp(3)) { // right button
            System.out.println("RIGHT UP");
        }

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

    // PLAYER //

    /**
     * Formula for max world exp : ( ( e ** {@code this.worldLevel} ) / ( 2.47 ** {@code this.worldLevel} ) * 100 )
     */
    public void updateWorldLevelMaxExp() {
        this.worldLevelMaxExp = (int) ( ( ( Math.exp(this.worldLevel) )/( Math.pow(2.47, this.worldLevel) ) ) * 100);
    }

    public void updateLevelExpPercentage() {
        this.levelExpPercentage = (double) (this.worldExp * this.worldLevelMaxExp) / 100;
    }

    // TIME //
    public void updateDate() {
        this.date = LocalDate.now(); this.year = date.getYear(); this.month = date.getMonthValue(); this.day = date.getDayOfMonth(); this.dayOfYear = date.getDayOfYear();
    }

}
