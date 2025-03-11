package view;

import java.awt.*;
import java.awt.event.*;

import controllers.AffaireController;
import controllers.PreuveController;
import controllers.SuspectController;
import controllers.TemoignageController;
import models.Affaire;
import models.Preuve;
import models.Suspect;
import models.Temoignage;

public class CreateAffairePanel extends Panel {
    private TextField descriptionField;
    private TextField etatAvancementField;
    private Choice suspectChoice;
    private Choice temoignageChoice;
    private Choice preuveChoice;
    private Button createButton;
    private AffaireController affaireController;
    private SuspectController suspectController;
    private TemoignageController temoignageController;
    private PreuveController preuveController;

    public CreateAffairePanel() {
        this.setLayout(new BorderLayout());

        // Panel superior para campos de texto
        Panel topPanel = new Panel();
        topPanel.setLayout(new GridLayout(5, 2));
        topPanel.add(new Label("Description:"));
        descriptionField = new TextField();
        topPanel.add(descriptionField);
        topPanel.add(new Label("État d'avancement:"));
        etatAvancementField = new TextField();
        topPanel.add(etatAvancementField);
        topPanel.add(new Label("Suspect:"));
        suspectChoice = new Choice();
        topPanel.add(suspectChoice);
        topPanel.add(new Label("Témoignage:"));
        temoignageChoice = new Choice();
        topPanel.add(temoignageChoice);
        topPanel.add(new Label("Preuve:"));
        preuveChoice = new Choice();
        topPanel.add(preuveChoice);

        // Panel inferior para botón
        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new FlowLayout());
        createButton = new Button("Créer Affaire");
        bottomPanel.add(createButton);

        this.add(topPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al controlador para crear una nueva investigación
                int id = affaireController.getAffaires().size() + 1; // Generar un ID único
                Affaire affaire = new Affaire(id, descriptionField.getText(), etatAvancementField.getText());
                if (suspectChoice.getSelectedItem() != null) {
                    int suspectId = Integer.parseInt(suspectChoice.getSelectedItem());
                    affaire.addSuspect(suspectController.getSuspect(suspectId));
                }
                if (temoignageChoice.getSelectedItem() != null) {
                    int temoignageId = Integer.parseInt(temoignageChoice.getSelectedItem());
                    affaire.addTemoignage(temoignageController.getTemoignage(temoignageId));
                }
                if (preuveChoice.getSelectedItem() != null) {
                    int preuveId = Integer.parseInt(preuveChoice.getSelectedItem());
                    affaire.addPreuve(preuveController.getPreuve(preuveId));
                }
                affaireController.createAffaire(affaire);
                // Limpiar campos
                descriptionField.setText("");
                etatAvancementField.setText("");
            }
        });
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
}
