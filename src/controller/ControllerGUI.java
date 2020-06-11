package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.ModelGUI;
import view.MainPaneView.*;
import view.ViewGUI;

public class ControllerGUI {
    private ModelGUI theModel;
    private ViewGUI theView;

    public ControllerGUI(ModelGUI model, ViewGUI view) {
        theModel = model;
        theView = view;
        assignAllEvents();
    }

    private void assignAllEvents() {
        eventForAddBallotBoxButton();
        eventForAddCandidateButton();
        eventForAddCitizenButton();
        eventForAddPartyButton();
        eventForBeginElectionButton();
        eventForShowBallotBoxesButton();
        eventForShowCitizensButton();
        eventForShowPartiesButton();
        eventForShowResultsButton();
    }

    private void eventForAddBallotBoxButton() {
        EventHandler<ActionEvent> eventForAddBallotBoxButton = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                theView.update(new AddBallotBox());
            }
        };
        theView.getMenuButtons().addEventHandlerToAddBallotBoxButton(eventForAddBallotBoxButton);
    }

    private void eventForAddCandidateButton() {
        EventHandler<ActionEvent> eventForAddCandidateButton = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                theView.update(new AddCandidate());
            }
        };
        theView.getMenuButtons().addEventHandlerToAddCandidateButton(eventForAddCandidateButton);
    }

    private void eventForAddCitizenButton() {
        EventHandler<ActionEvent> eventForAddCitizenButton = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                theView.update(new AddCitizen());
            }
        };
        theView.getMenuButtons().addEventHandlerToAddCitizenButton(eventForAddCitizenButton);
    }

    private void eventForAddPartyButton() {
        EventHandler<ActionEvent> eventForAddPartyButton = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                theView.update(new AddParty());
            }
        };
        theView.getMenuButtons().addEventHandlerToAddPartyButton(eventForAddPartyButton);
    }

    private void eventForBeginElectionButton() {
        EventHandler<ActionEvent> eventForBeginElectionButton = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                theView.update(new BeginElections());
            }
        };
        theView.getMenuButtons().addEventHandlerToBeginElectionsButton(eventForBeginElectionButton);
    }

    private void eventForShowBallotBoxesButton() {
        EventHandler<ActionEvent> eventForShowBallotBoxesButton = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                theView.update(new ShowBallotBoxes());
            }
        };
        theView.getMenuButtons().addEventHandlerToShowAllBallotBoxesButton(eventForShowBallotBoxesButton);
    }

    private void eventForShowCitizensButton() {
        EventHandler<ActionEvent> eventForShowCitizensButton = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                theView.update(new ShowCitizens());
            }
        };
        theView.getMenuButtons().addEventHandlerToShowAllCitizensButton(eventForShowCitizensButton);
    }

    private void eventForShowResultsButton() {
        EventHandler<ActionEvent> eventForShowResultsButton = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                theView.update(new ShowResults());
            }
        };
        theView.getMenuButtons().addEventHandlerToShowResultsButton(eventForShowResultsButton);
    }

    private void eventForShowPartiesButton() {
        EventHandler<ActionEvent> eventForShowPartiesButton = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                theView.update(new ShowParties());
            }
        };
        theView.getMenuButtons().addEventHandlerToShowAllPartiesButton(eventForShowPartiesButton);
    }
}
