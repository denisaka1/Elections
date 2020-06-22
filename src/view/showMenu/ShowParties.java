package view.showMenu;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Party;

import java.util.HashMap;

public class ShowParties extends Main {
    // FIXME: add scrollPane

    private HashMap<Party, Integer> allParties;

    public ShowParties(HashMap<Party, Integer> parties) {
        super();
        allParties = parties;
        setHeadline("Show All Parties");
    }

    private void assignParties() {
        Text text;
        for(Party party: allParties.keySet()) {
            text = new Text(party.toString());
            scrollPaneVB.getChildren().add(text);
        }
    }

    @Override
    public VBox update() {
        super.update();
        assignParties();
        assignScrollPane();

        return mainView;
    }
}
