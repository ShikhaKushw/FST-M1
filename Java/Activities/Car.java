package activities;


public class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int noOfDoors;

    Car() {
        tyres=4;
        noOfDoors = 4;
    }
    public void displayCharacteristics() {
        System.out.println("Color of car: " + color);
        System.out.println("transmission of car: " + transmission);
        System.out.println("make year of car: " + make);
        System.out.println("No. of tyres of car: " + tyres);
        System.out.println("noOfDoors of car: " + noOfDoors);
    }
    public void accelerate() {
        System.out.println("Car is moving forward.");
    }

    public void brake() {
        System.out.println("Car has stopped.");
    }
}
