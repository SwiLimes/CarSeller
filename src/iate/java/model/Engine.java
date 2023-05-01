package iate.java.model;

public enum Engine {
    PETROL("Бензин"),
    DIESEL("Дизель"),
    ELECTRIC("Электро"),
    GAS("Газовый");

    private final String title;


    public String getTitle() {
        return title;
    }

    Engine(String title) {
        this.title = title;
    }
}
