package iate.java.model;

public enum CarShape {
    SEDAN("Седан"),
    HATCHBACK("Хэтчбек"),
    UNIVERSAL("Универсал"),
    COUPE("Купе"),
    SUV("Внедорожник");

    private final String title;

    public String getTitle() {
        return title;
    }

    CarShape(String title) {
        this.title = title;
    }
}
