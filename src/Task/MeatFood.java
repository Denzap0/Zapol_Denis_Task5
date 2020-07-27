package Task;

public enum MeatFood {
    UNGULATE(100),
    GAZELLE(50),
    ANTELOPE(25);

    int satiety;

    MeatFood() {

    }

    MeatFood(int satiety) {
        this.satiety = satiety;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }
}
