package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import controllers.AffaireController;
import controllers.PreuveController;
import controllers.SuspectController;
import controllers.TemoignageController;
import models.Affaire;
import models.Preuve;
import models.Suspect;
import models.Temoignage;

public class UpdateAffairePanel extends Panel {
    private TextField affaireIdField;
    private Choice suspectChoice;
    private Choice temoignageChoice;
    private Choice preuveChoice;
    private Button addSuspectButton;
    private Button addTemoignageButton;
    private Button addPreuveButton;
    private AffaireController affaireController;
    private SuspectController suspectController;
    private TemoignageController temoignageController;
    private PreuveController preuveController;

    public UpdateAffairePanel() {
        this.setLayout(new FlowLayout());
        affaireIdField = new TextField(5);
        suspectChoice = new Choice();
        temoignageChoice = new Choice();
        preuveChoice = new Choice();
        addSuspectButton = new Button("Ajouter Suspect");
        addTemoignageButton = new Button("Ajouter Témoignage");
        addPreuveButton = new Button("Ajouter Preuve");

        addSuspectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al controlador para agregar un sospechoso
                int affaireId = Integer.parseInt(affaireIdField.getText());
                int suspectId = Integer.parseInt(suspectChoice.getSelectedItem());
                affaireController.addSuspectToAffaire(affaireId, suspectId);
            }
        });

        addTemoignageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al controlador para agregar un testimonio
                int affaireId = Integer.parseInt(affaireIdField.getText());
                int temoignageId = Integer.parseInt(temoignageChoice.getSelectedItem());
                affaireController.addTemoignageToAffaire(affaireId, temoignageId);
            }
        });

        addPreuveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al controlador para agregar una prueba
                int affaireId = Integer.parseInt(affaireIdField.getText());
                int preuveId = Integer.parseInt(preuveChoice.getSelectedItem());
                affaireController.addPreuveToAffaire(affaireId, preuveId);
            }
        });

        this.add(new Label("ID Affaire:"));
        this.add(affaireIdField);
        this.add(new Label("ID Suspect:"));
        this.add(suspectChoice);
        this.add(addSuspectButton);
        this.add(new Label("ID Témoignage:"));
        this.add(temoignageChoice);
        this.add(addTemoignageButton);
        this.add(new Label("ID Preuve:"));
        this.add(preuveChoice);
        this.add(addPreuveButton);

        refreshButton = new Button("Actualizar Opciones");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int affaireId = Integer.parseInt(affaireIdField.getText());
                updateChoices(affaireId);
            }
        });
        this.add(refreshButton);
    }

    public void setAffaireController(AffaireController affaireController) {
        this.affaireController = affaireController;
    }

    public void setSuspectController(SuspectController suspectController) {
        this.suspectController = suspectController;
        // Actualizar la lista de sospechosos
        for (Suspect suspect : suspectController.getSuspects()) {
            suspectChoice.add(String.valueOf(suspect.getId()));
        }
    }

    public void setTemoignageController(TemoignageController temoignageController) {
        this.temoignageController = temoignageController;
        // Actualizar la lista de testimonios
        for (Temoignage temoignage : temoignageController.getTemoignages()) {
            temoignageChoice.add(String.valueOf(temoignage.getId()));
        }
    }

    public void setPreuveController(PreuveController preuveController) {
        this.preuveController = preuveController;
        // Actualizar la lista de pruebas
        for (Preuve preuve : preuveController.getPreuves()) {
            preuveChoice.add(String.valueOf(preuve.getId()));
        }
    }

    public void updateChoices(int affaireId) {
        // Limpiar las opciones actuales
        suspectChoice.removeAll();
        temoignageChoice.removeAll();
        preuveChoice.removeAll();

        // Obtener los elementos no ligados al affaire
        List<Suspect> availableSuspects = getAvailableSuspects(affaireId);
        List<Temoignage> availableTemoignages = getAvailableTemoignages(affaireId);
        List<Preuve> availablePreuves = getAvailablePreuves(affaireId);

        // Agregar las opciones disponibles
        for (Suspect suspect : availableSuspects) {
            suspectChoice.add(String.valueOf(suspect.getId()));
        }
        for (Temoignage temoignage : availableTemoignages) {
            temoignageChoice.add(String.valueOf(temoignage.getId()));
        }
        for (Preuve preuve : availablePreuves) {
            preuveChoice.add(String.valueOf(preuve.getId()));
        }
    }

    private List<Suspect> getAvailableSuspects(int affaireId) {
        Affaire affaire = affaireController.getAffaire(affaireId);
        if (affaire == null) return new ArrayList<>();
        List<Suspect> allSuspects = suspectController.getSuspects();
        List<Suspect> existingSuspects = affaire.getSuspects();
        List<Suspect> availableSuspects = new ArrayList<>();
        for (Suspect suspect : allSuspects) {
            if (!existingSuspects.contains(suspect)) {
                availableSuspects.add(suspect);
            }
        }
        return availableSuspects;
    }

    private List<Temoignage> getAvailableTemoignages(int affaireId) {
        Affaire affaire = affaireController.getAffaire(affaireId);
        if (affaire == null) return new ArrayList<>();
        List<Temoignage> allTemoignages = temoignageController.getTemoignages();
        List<Temoignage> existingTemoignages = affaire.getTemoignages();
        List<Temoignage> availableTemoignages = new ArrayList<>();
        for (Temoignage temoignage : allTemoignages) {
            if (!existingTemoignages.contains(temoignage)) {
                availableTemoignages.add(temoignage);
            }
        }
        return availableTemoignages;
    }

    private List<Preuve> getAvailablePreuves(int affaireId) {
        Affaire affaire = affaireController.getAffaire(affaireId);
        if (affaire == null) return new ArrayList<>();
        List<Preuve> allPreuves = preuveController.getPreuves();
        List<Preuve> existingPreuves = affaire.getPreuves();
        List<Preuve> availablePreuves = new ArrayList<>();
        for (Preuve preuve : allPreuves) {
            if (!existingPreuves.contains(preuve)) {
                availablePreuves.add(preuve);
            }
        }
        return availablePreuves;
    }
    private Button refreshButton;

    
}
