package iate.java.model;

public enum Engine {
    PETROL("Бензин"),
    DIESEL("Дизель"),
    ELECTRIC("Электро"),
    GAS("Газовый");

    private final String title;

    Engine(String title) {
        this.title = title;
    }
}
