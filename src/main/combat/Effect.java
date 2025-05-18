package main.combat;

public class Effect {

    public double amount;
    public boolean isActive;
    public int duration;
    /*
     * 0: heal
     * 1: shield
     * 2: damage reduction
     * 3: provocation
     */
    public int type;

    public Effect() {
        this.isActive = false;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
        if (! this.isActive) {
            this.setAmount(0);
        }
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setType(int type) {
        this.type = type;
    }

}
