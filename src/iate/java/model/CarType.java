package iate.java.model;

public enum CarType {
    NEW("Новая"),
    USED("Подержанная");

    private final String title;

    CarType(String title) {
        this.title = title;
    }
}
