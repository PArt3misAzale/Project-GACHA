package main;

import java.awt.*;

public class Ui {

    GamePanel gp;

    int tileSize;

    // FONTS //
    Font arial_30, arial_18;

    public boolean inEntranceMenu, inGame, inCalls, inMenu;

    public Ui(GamePanel gp) {

        this.gp = gp;
        tileSize = gp.tileSize;

        // FONTS //
        arial_30 = new Font("Arial", Font.PLAIN, 30);
        arial_18 = new Font("Arial", Font.PLAIN, 18);

    }

    public void draw(Graphics2D g2) {

        // Essais //
        if (this.inGame) {
            g2.setColor(Color.WHITE);
            g2.fillRect((int) (0.25 * tileSize), (int) (0.25 * tileSize), (int) (0.75 * tileSize), (int) (0.75 * tileSize)); // menu

            g2.setColor(Color.CYAN);
            g2.fillRect((int) (1.15 * tileSize), (int) (0.25 * tileSize), (int) (2.5 * tileSize), (int) (2.5 * tileSize)); // mini-map

            g2.setColor(Color.YELLOW);
            g2.fillRect((int) (0.25 * tileSize), (int) (2 * tileSize), (int) (0.75 * tileSize), (int) (0.75 * tileSize)); // quetes
            g2.fillRect((int) (0.25 * tileSize), (int) (3 * tileSize), (int) (0.25 * tileSize), (int) (0.25 * tileSize));
            g2.fillRect((int) (0.6 * tileSize), (int) (3 * tileSize), (int) (3 * tileSize), (int) (0.25 * tileSize));
            g2.fillRect((int) (0.6 * tileSize), (int) (3.30 * tileSize), (int) (tileSize), (int) (0.2 * tileSize));

            g2.setColor(Color.PINK);
            g2.fillRect((int) (23 * tileSize), (int) (0.25 * tileSize), (int) (0.75 * tileSize), (int) (0.75 * tileSize)); // characters
            g2.fillRect((int) (22 * tileSize), (int) (0.25 * tileSize), (int) (0.75 * tileSize), (int) (0.75 * tileSize)); // inventory
            g2.fillRect((int) (21 * tileSize), (int) (0.25 * tileSize), (int) (0.75 * tileSize), (int) (0.75 * tileSize)); // "cahier de l'aventurier" ( nom à changer )
            g2.fillRect((int) (20 * tileSize), (int) (0.25 * tileSize), (int) (0.75 * tileSize), (int) (0.75 * tileSize)); // pass
            g2.fillRect((int) (19 * tileSize), (int) (0.25 * tileSize), (int) (0.75 * tileSize), (int) (0.75 * tileSize)); // appels
            g2.fillRect((int) (18 * tileSize), (int) (0.25 * tileSize), (int) (0.75 * tileSize), (int) (0.75 * tileSize)); // evenements
        } else if (this.inCalls) {
            g2.setColor(Color.WHITE); // banners
            g2.fillRect((int) (0.25 * tileSize), (int) (0.5 * tileSize), (int) (1 * tileSize), (int) (3 * tileSize)); // tempo character banner 1
            g2.fillRect((int) (0.25 * tileSize), (int) (3.75 * tileSize), (int) (1 * tileSize), (int) (3 * tileSize)); // tempo character banner 2
            g2.fillRect((int) (0.25 * tileSize), (int) (7 * tileSize), (int) (1 * tileSize), (int) (3 * tileSize)); // tempo weapon banner
            g2.fillRect((int) (0.25 * tileSize), (int) (10.25 * tileSize), (int) (1 * tileSize), (int) (3 * tileSize)); // standard banner

            g2.setColor(Color.YELLOW); // money
            g2.fillRect((int) (19 * tileSize), (int) (0.25 * tileSize), (int) (3 * tileSize), (int) (1 * tileSize)); // awakening shards ou ancestral shards
            g2.fillRect((int) (15.5 * tileSize), (int) (0.25 * tileSize), (int) (3 * tileSize), (int) (1 * tileSize)); // moonstones

            g2.setColor(Color.RED); // exit button
            g2.fillRect((int) (22.5 * tileSize), (int) (0.25 * tileSize), (int) (1 * tileSize), (int) (1 * tileSize));

            g2.setColor(Color.BLUE); g2.fillRect((int) (6.75 * tileSize), (int) (1.5 * tileSize), (int) (16.5 * tileSize), (int) (10.25 * tileSize)); // banner visual for 5*
            g2.setColor(Color.LIGHT_GRAY); g2.fillRect((int) (1.75 * tileSize), (int) (1.5 * tileSize), (int) (5 * tileSize), (int) (3.5 * tileSize)); // four stars nb 1
            g2.setColor(Color.GRAY); g2.fillRect((int) (1.75 * tileSize), (int) (5 * tileSize), (int) (5 * tileSize), (int) (3.25 * tileSize)); // four stars nb 2
            g2.setColor(Color.DARK_GRAY); g2.fillRect((int) (1.75 * tileSize), (int) (8.25 * tileSize), (int) (5 * tileSize), (int) (3.5 * tileSize)); // four stars nb 3

            g2.setColor(Color.PINK); // pull buttons
            g2.fillRect((int) (14.5 * tileSize), (int) (12 * tileSize), (int) (2.5 * tileSize), (int) (1 * tileSize)); // button single pull
            g2.fillRect((int) (17.5 * tileSize), (int) (12 * tileSize), (int) (2.5 * tileSize), (int) (1 * tileSize)); // button 5 pulls
            g2.fillRect((int) (20.5 * tileSize), (int) (12 * tileSize), (int) (2.5 * tileSize), (int) (1 * tileSize)); // button 10 pulls

            g2.setColor(Color.MAGENTA); // important buttons
            g2.fillRect((int) (2 * tileSize), (int) (12.25 * tileSize), (int) (3 * tileSize), (int) (1 * tileSize)); // shop
            g2.fillRect((int) (5.5 * tileSize), (int) (12.25 * tileSize), (int) (3 * tileSize), (int) (1 * tileSize)); // historic
            g2.fillRect((int) (11 * tileSize), (int) (0.25 * tileSize), (int) (3 * tileSize), (int) (1 * tileSize)); // pity counter
        } else if (this.inMenu) {
            g2.setColor(Color.WHITE); // separation lines
            g2.fillRect((int) (0 * tileSize), (int) (12.75 * tileSize), (int) (24 * tileSize), (int) (0.05 * tileSize));

            g2.setColor(Color.RED);
            g2.fillRect((int) (0.25 * tileSize), (int) (12.25 * tileSize), (int) (1 * tileSize), (int) (1 * tileSize)); // exit button
            g2.fillRect((int) (1.5 * tileSize), (int) (12.25 * tileSize), (int) (1 * tileSize), (int) (1 * tileSize)); // change profile button

            g2.setColor(Color.PINK); // important buttons
            g2.fillRect((int) (22.5 * tileSize), (int) (12.25 * tileSize), (int) (1 * tileSize), (int) (1 * tileSize)); // parameters
            g2.fillRect((int) (21.25 * tileSize), (int) (12.25 * tileSize), (int) (1 * tileSize), (int) (1 * tileSize)); // messages
            g2.fillRect((int) (20 * tileSize), (int) (12.25 * tileSize), (int) (1 * tileSize), (int) (1 * tileSize)); // guides

            g2.setColor(Color.CYAN); // profile
            g2.fillRect((int) (0.5 * tileSize), (int) (0 * tileSize), (int) (4.5 * tileSize), (int) (6.5 * tileSize)); // favorite character
            g2.setFont(arial_30); g2.drawString("\"Player name example\"", (int) (0.5 * tileSize), (int) (7.15 * tileSize)); // player name
            if (gp.birthdayDate[0] < 10 && gp.birthdayDate[1] < 10) {
                g2.drawString("Birthday                       " + gp.birthdayDate[0] + " / " + gp.birthdayDate[1], (int) (0.5 * tileSize), (int) (7.8 * tileSize)); // birthday
            } else if (gp.birthdayDate[0] > 9 || gp.birthdayDate[1] > 9) {
                g2.drawString("Birthday                     " + gp.birthdayDate[0] + " / " + gp.birthdayDate[1], (int) (0.5 * tileSize), (int) (7.8 * tileSize)); // birthday
            } else if (gp.birthdayDate[0] > 9 && gp.birthdayDate[1] > 9) {
                g2.drawString("Birthday                   " + gp.birthdayDate[0] + " / " + gp.birthdayDate[1], (int) (0.5 * tileSize), (int) (7.8 * tileSize)); // birthday
            }
            if (gp.worldLevel < 10) {
                g2.drawString("Level                                 " + gp.worldLevel, (int) (0.5 * tileSize), (int) (8.3 * tileSize)); // player level
            } else {
                g2.drawString("Level                                " + gp.worldLevel, (int) (0.5 * tileSize), (int) (8.3 * tileSize)); // player level
            }
            if (gp.worldLevel < 10) {
                g2.drawString("World Level                      " + gp.worldEvolutionLevel, (int) (0.5 * tileSize), (int) (8.8 * tileSize)); // world level
            } else {
                g2.drawString("World Level                     " + gp.worldEvolutionLevel, (int) (0.5 * tileSize), (int) (8.8 * tileSize)); // world level
            }
            g2.setFont(arial_18);
            g2.drawString(gp.worldExp + " / " + gp.worldLevelMaxExp + " exp", (int) (0.5 * tileSize), (int) (9.2 * tileSize)); // number of world exp
            g2.fillRect((int) (0.25 * tileSize), (int) (9.4 * tileSize), (int) (5 * tileSize), (int) (.2 * tileSize)); // progression bar of world exp
            g2.setColor(Color.BLUE);
            g2.fillRect((int) (0.25 * tileSize), (int) (9.4 * tileSize), (int) (gp.levelExpPercentage * 5 * tileSize), (int) (.2 * tileSize)); // progression bar of world exp

            g2.setColor(Color.YELLOW); g2.setFont(arial_30);
            g2.fillRect((int) (8 * tileSize), (int) (1 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // events logo
            g2.drawString("Event", (int) (8.5 * tileSize), (int) (3.8 * tileSize));
            g2.fillRect((int) (12 * tileSize), (int) (1 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // calls logo
            g2.drawString("Calls", (int) (12.55 * tileSize), (int) (3.8 * tileSize));
            g2.fillRect((int) (16 * tileSize), (int) (1 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // pass logo
            g2.drawString("Pass", (int) (16.6 * tileSize), (int) (3.83 * tileSize));
            g2.fillRect((int) (20 * tileSize), (int) (1 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // traveler guide logo
            g2.drawString("Traveler guide", (int) (19.8 * tileSize), (int) (3.8 * tileSize));
            g2.fillRect((int) (8 * tileSize), (int) (4.5 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // characters logo
            g2.drawString("Characters", (int) (8.1 * tileSize), (int) (7.3 * tileSize));
            g2.fillRect((int) (12 * tileSize), (int) (4.5 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // teams logo
            g2.drawString("Teams", (int) (12.45 * tileSize), (int) (7.3 * tileSize));
            g2.fillRect((int) (16 * tileSize), (int) (4.5 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // character guide logo
            g2.drawString("Character guide", (int) (15.7 * tileSize), (int) (7.3 * tileSize));
            g2.fillRect((int) (20 * tileSize), (int) (4.5 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // achievements logo
            g2.drawString("Achievements", (int) (19.85 * tileSize), (int) (7.3 * tileSize));
            g2.fillRect((int) (8 * tileSize), (int) (8 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // missions logo
            g2.drawString("Missions", (int) (8.25 * tileSize), (int) (10.8 * tileSize));
            g2.fillRect((int) (12 * tileSize), (int) (8 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // map logo
            g2.drawString("Map", (int) (12.65 * tileSize), (int) (10.8 * tileSize));
            g2.fillRect((int) (16 * tileSize), (int) (8 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // inventory logo
            g2.drawString("Inventory", (int) (16.25 * tileSize), (int) (10.8 * tileSize));
            g2.fillRect((int) (20 * tileSize), (int) (8 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // archive
            g2.drawString("Archive", (int) (20.4 * tileSize), (int) (10.8 * tileSize));
        } else if (inEntranceMenu) {
            g2.setFont(arial_30);
            if (gp.profilePage == 0) {
                g2.setColor(Color.WHITE);
                g2.fillRect((int) (1 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 1
                g2.fillRect((int) (6.75 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 2
                g2.fillRect((int) (12.5 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 3
                g2.fillRect((int) (18.25 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 4
                g2.drawString(gp.profilesNames[0], (int) (1 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[1], (int) (6.75 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[2], (int) (12.5 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[3], (int) (18.25 * tileSize), (int) (10.5 * tileSize));

                g2.fillRect((int) (21 * tileSize), (int) (11 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // next page button
            } else if (gp.profilePage == 1) {
                g2.setColor(Color.LIGHT_GRAY);
                g2.fillRect((int) (1 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 5
                g2.fillRect((int) (6.75 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 6
                g2.fillRect((int) (12.5 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 7
                g2.fillRect((int) (18.25 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 8
                g2.drawString(gp.profilesNames[4], (int) (1 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[5], (int) (6.75 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[6], (int) (12.5 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[7], (int) (18.25 * tileSize), (int) (10.5 * tileSize));

                g2.fillRect((int) (0.75 * tileSize), (int) (11 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // previous page button
                g2.fillRect((int) (21 * tileSize), (int) (11 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // next page button
            } else if (gp.profilePage == 2) {
                g2.setColor(Color.GRAY);
                g2.fillRect((int) (1 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 9
                g2.fillRect((int) (6.75 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 10
                g2.fillRect((int) (12.5 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 11
                g2.fillRect((int) (18.25 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 12
                g2.drawString(gp.profilesNames[8], (int) (1 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[9], (int) (6.75 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[10], (int) (12.5 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[11], (int) (18.25 * tileSize), (int) (10.5 * tileSize));

                g2.fillRect((int) (0.75 * tileSize), (int) (11 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // previous page button
                g2.fillRect((int) (21 * tileSize), (int) (11 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // next page button
            } else if (gp.profilePage == 3) {
                g2.setColor(Color.DARK_GRAY);
                g2.fillRect((int) (1 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 13
                g2.fillRect((int) (6.75 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 14
                g2.fillRect((int) (12.5 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 15
                g2.fillRect((int) (18.25 * tileSize), (int) (1 * tileSize), (int) (4.5 * tileSize), (int) (9 * tileSize)); // profile 16
                g2.drawString(gp.profilesNames[4], (int) (1 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[5], (int) (6.75 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[6], (int) (12.5 * tileSize), (int) (10.5 * tileSize));
                g2.drawString(gp.profilesNames[7], (int) (18.25 * tileSize), (int) (10.5 * tileSize));

                g2.fillRect((int) (0.75 * tileSize), (int) (11 * tileSize), (int) (2 * tileSize), (int) (2 * tileSize)); // previous page button
            }
        }

    }

}
