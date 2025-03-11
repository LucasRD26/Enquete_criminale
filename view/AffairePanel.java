package view;

import java.awt.*;

public class AffairePanel extends Panel {
    private TextArea affaireInfo;

    public AffairePanel() {
        this.setLayout(new BorderLayout());
        affaireInfo = new TextArea(10, 20);
        this.add(affaireInfo, BorderLayout.CENTER);
    }

    public void setAffaireInfo(String info) {
        affaireInfo.setText(info);
    }
}

