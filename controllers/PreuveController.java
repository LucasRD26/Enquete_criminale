package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Preuve;

public class PreuveController {
    private Map<Integer, Preuve> preuves;

    public PreuveController() {
        this.preuves = new HashMap<>();
    }

    public void createPreuve(String description) {
        int id = preuves.size() + 1; // Generar un ID único
        Preuve preuve = new Preuve(id, description);
        preuves.put(id, preuve);
    }

    public Preuve getPreuve(int id) {
        return preuves.get(id);
    }

    public List<Preuve> getPreuves() {
        return new ArrayList<>(preuves.values());
    }
}
