package view.MainPaneView;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Party;
import model.VoterRegister;
import model.citizens.Citizen;
import view.ViewGUI;

import java.util.HashMap;

public class AssignCandidate extends MainPane {
    private HBox hbParty, hbCitizen;
    private ComboBox parties, citizens;
    private VoterRegister vr;
    private HashMap<Party, Integer> allParties;

    public AssignCandidate(VoterRegister vr, HashMap<Party, Integer> allParties) {
        super();
        this.vr = vr;
        this.allParties = allParties;
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
        Citizen citizen;
        for(int i = 0; i < vr.getCitizens().size(); i++) {
            citizen = vr.getCitizens().get(i);
            citizens.getItems().add(citizen.getID() + " - " + citizen.getName());
        }
/*        citizens.getItems().add("Citizen 1"); // FIXME: add all citizens
        citizens.getItems().add("Citizen 2");
        citizens.getItems().add("Citizen 3");*/

        citizens.getEditor().setFont(buttonsFont);
        hbCitizen.getChildren().addAll(citizens);
    }

    private void setPartyField() {
        hbParty = new HBox();
//        Text txtBallotBoxNumber = new Text("Choose Party :");
        parties = new ComboBox();
        parties.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        parties.setPromptText("Choose Party");

        for(Party party: allParties.keySet()) {
            parties.getItems().add(party.getName() + " - " + party.getSection());
        }
/*        parties.getItems().add("Party 1"); // FIXME: add all parties
        parties.getItems().add("Party 2");
        parties.getItems().add("Party 3");*/

        parties.getEditor().setFont(buttonsFont);
        hbParty.getChildren().addAll(parties);
    }

    public String getCitizenID() {
        return citizens.getSelectionModel().getSelectedItem().toString();
    }

    public String getPartyName() {
        return parties.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public VBox update() {
        super.update();
        mainView.getChildren().addAll(hbCitizen, hbParty, hbSubmit);
        mainView.setMargin(hbCitizen, ViewGUI.DEFAULT_INSETS);
        mainView.setMargin(hbParty, ViewGUI.DEFAULT_INSETS);
        mainView.setMargin(hbSubmit, ViewGUI.DEFAULT_INSETS);

        return mainView;
    }
}
