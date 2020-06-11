package view.MainPaneView;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.MainPane;
import view.ViewGUI;

public class AddCandidate extends MainPane {
    private HBox hbParty, hbCitizen;
    private ComboBox parties, citizens;

    public AddCandidate() {
        super();
        setHeadline();
        setFields();
    }

    private void setHeadline() {
        headline.setText("Add Candidate to Party");
    }

    private void setFields() {
        setCitizenField();
        setPartyField();
        createSubmitButton();
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
        citizens.setStyle("-fx-font: 14px \"Tahoma\";");
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
        parties.setStyle("-fx-font: 14px \"Tahoma\";");
        hbParty.getChildren().addAll(parties);
    }

    @Override
    public VBox update() {
        mainView.getChildren().clear();
        mainView.getChildren().addAll(headline, hbCitizen, hbParty, hbSubmit);
        mainView.setMargin(headline, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbCitizen, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbParty, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbSubmit, new Insets(10, 0, 0, 20));
        return mainView;
    }
}
