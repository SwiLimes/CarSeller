package iate.java.model;

public enum Transmission {
    AUTOMATIC("Автоматическая"),
    MANUAL("Ручная"),
    SEMI("Полуатомат");

    private final String title;

    public String getTitle() {
        return title;
    }

    Transmission(String title) {
        this.title = title;
    }
}
