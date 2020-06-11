package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ModelGUI;
import view.MainPaneView.*;
import view.ViewGUI;

public class ControllerGUI {
    private ModelGUI theModel;
    private ViewGUI theView;
    private Stage dialog;
    private VBox dialogVBox;

    public ControllerGUI(ModelGUI model, ViewGUI view) {
        theModel = model;
        theView = view;
        assignAllEvents();
        dialog();
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
        eventCloseButton();
        eventHelpButton();
        eventMainButton();
        eventAboutButton();
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

    private void eventCloseButton() {
        EventHandler<ActionEvent> eventCloseButton = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        };
        theView.addEventCloseButton(eventCloseButton);
    }

    private void eventMainButton() {
        EventHandler<ActionEvent> eventMainButton = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                theView.update(new Main());
            }
        };
        theView.addEventMainButton(eventMainButton);
    }

    private void eventHelpButton() {
        EventHandler<ActionEvent> eventHelpButton = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                helpDialog();
            }
        };
        theView.addEventHelpButton(eventHelpButton);
    }

    private void eventAboutButton() {
        EventHandler<ActionEvent> eventAboutButton = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                aboutDialog();
            }
        };
        theView.addEventAboutButton(eventAboutButton);
    }

    private void dialog() {
        dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialogVBox = new VBox(20);
        Scene dialogScene = new Scene(dialogVBox, 300, 200);
        dialog.setScene(dialogScene);
    }

    private void aboutDialog() {
        dialogVBox.getChildren().clear();
        dialogVBox.getChildren().add(new Text("About"));
        dialog.show();
    }

    private void helpDialog() {
        dialogVBox.getChildren().clear();
        dialogVBox.getChildren().add(new Text("Help"));
        dialog.show();
    }
}
