package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Affaire;

public class AffaireController {
    private Map<Integer, Affaire> affaires;
    private SuspectController suspectController;
    private TemoignageController temoignageController;
    private PreuveController preuveController;

    public AffaireController() {
        this.affaires = new HashMap<>();
    }

    public void setSuspectController(SuspectController suspectController) {
        this.suspectController = suspectController;
    }

    public void setTemoignageController(TemoignageController temoignageController) {
        this.temoignageController = temoignageController;
    }

    public void setPreuveController(PreuveController preuveController) {
        this.preuveController = preuveController;
    }

    public void createAffaire(Affaire affaire) {
        affaires.put(affaire.getId(), affaire);
    }

    public void updateAffaire(int id, String description, String etatAvancement) {
        if (affaires.containsKey(id)) {
            Affaire affaire = affaires.get(id);
            affaire.setDescription(description);
            affaire.setEtatAvancement(etatAvancement);
        }
    }

    public void addSuspectToAffaire(int affaireId, int suspectId) {
        if (affaires.containsKey(affaireId) && suspectController.getSuspect(suspectId) != null) {
            Affaire affaire = affaires.get(affaireId);
            affaire.addSuspect(suspectController.getSuspect(suspectId));
        }
    }

    public void addTemoignageToAffaire(int affaireId, int temoignageId) {
        if (affaires.containsKey(affaireId) && temoignageController.getTemoignage(temoignageId) != null) {
            Affaire affaire = affaires.get(affaireId);
            affaire.addTemoignage(temoignageController.getTemoignage(temoignageId));
        }
    }

    public void addPreuveToAffaire(int affaireId, int preuveId) {
        if (affaires.containsKey(affaireId) && preuveController.getPreuve(preuveId) != null) {
            Affaire affaire = affaires.get(affaireId);
            affaire.addPreuve(preuveController.getPreuve(preuveId));
        }
    }

    public List<Affaire> searchAffaires(String query) {
        List<Affaire> results = new ArrayList<>();
        for (Affaire affaire : affaires.values()) {
            if (affaire.getDescription().toLowerCase().contains(query.toLowerCase()) ||
                affaire.getEtatAvancement().toLowerCase().contains(query.toLowerCase())) {
                results.add(affaire);
            }
        }
        return results;
    }

    public Map<Integer, Affaire> getAffaires() {
        return affaires;
    }

    public Affaire getAffaire(int id) {
        return affaires.get(id);
    }
}
