package view;

import java.awt.*;
import java.awt.event.*;

import controllers.SuspectController;

public class CreateSuspectPanel extends Panel {
    private TextField nomField;
    private Button createButton;
    private SuspectController suspectController;

    public CreateSuspectPanel() {
        this.setLayout(new FlowLayout());
        nomField = new TextField(15);
        createButton = new Button("Créer Suspect");

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al controlador para crear un nuevo sospechoso
                suspectController.createSuspect(nomField.getText());
                nomField.setText(""); // Limpiar campo
            }
        });

        this.add(new Label("Nom:"));
        this.add(nomField);
        this.add(createButton);
    }

    public void setSuspectController(SuspectController suspectController) {
        this.suspectController = suspectController;
    }
}

