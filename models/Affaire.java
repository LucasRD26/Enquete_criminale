package models;

import java.util.List;
import java.util.ArrayList;



public class Affaire {
    private int id;
    private String description;
    private String etatAvancement;
    private List<Suspect> suspects;
    private List<Temoignage> temoignages;
    private List<Preuve> preuves;

    public Affaire(int id, String description, String etatAvancement) {
        this.id = id;
        this.description = description;
        this.etatAvancement = etatAvancement;
        this.suspects = new ArrayList<>();
        this.temoignages = new ArrayList<>();
        this.preuves = new ArrayList<>();
    }

    public void addSuspect(Suspect suspect) {
        this.suspects.add(suspect);
    }

    public void addTemoignage(Temoignage temoignage) {
        this.temoignages.add(temoignage);
    }

    public void addPreuve(Preuve preuve) {
        this.preuves.add(preuve);
    }

    public String getDescription() {
        return description;
    }

    public String getEtatAvancement() {
        return etatAvancement;
    }

    public int getId() {
        return id;
    }

    public List<Preuve> getPreuves() {
        return preuves;
    }

    public List<Suspect> getSuspects() {
        return suspects;
    }

    public List<Temoignage> getTemoignages() {
        return temoignages;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtatAvancement(String etatAvancement) {
        this.etatAvancement = etatAvancement;
    }

    public void setId(int id) {
        this.id = id;
    }
}