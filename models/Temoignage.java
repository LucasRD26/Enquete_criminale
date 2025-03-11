package models;

public class Temoignage {
    private int id;
    private String contenu;

    public Temoignage(int id, String contenu) {
        this.id = id;
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }
}
