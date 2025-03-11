package controllers;

import models.Affaire;
import view.AffairePanel;

import java.util.List;

public class SearchController {
    private AffaireController affaireController;
    private AffairePanel affairePanel; // Referencia a la vista para mostrar resultados

    public SearchController(AffaireController affaireController, AffairePanel affairePanel) {
        this.affaireController = affaireController;
        this.affairePanel = affairePanel;
    }

    public void search(String query) {
        // Buscar las investigaciones que coincidan con el criterio
        List<Affaire> results = affaireController.searchAffaires(query);

        // Construir la información de los resultados
        StringBuilder info = new StringBuilder();
        if (results.isEmpty()) {
            info.append("No se encontraron resultados para: ").append(query);
        } else {
            for (Affaire affaire : results) {
                info.append("ID: ").append(affaire.getId()).append("\nDescription: ").append(affaire.getDescription())
                    .append("\nÉtat d'avancement: ").append(affaire.getEtatAvancement()).append("\n\n");
            }
        }

        // Actualizar la vista con los resultados
        affairePanel.setAffaireInfo(info.toString());
    }
}

