package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Temoignage;

public class TemoignageController {
    private Map<Integer, Temoignage> temoignages;

    public TemoignageController() {
        this.temoignages = new HashMap<>();
    }

    public void createTemoignage(String contenu) {
        int id = temoignages.size() + 1; // Generar un ID único
        Temoignage temoignage = new Temoignage(id, contenu);
        temoignages.put(id, temoignage);
    }

    public Temoignage getTemoignage(int id) {
        return temoignages.get(id);
    }

    public List<Temoignage> getTemoignages() {
        return new ArrayList<>(temoignages.values());
    }
}
