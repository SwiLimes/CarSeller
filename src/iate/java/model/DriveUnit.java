package iate.java.model;

public enum DriveUnit {
    FRONT("Передний"),
    BACK("Задний"),
    FULL("Полный");

    private final String title;

    DriveUnit(String title) {
        this.title = title;
    }


}
