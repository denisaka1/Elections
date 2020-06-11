package view.MainPaneView;

import javafx.scene.layout.VBox;
import view.MainPane;

public class ShowBallotBoxes extends MainPane {
    public ShowBallotBoxes() {
        super();
        setHeadline();
    }

    private void setHeadline() {
        headline.setText("Show All Ballot Boxes");
    }

    public VBox update() {
        return null;
    }
}
