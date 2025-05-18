package main.combat.weapons;

import main.GamePanel;
import main.combat.Fighter;
import main.combat.Weapon;

public class WEAP_GRANITCOLUMN extends Weapon {

    public WEAP_GRANITCOLUMN(String name, int mainStat, String mainStatType, GamePanel gp) {
        super(name, mainStat, mainStatType, gp);

        this.passiveStats[0] = 0.05; this.passiveStats[1] = 0.09; this.passiveStats[2] = 0.15; this.passiveStats[3] = 0.23; this.passiveStats[4] = 0.33;
    }

    public void updatePassive(Fighter ally0, Fighter ally1, Fighter ally2, Fighter self) {
        for (int i = 0; i < 4; i++) {
            ally0.allyEffects[i][2].setIsActive(false); // delete the damage reduction
            if (ally0.allyEffects[i][1].isActive) { // if the ally has a shield by ally i
                if (ally0.findPointerAlly(i) == self) { // if the ally's shield is by self
                    ally0.allyEffects[i][2].setAmount(this.passiveStats[passiveLevel]); // set the damage reduction
                    ally0.allyEffects[i][2].setIsActive(true); // set the damage reduction true
                }
            } // same here
            ally1.allyEffects[i][2].setIsActive(false);
            if (ally1.allyEffects[i][1].isActive) {
                if (ally1.findPointerAlly(i) == self) {
                    ally1.allyEffects[i][2].setAmount(this.passiveStats[passiveLevel]);
                    ally1.allyEffects[i][2].setIsActive(true);
                }
            } // same here
            ally2.allyEffects[i][2].setIsActive(false);
            if (ally2.allyEffects[i][1].isActive) {
                if (ally2.findPointerAlly(i) == self) {
                    ally2.allyEffects[i][2].setAmount(this.passiveStats[passiveLevel]);
                    ally2.allyEffects[i][2].setIsActive(true);
                }
            }
        }
    }

}
