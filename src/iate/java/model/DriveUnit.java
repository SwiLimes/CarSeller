package iate.java.model;

public enum DriveUnit {
    FRONT("Передний"),
    BACK("Задний"),
    FULL("Полный");

    public String getTitle() {
        return title;
    }

    private final String title;

    DriveUnit(String title) {
        this.title = title;
    }


}
