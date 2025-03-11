package view;

import java.awt.*;
import java.awt.event.*;

import controllers.PreuveController;

public class CreatePreuvePanel extends Panel {
    private TextField descriptionField;
    private Button createButton;
    private PreuveController preuveController;

    public CreatePreuvePanel() {
        this.setLayout(new FlowLayout());
        descriptionField = new TextField(15);
        createButton = new Button("Créer Preuve");

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al controlador para crear una nueva prueba
                preuveController.createPreuve(descriptionField.getText());
                descriptionField.setText(""); // Limpiar campo
            }
        });

        this.add(new Label("Description:"));
        this.add(descriptionField);
        this.add(createButton);
    }

    public void setPreuveController(PreuveController preuveController) {
        this.preuveController = preuveController;
    }
}
