package iate.app.model;

public enum CarType {
    NEW("Новая"),
    USED("Подержанная");

    private final String title;

    CarType(String title) {
        this.title = title;
    }
}
