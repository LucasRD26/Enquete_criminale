package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Suspect;

public class SuspectController {
    private Map<Integer, Suspect> suspects;

    public SuspectController() {
        this.suspects = new HashMap<>();
    }

    public void createSuspect(String nom) {
        int id = suspects.size() + 1; // Generar un ID único
        Suspect suspect = new Suspect(id, nom);
        suspects.put(id, suspect);
    }

    public Suspect getSuspect(int id) {
        return suspects.get(id);
    }

    public List<Suspect> getSuspects() {
        return new ArrayList<>(suspects.values());
    }
}
