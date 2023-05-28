package iate.java.model;

public class Filter {
    private String vin = "";
    private String brand = "";
    private String model = "";
    private int yearFrom = 0;
    private int yearTo = 0;

    public int getYearFrom() {
        return yearFrom;
    }

    public int getYearTo() {
        return yearTo;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }
}
