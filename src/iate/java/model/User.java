package iate.java.model;

public class User {
    private final Integer id;
    private final String name;
    private final String surname;
    private final String pass;


    public User(Integer id, String name, String surname, String pass) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPass() {
        return pass;
    }
}
