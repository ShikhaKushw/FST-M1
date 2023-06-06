package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car Honda = new Car();
        Honda.color= "Blue";
        Honda.make = 2014;
        Honda.transmission="Manual";
        Honda.displayCharacteristics();
        Honda.accelerate();
        Honda.brake();

    }
}
