package main.combat;

import main.artifacts.Artifact;

public class Fighter {

    // STATS //
    public double baseHealth, baseAttack, baseDefense, baseSpeed,
            baseCritRate, baseCritDamage,
            baseEnergyRecharge,
            baseElementalMastery, baseElementalBonus,
            baseEffectResistance, baseEffectBonus,
            baseWeaknessResistance, baseWeaknessBonus,
            baseHealBonus;

    public double health, attack, defense, speed,
            critRate, critDamage,
            energyRecharge,
            elementalMastery, elementalBonus,
            effectResistance, effectBonus,
            weaknessResistance, weaknessBonus,
            healBonus;

    public double combatHealth, combatAttack, combatDefense, combatSpeed,
            combatCritRate, combatCritDamage,
            combatEnergyRecharge,
            combatElementalMastery, combatElementalBonus,
            combatEffectResistance, combatEffectBonus,
            combatWeaknessResistance, combatWeaknessBonus,
            combatHealBonus;

    // LEVELS //
    // Fighter's level :
    public int level;
    // Abilities' levels :
    public int normalAttackLevel, skillLevel, specialAbilityLevel;
    public double[] normalAttackStats = new double[11]; public double[] skillStats = new double[11]; public double[] specialAbilityStats = new double[11];
    public boolean activePassive;

    // ARTIFACTS //
    public Artifact crystal, rune, totem, medallion, codex, tiara;

    // COMBAT //
    public int energy, maxEnergy, normalAttackEnergy, skillEnergy;
    public double[] effects = new double[100]; public String[] effectsType = new String[100]; public int[] effectsDuration = new int[100]; public int nbEffects;

    // FIGHTER DEF //
    public Fighter(double baseHealth, double baseAttack, double baseDefense, double baseSpeed,
                   double baseCritRate, double baseCritDamage,
                   double baseEnergyRecharge,
                   double baseElementalMastery, double baseElementalBonus,
                   double baseEffectResistance, double baseEffectBonus,
                   double baseWeaknessResistance, double baseWeaknessBonus,
                   double baseHealBonus,
                   int maxEnergy, int normalAttackEnergy, int skillEnergy) {

        this.baseHealth = baseHealth; this.baseAttack = baseAttack; this.baseDefense = baseDefense; this.baseSpeed = baseSpeed;
        this.baseCritRate = baseCritRate; this.baseCritDamage = baseCritDamage;
        this.baseEnergyRecharge = baseEnergyRecharge;
        this.baseElementalMastery = baseElementalMastery; this.baseElementalBonus = baseElementalBonus;
        this.baseEffectResistance = baseEffectResistance; this.baseEffectBonus = baseEffectBonus;
        this.baseWeaknessResistance = baseWeaknessResistance; this.baseWeaknessBonus = baseWeaknessBonus;
        this.baseHealBonus = baseHealBonus;

        this.health = this.baseHealth; this.attack = this.baseAttack; this.defense = baseDefense; this.speed = baseSpeed;
        this.critRate = baseCritRate; this.critDamage = baseCritDamage;
        this.energyRecharge = baseEnergyRecharge;
        this.elementalMastery = this.baseElementalMastery; this.elementalBonus = this.baseElementalBonus;
        this.effectResistance = baseEffectResistance; this.effectBonus = baseEffectBonus;
        this.weaknessResistance = baseWeaknessResistance; this.weaknessBonus = baseWeaknessBonus;
        this.healBonus = baseHealBonus;

        this.normalAttackLevel = 0; this.skillLevel = 0; this.specialAbilityLevel = 0;

        this.maxEnergy = maxEnergy; this.normalAttackEnergy = normalAttackEnergy; this.skillEnergy = skillEnergy;
    }

    // Artifacts //
    /**
     * Set all the artifacts of {@code this}
     * @param crystal
     * @param rune
     * @param totem
     * @param medallion
     * @param codex
     * @param tiara
     */
    public void setArtefacts(Artifact crystal, Artifact rune, Artifact totem, Artifact medallion, Artifact codex, Artifact tiara) {
        setCrystal(crystal);
        setRune(rune);
        setTotem(totem);
        setMedallion(medallion);
        setCodex(codex);
        setTiara(tiara);
    }

    /**
     * Set {@code this}'s Crystal
     * @param crystal
     */
    public void setCrystal(Artifact crystal) {
        if (crystal.type == "crystal") {
            this.crystal = crystal;
        }
        artifactCrystalUpdate();
    }

    /**
     * Set {@code this}'s Rune
     * @param rune
     */
    public void setRune(Artifact rune) {
        if (crystal.type == "rune") {
            this.rune = rune;
        }
        artifactRuneUpdate();
    }

    /**
     * Set {@code this}'s Totem
     * @param totem
     */
    public void setTotem(Artifact totem) {
        if (crystal.type == "totem") {
            this.totem = totem;
        }
        artifactTotemUpdate();
    }

    /**
     * Set {@code this}'s Medallion
     * @param medallion
     */
    public void setMedallion(Artifact medallion) {
        if (crystal.type == "medaillon") {
            this.medallion = medallion;
        }
        artifactMedallion();
    }

    /**
     * Set {@code this}'s Codex
     * @param codex
     */
    public void setCodex(Artifact codex) {
        if (crystal.type == "codex") {
            this.codex = codex;
        }
        artifactCodexUpdate();
    }

    /**
     * Set {@code this}'s Tiara
     * @param tiara
     */
    public void setTiara(Artifact tiara) {
        if (crystal.type == "tiara") {
            this.tiara = tiara;
        }
        artifactTiaraUpdate();
    }

    /**
     * Set up the stats with {@code this}'s artifacts
     */
    public void artifactsUpdate() {
        artifactCrystalUpdate();
        artifactRuneUpdate();
        artifactTotemUpdate();
        artifactMedallion();
        artifactCodexUpdate();
        artifactTiaraUpdate();
    }

    /**
     * Update the stats with {@code this}'s Crystal's stats
     */
    public void artifactCrystalUpdate() {
        // Main stats : HP% or HP
        if (this.crystal.getMainStatType() == "HP%") {
            this.health += baseHealth * this.crystal.mainStat;
        } else if (this.crystal.getMainStatType() == "HP") {
            this.health += this.crystal.mainStat;
        }

        // Sub stats
        for (int i = 0; i < 4; i++) {
            if (this.crystal.getSubStatsType()[i] == "HP%") {
                this.health += baseHealth * this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "HP") {
                this.health += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "ATK%") {
                this.attack += baseAttack * this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "ATK") {
                this.attack += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "DEF%") {
                this.defense += baseDefense * this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "DEF") {
                this.defense += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "SPD") {
                this.speed += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "CR") {
                this.critRate += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "CD") {
                this.critDamage += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "ER") {
                this.energyRecharge += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "EM") {
                this.elementalMastery += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "EB") {
                this.elementalBonus += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "EFR") {
                this.effectResistance += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "EB") {
                this.effectBonus += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "WR") {
                this.weaknessResistance += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "WB") {
                this.weaknessBonus += this.crystal.getSubStats()[i];
            } else if (this.crystal.getSubStatsType()[i] == "HB") {
                this.healBonus += this.crystal.getSubStats()[i];
            }
        }
    }

    /**
     * Update the stats with {@code this}'s Rune's stats
     */
    public void artifactRuneUpdate() {
        // Main stats : ATK% or ATK or Elemental bonus
        if (this.rune.getMainStatType() == "ATK%") {
            this.attack += baseAttack * this.rune.mainStat;
        } else if (this.rune.getMainStatType() == "ATK") {
            this.attack += this.rune.mainStat;
        } else if (this.rune.getMainStatType() == "EM") {
            this.elementalBonus += this.rune.mainStat;
        }

        // Sub stats
        for (int i = 0; i < 4; i++) {
            if (this.rune.getSubStatsType()[i] == "HP%") {
                this.health += baseHealth * this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "HP") {
                this.health += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "ATK%") {
                this.attack += baseAttack * this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "ATK") {
                this.attack += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "DEF%") {
                this.defense += baseDefense * this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "DEF") {
                this.defense += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "SPD") {
                this.speed += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "CR") {
                this.critRate += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "CD") {
                this.critDamage += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "ER") {
                this.energyRecharge += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "EM") {
                this.elementalMastery += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "EB") {
                this.elementalBonus += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "EFR") {
                this.effectResistance += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "EB") {
                this.effectBonus += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "WR") {
                this.weaknessResistance += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "WB") {
                this.weaknessBonus += this.rune.getSubStats()[i];
            } else if (this.rune.getSubStatsType()[i] == "HB") {
                this.healBonus += this.rune.getSubStats()[i];
            }
        }
    }

    /**
     * Update the stats with {@code this}'s Totem's stats
     */
    public void artifactTotemUpdate() {
        // Main stats : DEF% or DEF or Effects resistance or Weakness resistance
        if (this.totem.getMainStatType() == "DEF%") {
            this.defense += baseDefense * this.totem.mainStat;
        } else if (this.totem.getMainStatType() == "DEF") {
            this.defense += this.totem.mainStat;
        } else if (this.totem.getMainStatType() == "EFR") {
            this.effectResistance += this.totem.mainStat;
        } else if (this.totem.getMainStatType() == "WR") {
            this.weaknessResistance += this.totem.mainStat;
        }

        // Sub stats
        for (int i = 0; i < 4; i++) {
            if (this.totem.getSubStatsType()[i] == "HP%") {
                this.health += baseHealth * this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "HP") {
                this.health += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "ATK%") {
                this.attack += baseAttack * this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "ATK") {
                this.attack += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "DEF%") {
                this.defense += baseDefense * this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "DEF") {
                this.defense += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "SPD") {
                this.speed += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "CR") {
                this.critRate += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "CD") {
                this.critDamage += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "ER") {
                this.energyRecharge += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "EM") {
                this.elementalMastery += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "EB") {
                this.elementalBonus += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "EFR") {
                this.effectResistance += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "EB") {
                this.effectBonus += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "WR") {
                this.weaknessResistance += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "WB") {
                this.weaknessBonus += this.totem.getSubStats()[i];
            } else if (this.totem.getSubStatsType()[i] == "HB") {
                this.healBonus += this.totem.getSubStats()[i];
            }
        }
    }

    /**
     * Update the stats with {@code this}'s Medallion's stats
     */
    public void artifactMedallion() {
        // Main stats : Energy recharge or Effects bonus or Weakness bonus
        if (this.medallion.getMainStatType() == "ER") {
            this.energyRecharge += this.medallion.mainStat;
        } else if (this.medallion.getMainStatType() == "EFB") {
            this.effectBonus += this.medallion.mainStat;
        } else if (this.medallion.getMainStatType() == "WB") {
            this.weaknessBonus += this.medallion.mainStat;
        }

        // Sub stats
        for (int i = 0; i < 4; i++) {
            if (this.medallion.getSubStatsType()[i] == "HP%") {
                this.health += baseHealth * this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "HP") {
                this.health += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "ATK%") {
                this.attack += baseAttack * this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "ATK") {
                this.attack += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "DEF%") {
                this.defense += baseDefense * this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "DEF") {
                this.defense += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "SPD") {
                this.speed += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "CR") {
                this.critRate += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "CD") {
                this.critDamage += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "ER") {
                this.energyRecharge += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "EM") {
                this.elementalMastery += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "EB") {
                this.elementalBonus += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "EFR") {
                this.effectResistance += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "EB") {
                this.effectBonus += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "WR") {
                this.weaknessResistance += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "WB") {
                this.weaknessBonus += this.medallion.getSubStats()[i];
            } else if (this.medallion.getSubStatsType()[i] == "HB") {
                this.healBonus += this.medallion.getSubStats()[i];
            }
        }
    }

    /**
     * Update the stats with {@code this}'s Codex's stats
     */
    public void artifactCodexUpdate() {
        // Main stats : Crit Rate or Crit damage
        if (this.codex.getMainStatType() == "CR") {
            this.critRate += this.codex.mainStat;
        } else if (this.codex.getMainStatType() == "CD") {
            this.critDamage += this.codex.mainStat;
        }

        // Sub stats
        for (int i = 0; i < 4; i++) {
            if (this.codex.getSubStatsType()[i] == "HP%") {
                this.health += baseHealth * this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "HP") {
                this.health += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "ATK%") {
                this.attack += baseAttack * this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "ATK") {
                this.attack += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "DEF%") {
                this.defense += baseDefense * this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "DEF") {
                this.defense += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "SPD") {
                this.speed += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "CR") {
                this.critRate += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "CD") {
                this.critDamage += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "ER") {
                this.energyRecharge += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "EM") {
                this.elementalMastery += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "EB") {
                this.elementalBonus += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "EFR") {
                this.effectResistance += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "EB") {
                this.effectBonus += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "WR") {
                this.weaknessResistance += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "WB") {
                this.weaknessBonus += this.codex.getSubStats()[i];
            } else if (this.codex.getSubStatsType()[i] == "HB") {
                this.healBonus += this.codex.getSubStats()[i];
            }
        }
    }

    /**
     * Update the stats with {@code this}'s Tiara's stats
     */
    public void artifactTiaraUpdate() {
        // Main stats : Elemental mastery or Heal bonus
        if (this.tiara.getMainStatType() == "EM") {
            this.elementalMastery += this.tiara.mainStat;
        } else if (this.tiara.getMainStatType() == "HB") {
            this.healBonus += this.tiara.mainStat;
        }

        // Sub stats
        for (int i = 0; i < 4; i++) {
            if (this.tiara.getSubStatsType()[i] == "HP%") {
                this.health += baseHealth * this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "HP") {
                this.health += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "ATK%") {
                this.attack += baseAttack * this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "ATK") {
                this.attack += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "DEF%") {
                this.defense += baseDefense * this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "DEF") {
                this.defense += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "SPD") {
                this.speed += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "CR") {
                this.critRate += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "CD") {
                this.critDamage += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "ER") {
                this.energyRecharge += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "EM") {
                this.elementalMastery += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "EB") {
                this.elementalBonus += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "EFR") {
                this.effectResistance += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "EB") {
                this.effectBonus += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "WR") {
                this.weaknessResistance += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "WB") {
                this.weaknessBonus += this.tiara.getSubStats()[i];
            } else if (this.tiara.getSubStatsType()[i] == "HB") {
                this.healBonus += this.tiara.getSubStats()[i];
            }
        }
    }

    // Combat //

    /**
     * Set up the combat : reset stats
     */
    public void setUpCombat() {
        this.combatHealth = this.health; this.combatAttack = this.attack; this.combatDefense = defense; this.combatSpeed = speed;
        this.combatCritRate = critRate; this.combatCritDamage = critDamage;
        this.combatEnergyRecharge = energyRecharge;
        this.combatElementalMastery = this.elementalMastery; this.combatElementalBonus = this.elementalBonus;
        this.combatEffectResistance = effectResistance; this.combatEffectBonus = effectBonus;
        this.combatWeaknessResistance = weaknessResistance; this.combatWeaknessBonus = weaknessBonus;
        this.combatHealBonus = healBonus;

        this.energy = 0;
        this.nbEffects = 0;
        this.activePassive = false;
    }

    /**
     * Make {@code this} gain energy
     * @param amount
     */
    public void gainEnergy(int amount) {
        if ((this.energy + amount) <= maxEnergy) {
            this.energy += amount;
        } else {
            this.energy = maxEnergy;
        }
    }

    /**
     * Types of effects : shield, heal, damage reduction, provocation
     * @param amount
     * @param type
     * @param duration
     */
    public void createEffect(double amount, String type, int duration) {
        this.effects[nbEffects] = amount; this.effectsType[nbEffects] = type; this.effectsDuration[nbEffects] = duration;
        this.nbEffects += 1;
    }

    /**
     * Do a normal attack to a target
     * @param enemy
     */
    public void normalAttack(Fighter enemy){
        enemy.looseHealth(this.normalAttackStats[normalAttackLevel] * this.combatAttack);
        gainEnergy(normalAttackEnergy); // return 7 points of energy
    }

    /**
     * Give a shield to the target
     * @param ally
     * @param amount
     * @param duration
     */
    public void giveShield(Fighter ally, double amount, int duration) {
        ally.createEffect(amount, "shield", duration);
    }

    /**
     * Heal the target
     * @param ally
     * @param amount
     * @param duration
     */
    public void giveHeal(Fighter ally, double amount, int duration) {
        ally.createEffect(amount, "heal", duration);
    }

    /**
     * Make {@code this} take damage
     * @param damage
     */
    public void looseHealth(double damage) {
        this.combatHealth -= (int) damage;
    }

}
