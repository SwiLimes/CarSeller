package iate.java.model;

public class Car {
    private final String vin;
    private final String brandName;
    private final String modelName;
    private final String year;
    private String consumption;
    private Brand model;
    private Engine engine;
    //private CarType type;

    private CarType type;
    private CarShape shape;
    private DriveUnit driveUnit;
    private Transmission transmission;

    public String getVin() {
        return vin;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public String getYear() {
        return year;
    }

//    public CarType getType() {
//        return type;
//    }
//
//    public Engine getEngine() {
//        return engine;
//    }
//
//    public CarShape getShape() {
//        return shape;
//    }
//
//    public DriveUnit getDriveUnit() {
//        return driveUnit;
//    }
//
//    public Transmission getTransmission() {
//        return transmission;
//    }
//
//    public String getEquipment() {
//        return equipment;
//    }
//
//    public double getConsumption() {
//        return consumption;
//    }
//
//    public double getClearance() {
//        return clearance;
//    }

    public Car(String vin, String brandName, String modelName, String year) {
//               CarType type, Engine engine, CarShape shape, DriveUnit driveUnit, Transmission transmission,
//               String equipment, double consumption, double clearance) {
        this.vin = vin;
        this.brandName = brandName;
        this.modelName = modelName;
        this.year = year;
//        this.type = type;
//        this.engine = engine;
//        this.shape = shape;
//        this.driveUnit = driveUnit;
//        this.transmission = transmission;
//        this.equipment = equipment;
//        this.consumption = consumption;
//        this.clearance = clearance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!vin.equals(car.vin)) return false;
        if (!brandName.equals(car.brandName)) return false;
        if (!modelName.equals(car.modelName)) return false;
        return year.equals(car.year);
//        if (type != car.type) return false;
//        if (engine != car.engine) return false;
//        if (shape != car.shape) return false;
//        if (driveUnit != car.driveUnit) return false;
//        if (transmission != car.transmission) return false;
//        if (!equipment.equals(car.equipment)) return false;
//        if (!consumption.equals(car.consumption)) return false;
//        return clearance.equals(car.clearance);
    }

    @Override
    public int hashCode() {
        int result = vin.hashCode();
        result = 31 * result + brandName.hashCode();
        result = 31 * result + modelName.hashCode();
        result = 31 * result + year.hashCode();
//        result = 31 * result + type.hashCode();
//        result = 31 * result + engine.hashCode();
//        result = 31 * result + shape.hashCode();
//        result = 31 * result + driveUnit.hashCode();
//        result = 31 * result + transmission.hashCode();
//        result = 31 * result + equipment.hashCode();
//        result = 31 * result + consumption.hashCode();
//        result = 31 * result + clearance.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", year='" + year + '\'' +
//                ", type=" + type +
//                ", engine=" + engine +
//                ", shape=" + shape +
//                ", driveUnit=" + driveUnit +
//                ", transmission=" + transmission +
//                ", equipment='" + equipment + '\'' +
//                ", consumption='" + consumption + '\'' +
//                ", clearance='" + clearance + '\'' +
                '}';
    }
}
