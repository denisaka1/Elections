package view.MainPaneView;

import javafx.scene.layout.VBox;
import view.MainPane;

public class ShowCitizens extends MainPane {
    public ShowCitizens() {
        super();
        setHeadline();
    }

    private void setHeadline() {
        headline.setText("Show All Citizens");
    }

    public VBox update() {
        return null;
    }
}
