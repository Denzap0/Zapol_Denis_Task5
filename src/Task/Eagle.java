package Task;

import java.util.Scanner;

public class Eagle implements Movable {

    private String name;
    private EagleTypes type;
    private int age, flightAltitude, flightSpeed, powerRemainder;
    private boolean sleepDesire;

    Eagle() {
        this.name = "Eagle";
        this.type = EagleTypes.STONE;
        this.age = 3;
        this.flightAltitude = 0;
        this.flightSpeed = 0;
        this.powerRemainder = 100;
    }

    Eagle(String name, EagleTypes types, int age, int flightAltitude, int flightSpeed, int powerRemainder, boolean sleepDesire) {
        this.name = name;
        this.type = types;
        this.age = age;
        this.flightAltitude = flightAltitude;
        this.flightSpeed = flightSpeed;
        this.powerRemainder = powerRemainder;
        this.sleepDesire = sleepDesire;
    }

    public void eat(PlantFood food, int quantity) {
        if (powerRemainder + food.getSatiety() * quantity > 100) {
            powerRemainder = 100;
        } else {
            powerRemainder += food.getSatiety() * quantity;
        }
    }

    public void eat(MeatFood food, int quantity) {
        if (powerRemainder + food.getSatiety() * quantity > 100) {
            powerRemainder = 100;
        } else {
            powerRemainder += food.getSatiety() * quantity;
        }
    }

    public void sleep() {
        sleepDesire = false;
        System.out.println("You slept");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EagleTypes getType() {
        return type;
    }

    public void setType(EagleTypes type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFlightAltitude() {
        return flightAltitude;
    }

    public void setFlightAltitude(int flightAltitude) {
        this.flightAltitude = flightAltitude;
    }

    public int getFlightSpeed() {
        return flightSpeed;
    }

    public void setFlightSpeed(int flightSpeed) {
        this.flightSpeed = flightSpeed;
        if (flightSpeed > type.getMaxSpeed()) {
            System.out.println("Your eagle type can not develop this speed. Write new speed.");
            Scanner sc = new Scanner(System.in);
            setFlightSpeed(sc.nextInt());
        }
    }

    public int getPowerRemainder() {
        return powerRemainder;
    }

    public void setPowerRemainder(int powerRemainder) {
        this.powerRemainder = powerRemainder;
    }

    public boolean isSleepDesire() {
        return sleepDesire;
    }

    public void setSleepDesire(boolean sleepDesire) {
        this.sleepDesire = sleepDesire;
    }

    @Override

    public void move() {
        if (!sleepDesire && powerRemainder > 0 && flightSpeed > 0 && flightAltitude > 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Write your distance in meters");
            int distance = sc.nextInt();
            if (distance > flightAltitude * 2 && (flightSpeed / 10.0) * (distance / 1000.0) < powerRemainder) {
                System.out.print("Getting up: ");
                for (int i = 0; i < flightAltitude; i++) {
                    System.out.print(i + 1 + " ");
                }
                System.out.println("\nFlying " + (double) (distance - flightAltitude * 2.0) + " m");
                System.out.println("Getting down");
                for (int i = flightAltitude; i > 0; i--) {
                    System.out.print(i + " ");
                }
                powerRemainder -= (flightSpeed / 10.0) * (distance / 1000.0);
                System.out.println("\nYou flew this distance with speed " + flightSpeed + " and your power remainder is "
                        + powerRemainder);
            } else if (flightSpeed * (distance / 1000.0) > powerRemainder) {
                System.out.println("Your power remainder is too small");
            } else {
                System.out.println("Your distance is too small for this altitude");
            }

        } else if (sleepDesire) {
            System.out.println("You need to sleep");
        } else if (flightSpeed <= 0) {
            System.out.println("You can not fly with speed 0");
        } else if (flightAltitude <= 0) {
            System.out.println("Your altitude is 0");
        } else {
            System.out.println("Your power remainder is 0");
        }
    }
}
