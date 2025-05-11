package main.artifacts;

public class Artifact {

    public double mainStat; public double[] subStats;
    public String mainStatType; public String[] subStatsType;
    public String type;

    /**
     * Different stats :
     * Attack (atk), Health (hp), defense (def), speed (spd), crit rate (cr), crit damage (cd), energy recharge (er), elemental mastery (em), elemental bonus (eb),
     * effects resistance (efr), effects bonus (efb), weakness resistance (wr), weakness bonus (wb), heal bonus (hb).
     * See {@link main.combat.Fighter Fighter}
     * @param mainStat
     * @param subStats
     * @param mainStatType
     * @param subStatsType
     * @param type
     *
     */

    public Artifact(double mainStat, double[] subStats, String mainStatType, String[] subStatsType, String type) {

        this.mainStat = mainStat; this.subStats = subStats;
        this.mainStatType = mainStatType; this.subStatsType = subStatsType;
        this.type = type;

    }

    public double getMainStat() {
        return mainStat;
    }

    public double[] getSubStats() {
        return subStats;
    }

    public String getMainStatType() {
        return mainStatType;
    }

    public String[] getSubStatsType() {
        return subStatsType;
    }

    public String getType() {
        return type;
    }
}
