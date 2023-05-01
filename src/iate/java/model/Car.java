package iate.java.model;

public class Car {
    private final String VIN;
    private String consumption;
    private String year;
    private Brand model;
    private Engine engine;
    private CarType type;
    private CarShape shape;
    private DriveUnit driveUnit;
    private Transmission transmission;

    public CarShape getShape() {
        return shape;
    }

    public CarType getType() {
        return type;
    }

    public Brand getModel() {
        return model;
    }

    public DriveUnit getDriveUnit() {
        return driveUnit;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getConsumption() {
        return consumption;
    }

    public String getVIN() {
        return VIN;
    }

    public String getYear() {
        return year;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Car(String VIN) {
        this.VIN = VIN;
    }

}
