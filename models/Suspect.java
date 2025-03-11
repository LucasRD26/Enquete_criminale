package models;

public class Suspect {
    private int id;
    private String nom;

    public Suspect(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}

