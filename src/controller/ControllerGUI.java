package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.ModelGUI;
import view.ViewGUI;
import view.menu.*;
import view.results.*;


public class ControllerGUI {

    private ModelGUI theModel;
    private ViewGUI theView;

    public ControllerGUI(ModelGUI model, ViewGUI view) {
        theModel = model;
        theView = view;

        eventForAddBallotBoxButton();
        eventForAddCitizen();
        eventForAddParty();
        eventForAddCandidate();
        eventForShowAllBallotBoxes();
        eventForShowAllCitizens();
        eventForShowAllParties();
        eventForBeginElections();
        eventForShowResults();
    }

    private void eventForAddBallotBoxButton() {
        EventHandler<ActionEvent> eventForAddBallotBoxButton = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                BallotBoxMenu ballotBoxMenu = new BallotBoxMenu(new Stage());
            }
        };
        theView.addEventHandlerToAddBallotBoxButton(eventForAddBallotBoxButton);
    }

    private void eventForAddCitizen() {
        EventHandler<ActionEvent> eventForAddCitizen = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                CitizenMenu citizenMenu = new CitizenMenu(new Stage());
            }
        };
        // TODO: assign all event handlers!
        theView.addEventHandlerToAddCitizen(eventForAddCitizen);
    }

    private void eventForAddParty() {
        EventHandler<ActionEvent> eventForAddParty = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                PartyMenu partyMenu = new PartyMenu(new Stage());
            }
        };
        theView.addEventHandlerToAddParty(eventForAddParty);
    }

    private void eventForAddCandidate() {
        EventHandler<ActionEvent> eventForAddCandidate = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                CandidateMenu candidateMenu = new CandidateMenu(new Stage());
            }
        };
        theView.addEventHandlerToAddCandidate(eventForAddCandidate);
    }

    private void eventForShowAllBallotBoxes() {
        EventHandler<ActionEvent> eventForShowAllBallotBoxes = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                ShowBallotBoxes showBallotBoxes = new ShowBallotBoxes(new Stage());
            }
        };
        theView.addEventHandlerToShowAllBallotBoxes(eventForShowAllBallotBoxes);
    }

    private void eventForShowAllCitizens() {
        EventHandler<ActionEvent> eventForShowAllCitizens = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                ShowCitizens showCitizens = new ShowCitizens(new Stage());
            }
        };
        theView.addEventHandlerToShowAllCitizens(eventForShowAllCitizens);
    }

    private void eventForShowAllParties() {
        EventHandler<ActionEvent> eventForShowAllParties = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                ShowParties showParties = new ShowParties(new Stage());
            }
        };
        theView.addEventHandlerToShowAllParties(eventForShowAllParties);
    }

    private void eventForBeginElections() {
        EventHandler<ActionEvent> eventForBeginElections = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                BeginElections beginElections = new BeginElections(new Stage());
            }
        };
        theView.addEventHandlerToBeginElections(eventForBeginElections);
    }

    private void eventForShowResults() {
        EventHandler<ActionEvent> eventForShowResults = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0) {
                ShowResults showResults = new ShowResults(new Stage());
            }
        };
        theView.addEventHandlerToShowResults(eventForShowResults);
    }
}
