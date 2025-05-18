package main.combat;

import main.GamePanel;
import main.Item;

public class Weapon extends Item {

    public GamePanel gp;

    public int mainStat;
    public String mainStatType;
    public double[] passiveStats;

    public int level = 0;
    public int passiveLevel = 0;

    public Weapon(String name, int mainStat, String mainStatType, GamePanel gp) {
        super(name);
        this.gp = gp;

        this.mainStat = mainStat; this.mainStatType = mainStatType;
        this.passiveStats = new double[5];
    }

    public void gainLevel() {
        this.level++;
    }

    public void gainXLevels(int j) {
        for (int i = 0; i < j; i++) { this.gainLevel(); }
    }

    public void gainPassiveLevel() {
        this.passiveLevel++;
    }

    public void gainXPassiveLevel(int j) {
        for (int i = 0; i < j; i++) { this.gainPassiveLevel(); }
    }
}
