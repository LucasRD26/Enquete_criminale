import controllers.AffaireController;
import controllers.PreuveController;
import controllers.SearchController;
import controllers.TemoignageController;
import controllers.SuspectController;
import view.MainWindow;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Crear controladores
        AffaireController affaireController = new AffaireController();
        SuspectController suspectController = new SuspectController();
        TemoignageController temoignageController = new TemoignageController();
        PreuveController preuveController = new PreuveController();

        // Configurar controladores
        affaireController.setSuspectController(suspectController);
        affaireController.setTemoignageController(temoignageController);
        affaireController.setPreuveController(preuveController);

        // Crear ventana principa
        MainWindow window = new MainWindow();
    }
}
