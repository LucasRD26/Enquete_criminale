package view;

import java.awt.*;
import java.awt.event.*;

import controllers.AffaireController;
import controllers.PreuveController;
import controllers.SuspectController;
import controllers.TemoignageController;

// MainWindow.java
public class MainWindow extends Frame {
    private AffairePanel affairePanel;
    private SearchPanel searchPanel;
    private CreateAffairePanel createAffairePanel;
    private CreateSuspectPanel createSuspectPanel;
    private CreateTemoignagePanel createTemoignagePanel;
    private CreatePreuvePanel createPreuvePanel;
    private AffaireController affaireController;
    private SuspectController suspectController;
    private TemoignageController temoignageController;
    private PreuveController preuveController;

    public MainWindow() {
        super("Gestion des Affaires Criminelles");
        this.setLayout(new BorderLayout());

        affairePanel = new AffairePanel();
        affaireController = new AffaireController();
        
        searchPanel = new SearchPanel(affaireController, affairePanel); // Pasar referencias al panel de búsqueda
        createAffairePanel = new CreateAffairePanel();
        createAffairePanel.setAffaireController(affaireController);
        
        suspectController = new SuspectController();
        createSuspectPanel = new CreateSuspectPanel();
        createSuspectPanel.setSuspectController(suspectController);
        
        temoignageController = new TemoignageController();
        createTemoignagePanel = new CreateTemoignagePanel();
        createTemoignagePanel.setTemoignageController(temoignageController);
        
        preuveController = new PreuveController();
        createPreuvePanel = new CreatePreuvePanel();
        createPreuvePanel.setPreuveController(preuveController);
        
        createAffairePanel.setSuspectController(suspectController);
        createAffairePanel.setTemoignageController(temoignageController);
        createAffairePanel.setPreuveController(preuveController);

        UpdateAffairePanel updateAffairePanel = new UpdateAffairePanel();
        updateAffairePanel.setAffaireController(affaireController);
        updateAffairePanel.setSuspectController(suspectController);
        updateAffairePanel.setTemoignageController(temoignageController);
        updateAffairePanel.setPreuveController(preuveController);

        

        this.add(affairePanel, BorderLayout.CENTER);
        this.add(searchPanel, BorderLayout.NORTH);
        this.add(createAffairePanel, BorderLayout.SOUTH);
        this.add(updateAffairePanel, BorderLayout.WEST);

        // Panel lateral para crear nuevos elementos
        Panel sidePanel = new Panel();
        sidePanel.setLayout(new GridLayout(3, 1));
        sidePanel.add(createSuspectPanel);
        sidePanel.add(createTemoignagePanel);
        sidePanel.add(createPreuvePanel);

        this.add(sidePanel, BorderLayout.EAST);

        // Manejar el cierre de la ventana
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); // Salir del programa al cerrar la ventana
            }
        });

        this.pack();
        this.setVisible(true);
    }
}

