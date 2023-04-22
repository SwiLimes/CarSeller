package iate.java.model;

public class Car {
    private final String VIN;
    private String consumption;
    private String year;
    private Model model;
    private Engine engine;
    private CarType type;
    private CarShape shape;
    private DriveUnit driveUnit;
    private Transmission transmission;

    public Car(String VIN) {
        this.VIN = VIN;
    }

}
