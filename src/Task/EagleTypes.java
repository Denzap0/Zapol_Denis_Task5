package Task;

public enum EagleTypes {

    GOLDEN("Golden", 240),
    HAWKISH("Hawkish", 170),
    STONE("Stone", 120);

    private String name;
    private int maxSpeed;

    EagleTypes() {

    }

    EagleTypes(String name, int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
