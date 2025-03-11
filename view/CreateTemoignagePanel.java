package view;

import java.awt.*;
import java.awt.event.*;

import controllers.TemoignageController;

public class CreateTemoignagePanel extends Panel {
    private TextField contenuField;
    private Button createButton;
    private TemoignageController temoignageController;

    public CreateTemoignagePanel() {
        this.setLayout(new FlowLayout());
        contenuField = new TextField(15);
        createButton = new Button("Créer Témoignage");

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al controlador para crear un nuevo testimonio
                temoignageController.createTemoignage(contenuField.getText());
                contenuField.setText(""); // Limpiar campo
            }
        });

        this.add(new Label("Contenu:"));
        this.add(contenuField);
        this.add(createButton);
    }

    public void setTemoignageController(TemoignageController temoignageController) {
        this.temoignageController = temoignageController;
    }
}