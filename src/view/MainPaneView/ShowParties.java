package view.MainPaneView;

import javafx.scene.layout.VBox;
import view.MainPane;

public class ShowParties extends MainPane {
    public ShowParties() {
        super();
        setHeadline();
    }

    private void setHeadline() {
        headline.setText("Show All Parties");
    }

    public VBox update() {
        return null;
    }
}
