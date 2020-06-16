package view.MainPaneView;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.ViewGUI;

public class AssignCandidate extends MainPane {
    private HBox hbParty, hbCitizen;
    private ComboBox parties, citizens;

    public AssignCandidate() {
        super();
        setHeadline("Add Candidate to Party");
        setFields();
    }

    private void setFields() {
        setCitizenField();
        setPartyField();
    }

    private void setCitizenField() {
        hbCitizen = new HBox();
//        Text txtBallotBoxNumber = new Text("Choose Citizen :");
        citizens = new ComboBox();
        citizens.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        citizens.setPromptText("Choose Citizen");
        citizens.getItems().add("Citizen 1"); // FIXME: add all citizens
        citizens.getItems().add("Citizen 2");
        citizens.getItems().add("Citizen 3");

        citizens.getEditor().setFont(buttonsFont);
        hbCitizen.getChildren().addAll(citizens);
    }

    private void setPartyField() {
        hbParty = new HBox();
//        Text txtBallotBoxNumber = new Text("Choose Party :");
        parties = new ComboBox();
        parties.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        parties.setPromptText("Choose Party");
        parties.getItems().add("Party 1"); // FIXME: add all parties
        parties.getItems().add("Party 2");
        parties.getItems().add("Party 3");

        parties.getEditor().setFont(buttonsFont);
        hbParty.getChildren().addAll(parties);
    }

    @Override
    public VBox update() {
        super.update();
        mainView.getChildren().addAll(hbCitizen, hbParty, hbSubmit);
        mainView.setMargin(hbCitizen, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbParty, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbSubmit, new Insets(10, 0, 0, 20));

        return mainView;
    }
}
