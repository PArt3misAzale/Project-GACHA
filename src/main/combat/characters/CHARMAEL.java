package main.combat.characters;

import main.combat.Fighter;

public class CHARMAEL extends Fighter {

    public CHARMAEL(double baseHealth, double baseAttack, double baseDefense, double baseSpeed,
                    double baseCritRate, double baseCritDamage,
                    double baseEnergyRecharge,
                    double baseElementalMastery, double baseElementalBonus,
                    double baseEffectResistance, double baseEffectBonus,
                    double baseWeaknessResistance, double baseWeaknessBonus,
                    double baseHealBonus,
                    int maxEnergy, int normalAttackEnergy, int skillEnergy) {

        super(baseHealth, baseAttack, baseDefense, baseSpeed,
                baseCritRate, baseCritDamage,
                baseEnergyRecharge,
                baseElementalMastery, baseElementalBonus,
                baseEffectResistance, baseEffectBonus,
                baseWeaknessResistance, baseWeaknessBonus,
                baseHealBonus,
                maxEnergy, normalAttackEnergy, skillEnergy);

        this.normalAttackStats[0] = 0.5; this.normalAttackStats[1] = 0.5; this.normalAttackStats[2] = 0.51; this.normalAttackStats[3] = 0.51;
        this.normalAttackStats[4] = 0.52; this.normalAttackStats[5] = 0.54; this.normalAttackStats[6] = 0.55; this.normalAttackStats[7] = 0.58;
        this.normalAttackStats[8] = 0.61; this.normalAttackStats[9] = 0.61; this.normalAttackStats[10] = 0.71;

        this.skillStats[0] = 0.1; this.skillStats[1] = 0.1; this.skillStats[2] = 0.11; this.skillStats[3] = 0.12;
        this.skillStats[4] = 0.14; this.skillStats[5] = 0.16; this.skillStats[6] = 0.2; this.skillStats[7] = 0.25;
        this.skillStats[8] = 0.33; this.skillStats[9] = 0.44; this.skillStats[10] = 0.61;

        this.specialAbilityStats[0] = 0.2; this.specialAbilityStats[1] = 0.21; this.specialAbilityStats[2] = 0.21; this.specialAbilityStats[3] = 0.23;
        this.specialAbilityStats[4] = 0.25; this.specialAbilityStats[5] = 0.29; this.specialAbilityStats[6] = 0.34; this.specialAbilityStats[7] = 0.542;
        this.specialAbilityStats[8] = 0.56; this.specialAbilityStats[9] = 0.77; this.specialAbilityStats[10] = 1.1;
    }

    /**
     * {@link CHARMAEL}'s skill : grants an ally a shield
     * @param ally
     */
    public void skill(Fighter ally) {
        if (ally == this) {
            createEffect(this.skillStats[skillLevel] * this.combatDefense + this.skillStats[skillLevel] * this.combatDefense * 0.2, "shield", 2);
        } else {
            giveShield(ally, this.skillStats[skillLevel] * this.combatDefense, 2);
        }
        gainEnergy(this.skillEnergy);
    }

    /**
     * {@link CHARMAEL}'s special ability : grants the team a shield, give himself "provocation" and "damage reduction"
     * @param ally1
     * @param ally2
     * @param ally3
     */
    public void specialAbility(Fighter ally1, Fighter ally2, Fighter ally3) {
        if (this.energy == this.maxEnergy) {
            // Shields
            giveShield(ally1, this.specialAbilityStats[specialAbilityLevel] * this.combatDefense, 2);
            giveShield(ally2, this.specialAbilityStats[specialAbilityLevel] * this.combatDefense, 2);
            giveShield(ally3, this.specialAbilityStats[specialAbilityLevel] * this.combatDefense, 2);
            createEffect(this.specialAbilityStats[specialAbilityLevel] * this.combatDefense
                    + this.specialAbilityStats[specialAbilityLevel] * this.combatDefense * 0.2, "shield", 2);

            // effects
            createEffect(0.8, "provocation", 2);
            createEffect(0.15, "damage reduction", 2);
        }
    }

    public void passive() {
        this.activePassive = false;
        for (int i = 0; i < this.effectsType.length; i++) {
            if (this.effectsType[i] == "shield") {
                this.activePassive = true;
            }
        }
        if (this.activePassive) {
            createEffect(0.15, "damage reduction", 1);
        }
    }

}
