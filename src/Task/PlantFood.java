package Task;

public enum PlantFood {

    MUSHROOM(20),
    GRASS(5);

    private int satiety;

    PlantFood() {

    }

    PlantFood(int satiety) {
        this.satiety = satiety;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }
}
