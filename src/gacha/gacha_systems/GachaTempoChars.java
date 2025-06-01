package gacha.gacha_systems;

import gacha.Gacha;
import main.GamePanel;
import main.Item;
import main.combat.Fighter;
import main.combat.Weapon;

import java.util.Random;

public class GachaTempoChars extends Gacha {

    public Fighter[] fiveTempoChars;
    public Fighter[] fourTempoChars;

    public Fighter[] fiveStandardCharacters;
    public Fighter[] fourStandardCharacters;

    public Weapon[] fiveTempoWeapons;
    public Weapon[] fiveStandardWeapons;
    public Weapon[] fourStandardWeapons;

    public int bannerNumber;
    public int[] bannerDays = new int[36];
    public int specialBannerDay;

    public int pity, fsPity;
    public boolean guaranteed, fsGuaranteed;

    GamePanel gp;

    Random random = new Random();

    public GachaTempoChars(GamePanel gp) {
        this.gp = gp;

        this.fiveTempoChars = new Fighter[this.gp.maxFiveTempoChars];
        this.fourTempoChars = new Fighter[this.gp.maxFourTempoChars];

        this.fiveStandardCharacters = new Fighter[this.gp.maxFiveStandardChars];
        this.fiveStandardCharacters[0] = gp.charMael;
        this.fourStandardCharacters = new Fighter[this.gp.maxFourStandardChars];
    }

    public void setup() {
        gp.updateDate();
        tryUpdateTempoChars();
    }

    /**
     * Verify if the day of the current banner is before/after than the day of the year or if the day of the year is between the right two banners
     */
    public void tryUpdateTempoChars() {
        int baseBannerNumber = bannerNumber;
        if (bannerDays[this.bannerNumber] < gp.dayOfYear) {
            while (bannerDays[this.bannerNumber] < gp.dayOfYear) {
                bannerNumber++;
            }
        } else if (bannerDays[this.bannerNumber] > gp.dayOfYear) {
            while (bannerDays[this.bannerNumber] > gp.dayOfYear) {
                bannerNumber--;
            }
        } else if (bannerDays[this.bannerNumber] < gp.dayOfYear || gp.dayOfYear < bannerDays[this.bannerNumber + 1]) {
            baseBannerNumber = bannerNumber;
        }
        if (baseBannerNumber != bannerNumber) { updateTempoChars(); }
    }

    /**
     *  Update the temporary banners with random temporary characters ( for five stars characters ) and within all characters range for four stars
     */
    public void updateTempoChars() {
        // 5 stars //
        int n = random.nextInt(gp.maxFiveTempoChars); this.fisc[0] = this.fiveTempoChars[n];
        n = random.nextInt(gp.maxFiveTempoChars);
        while (this.fiveTempoChars[n] != this.fisc[0]) {
            n = random.nextInt(gp.maxFiveTempoChars);
        } this.fisc[1] = this.fiveTempoChars[n];

        // 4 stars //
        n = random.nextInt(gp.maxFourTempoChars); this.fosc[0] = fourTempoChars[n];
        n = random.nextInt(gp.maxFourTempoChars);
        while (this.fourTempoChars[n] != this.fosc[0]) {
            n = random.nextInt(gp.maxFourTempoChars);
        } this.fosc[1] = fourTempoChars[n];
        n = random.nextInt(gp.maxFourTempoChars);
        while (this.fourTempoChars[n] != this.fosc[0] && this.fourTempoChars[n] != this.fosc[1]) {
            n = random.nextInt(gp.maxFourTempoChars);
        } this.fosc[2] = fourTempoChars[n];

        bannerNumber++;
    }

    /**
     * Every year, set the banners days with the {@code specialBannerDay} in it
     */
    public void setBannerDays() {
        int n = 0; int j; boolean specialDaySet = false;
        for (int i = 0; i < 36; i++) {
            bannerDays[i] = n;
            j = random.nextInt(36);
            if (j == 0 && !specialDaySet) {
                specialDaySet = true;
                this.specialBannerDay = n;
                n += 15;
            } else {
                n += 10;
            }
        }
    }

    // AJOUTER l'AUGMENTATION DE PITY POUR 4* ET 5* //
    public Item pull(Fighter character) {
        if (random.nextInt(10000) < pity * 100 ) { // if the character pulled is a five stars character
            if (guaranteed) { // if the character is guaranteed
                guaranteed = false; // next character will not be guaranteed
                return character; // give the character the player pulled for
            } else { // if the character is not guaranteed
                if (random.nextInt(3) == 0) { // 1/3 chance of getting the character that the player want
                    return character; // give the character that the player pulled for
                } else { // 2/3 of getting a random standard character
                    guaranteed = true; // the next character will be guaranteed
                    return this.fiveStandardCharacters[random.nextInt(this.gp.maxFiveStandardChars)]; // give a random standard character
                }
            }
        } else if (random.nextInt(10000) < fsPity * 100) { // if the character pulled is a four stars character
                if (fsGuaranteed) { // if the character is guaranteed
                    return this.fourTempoChars[random.nextInt(this.gp.maxFourTempoChars)]; // give a random tempo four stars character
                } else { // if the character is not guaranteed
                if (random.nextInt(3) == 0) { // 1/3 chance of getting a character
                    return this.fourStandardCharacters[random.nextInt(this.gp.maxFourStandardChars)]; // give a random standard four stars character
                } else { // 2/3 chance of getting a four stars weapon
                    return this.fourStandardWeapons[random.nextInt(this.gp.getMaxFourStandardWeapons)]; // give a random standard four stars weapon
                }
            }
        }
        return new Item("NONE");
    }

    public Item[] pull5(Fighter character) { // do 5 pulls and return a list of the 5 rewards
        Item[] rewards = new Item[5];
        for (int i = 0; i < 5; i++) { rewards[i] = this.pull(character); }
        return rewards;
    }

    public Item[] pull10(Fighter character) { // do 10 pulls and return a list of the 10 rewards
        Item[] rewards = new Item[10];
        for (int i = 0; i < 10; i++) { rewards[i] = this.pull(character); }
        return rewards;
    }
}
