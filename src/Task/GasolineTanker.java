package Task;

import java.util.Date;
import java.util.Scanner;

public class GasolineTanker extends Car {

    private int maxSpeed, maxFuelCapacity, speed, fuelCapacity, fuelLevel, maxFuelLevel;//fuel capacity in a trailer
    private double fuelConsumption;

    GasolineTanker() {
        super();
        maxSpeed = 90;
        maxFuelCapacity = 5000;
        speed = 0;
        fuelCapacity = 0;
        maxFuelLevel = 200;
        fuelLevel = maxFuelLevel;
        fuelConsumption = 0.35;
    }

    GasolineTanker(String colour, int serialNum, Date date, Model model, boolean state, int acceleration, int maxSpeed,
                   int maxFuelCapacity, int fuelCapacity, int fuelLevel, int maxFuelLevel, double fuelConsumption) {
        super(colour, serialNum, date, model, state);
        this.maxSpeed = maxSpeed;
        this.maxFuelCapacity = maxFuelCapacity;
        this.fuelCapacity = fuelCapacity;
        this.fuelLevel = fuelLevel;
        this.maxFuelLevel = maxFuelLevel;
        this.fuelConsumption = fuelConsumption;
    }

    public void fuelFill(int capacity) {
        fuelCapacity += fuelCapacity + capacity > maxFuelCapacity ? maxFuelCapacity - fuelCapacity : capacity;
    }

    public void fuelDrain(int capacity) {
        fuelCapacity -= Math.min(fuelCapacity, capacity);
    }

    public void refueling(int capacity) {
        fuelLevel = fuelLevel + capacity <= maxFuelLevel ? fuelLevel + capacity : maxFuelLevel;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxFuelCapacity() {
        return maxFuelCapacity;
    }

    public void setMaxFuelCapacity(int maxFuelCapacity) {
        this.maxFuelCapacity = maxFuelCapacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public int getMaxFuelLevel() {
        return maxFuelLevel;
    }

    public void setMaxFuelLevel(int maxFuelLevel) {
        this.maxFuelLevel = maxFuelLevel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void move() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write distance");
        int distance = sc.nextInt();
        if (speed == 0) {
            System.out.println("Write your speed");
            speed = sc.nextInt();
            if (speed > maxSpeed) {
                speed = maxSpeed;
            }
        }
        if (speed != 0) {
            if (fuelLevel >= fuelConsumption * distance) {
                fuelLevel -= fuelConsumption * distance;
                System.out.println("You slowly drove this distance for " + (double) distance / speed + " hours with " +
                        "speed " + speed);
                stop();
            } else {
                System.out.println("You fuel level is low");
            }

        } else {
            System.out.println("Your speed is low");
        }

    }

    @Override
    public void stop() {
        this.speed = 0;
        System.out.println("You stopped the driving and your speed is " + speed);
    }


}
