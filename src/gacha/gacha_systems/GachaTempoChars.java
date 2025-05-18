package gacha.gacha_systems;

import gacha.Gacha;
import main.GamePanel;
import main.combat.Fighter;

import java.util.Random;

public class GachaTempoChars extends Gacha {

    public Fighter[] fiveTempoChars;
    public Fighter[] fourTempoChars;

    GamePanel gp;

    Random random = new Random();

    public GachaTempoChars(GamePanel gp) {
        this.gp = gp;

        fiveTempoChars = new Fighter[gp.maxFiveTempoChars];
        fiveTempoChars[0] = gp.charMael;
    }

    public void setup() {
        tryUpdateTempoChars();
    }

    public void tryUpdateTempoChars() {

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
    }
}
