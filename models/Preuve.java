package models;

public class Preuve {
    private int id;
    private String description;

    public Preuve(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}

