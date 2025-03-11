package view;

import java.awt.*;
import java.awt.event.*;

import controllers.AffaireController;
import controllers.SearchController;

// SearchPanel.java


public class SearchPanel extends Panel {
    private TextField searchField;
    private Button searchButton;
    private SearchController searchController;

    public SearchPanel(AffaireController affaireController, AffairePanel affairePanel) {
        this.setLayout(new FlowLayout());
        searchField = new TextField(15);
        searchButton = new Button("Rechercher");

        // Instanciar el controlador de búsqueda
        searchController = new SearchController(affaireController, affairePanel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al controlador para realizar la búsqueda
                String query = searchField.getText();
                searchController.search(query);
            }
        });

        this.add(searchField);
        this.add(searchButton);
    }
}

