package Task;

public class Main {

    public static void main(String[] args) {
        Car car1 = new DriftCar();
        car1.move();
        DriftCar car2 = new DriftCar();
        car2.move();
        car2.refueling(50);
        car2.drift(5, 55);
        Car car3 = new GasolineTanker();
        car3.move();
        GasolineTanker car4 = new GasolineTanker();
        car4.move();
        car4.fuelFill(400);
        car4.fuelDrain(400);
        System.out.println(car4.getFuelCapacity());
        Movable anim1 = new Guepard();
        anim1.move();
        Guepard anim2 = new Guepard();
        anim2.move();
        anim2.sleep();
        Movable anim3 = new Eagle();
        anim3.move();
        Eagle anim4 = new Eagle();
        anim4.setFlightSpeed(240);
        anim4.setFlightAltitude(100);
        anim4.move();
    }
}
