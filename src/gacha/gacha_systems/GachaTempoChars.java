package gacha.gacha_systems;

import gacha.Gacha;
import main.GamePanel;
import main.combat.Fighter;

import java.util.Random;

public class GachaTempoChars extends Gacha {

    public Fighter[] fiveTempoChars;
    public Fighter[] fourTempoChars;

    public int bannerNumber;
    public int[] bannerDays = new int[36];

    GamePanel gp;

    Random random = new Random();

    public GachaTempoChars(GamePanel gp) {
        this.gp = gp;

        fiveTempoChars = new Fighter[gp.maxFiveTempoChars];
        fiveTempoChars[0] = gp.charMael;
    }

    public void setup() {
        gp.updateDate();
        tryUpdateTempoChars();
    }

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
        }
        if (baseBannerNumber != bannerNumber) { updateTempoChars(); }
    }

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

    public void setBannerDays() {
        int n = 0; int j; boolean specialDaySet = false;
        for (int i = 0; i < 36; i++) {
            bannerDays[i] = n;
            j = random.nextInt(36);
            if (j == 0 && !specialDaySet) {
                specialDaySet = true;
                n += 15;
            } else {
                n += 10;
            }
        }
    }
}
