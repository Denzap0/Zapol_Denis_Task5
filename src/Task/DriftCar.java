package Task;

import java.util.Date;
import java.util.Scanner;

public class DriftCar extends Car {

    private final int tireConsumption = 15; //for 1 km
    private int maxSpeed, fuelLevel, maxFuelLevel, speed, tireResidue, wheelsEversion;// eversion in degrees
    private double fuelConsumption; // for 1 km
    private Season season;

    DriftCar() {
        super();
        model = Model.BMW;
        maxSpeed = 250;
        maxFuelLevel = 60;
        fuelLevel = maxFuelLevel;
        fuelConsumption = 0.15;
        speed = 0;
        tireResidue = 100;
        wheelsEversion = 55;
        season = Season.SUMMER;
    }

    DriftCar(String colour, int serialNum, Date date, Model model, boolean state, int acceleration, int maxSpeed,
             int speed, int fuelLevel, int maxFuelLevel, double fuelConsumption, int wheelsEversion, int tireResidue,
             Season season) {
        super(colour, serialNum, date, model, state);
        this.maxSpeed = maxSpeed;
        this.fuelLevel = fuelLevel;
        this.maxFuelLevel = maxFuelLevel;
        this.fuelConsumption = fuelConsumption;
        this.wheelsEversion = wheelsEversion;
        this.tireResidue = tireResidue;
        this.season = season;
    }

    private void burnout(int minutes) {
        if (tireResidue < tireConsumption * season.adhesionCoef * minutes) {
            System.out.println("You can not do burnout this amount of time");
        } else {
            tireResidue -= tireConsumption * season.adhesionCoef * minutes;
            System.out.println("Burnout is done");
        }
    }

    public void drift(int distance, int angle) {
        if (tireConsumption * season.adhesionCoef * distance > tireResidue || this.wheelsEversion < angle) {
            if (tireConsumption * season.adhesionCoef * distance > tireResidue &&
                    tireConsumption * season.adhesionCoef * distance < 100) {
                System.out.println("You should change you tires");
            } else if (this.wheelsEversion < angle) {
                System.out.println("You should make your wheels eversion better");
            } else {
                System.out.println("Your tires residue can not make drift in this distance");
            }
        } else {
            tireResidue -= tireConsumption * season.adhesionCoef * distance;
            System.out.println("You`ve got drift in this distance");
        }
    }

    public void refueling(int capacity) {
        fuelLevel = Math.min(fuelLevel + capacity, maxFuelLevel);
    }

    public void tireChange() {
        this.tireResidue = 100;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTireResidue() {
        return tireResidue;
    }

    public void setTireResidue(int tireResidue) {
        this.tireResidue = tireResidue;
    }

    public int getWheelsEversion() {
        return wheelsEversion;
    }

    public void setWheelsEversion(int wheelsEversion) {
        this.wheelsEversion = wheelsEversion;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
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
                System.out.println("You drove this distance for " + (double) distance / speed + " hours with speed " + speed);
                stop();
            } else {
                System.out.println("You fuel level is low");
            }

        } else {
            System.out.println("Your can not drive, your speed is 0 km/h");
        }

    }

    @Override
    public void stop() {
        this.speed = 0;
        System.out.println("You stopped the driving and your speed is " + speed);
    }

}
