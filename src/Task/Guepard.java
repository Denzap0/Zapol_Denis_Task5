package Task;

import java.util.Scanner;

public class Guepard implements Movable {

    private final int pawsNum = 4, maxSpeed = 120, maxAge = 20;
    private String name;
    private int speed, age;
    private double powerRemainder, endurance;
    private boolean sleepDesire;

    Guepard() {
        this.name = "Guepard";
        this.endurance = 3;
        this.powerRemainder = 100;
        this.speed = 10;
        this.age = 2;
    }

    Guepard(String name, int endurance, double powerRemainder, int speed, int age) {
        this.name = name;
        this.powerRemainder = powerRemainder;
        this.speed = 0;
        this.age = age;
        if (age > maxAge) {
            age = maxAge;
        }
        endurance = age;
    }

    public void eat(PlantFood food, int quantity) {
        if (powerRemainder + food.getSatiety() * quantity > 100) {
            powerRemainder = 100;
        } else {
            powerRemainder += food.getSatiety() * quantity;
        }
    }

    public void eat(MeatFood food, int quantity) { //overload
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPowerRemainder() {
        return powerRemainder;
    }

    public void setPowerRemainder(double powerRemainder) {
        this.powerRemainder = powerRemainder;
    }

    public double getEndurance() {
        return endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    public boolean isSleepDesire() {
        return sleepDesire;
    }

    public void setSleepDesire(boolean sleepDesire) {
        this.sleepDesire = sleepDesire;
    }

    @Override
    public void move() {
        if (age >= 1 && !sleepDesire && speed > 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Write your distance");
            int distance = sc.nextInt();
            double endurance2 = endurance * (speed / 1000.0);
            if ((endurance + endurance2) * distance < powerRemainder) {
                powerRemainder -= (endurance + endurance2) * distance;
                sleepDesire = true;
                System.out.println("Your guepard has got this distance with speed " + speed + " and your power remainder is " +
                        powerRemainder + ". Don`t forget to sleep.");
            } else {
                System.out.println("Your geupard need to eat");
            }
        } else if (age < 1) {
            System.out.println("Your geupard is too young");
        } else if (sleepDesire) {
            System.out.println("You need to sleep");
        } else if (speed == 0) {
            System.out.println("Your speed is 0 km/h");
        }

    }


}
