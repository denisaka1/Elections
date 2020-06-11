package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MenuButtons {
    private Button addBallotBox, addCitizens, addParty, addCandidate,
            showAllBallotBoxes, showAllCitizens, showAllParties,
            beginElections, showResults;
    private String borderStyle;

    public MenuButtons(BorderPane borderPane) {
        assignButtons();
        VBox interfaceMenu = new VBox(ViewGUI.SPACING);

        borderStyle = "-fx-border-color: #808080;\n" +
                "-fx-border-width: 0 1 0 0;\n" +
                "-fx-border-style: solid;\n";

        interfaceMenu.setStyle(borderStyle);

        Text menuText = new Text("Menu");
        menuText.setFont(Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 16));

        interfaceMenu.setAlignment(Pos.TOP_CENTER);
        interfaceMenu.setPrefWidth(200);

        interfaceMenu.getChildren().addAll(menuText, addBallotBox, addCitizens, addParty, addCandidate,
                showAllBallotBoxes, showAllCitizens, showAllParties,
                beginElections, showResults);
        interfaceMenu.setMargin(beginElections, new Insets(130, 0, 0, 0));
        interfaceMenu.setMargin(menuText, new Insets(10, 0, 0, -135));
        borderPane.setLeft(interfaceMenu);
    }

    private void assignButtons() {
        addBallotBoxButton();
        addCitizenButton();
        addPartyButton();
        addCandidateButton();
        showAllBallotBoxesButton();
        showAllCitizensButton();
        showAllPartiesButton();
        beginElectionsButton();
        showResultsButton();
    }

    private void addBallotBoxButton() {
        addBallotBox = new Button("Add Ballot Box");
        addBallotBox.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        addBallotBox.setMinHeight(ViewGUI.MIN_BUTTON_HEIGHT_VALUE);
    }

    private void addCitizenButton() {
        addCitizens = new Button("Add Citizen");
        addCitizens.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        addCitizens.setMinHeight(ViewGUI.MIN_BUTTON_HEIGHT_VALUE);
    }

    private void addPartyButton() {
        addParty = new Button("Add Party");
        addParty.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        addParty.setMinHeight(ViewGUI.MIN_BUTTON_HEIGHT_VALUE);
    }

    private void addCandidateButton() {
        addCandidate = new Button("Add Candidate");
        addCandidate.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        addCandidate.setMinHeight(ViewGUI.MIN_BUTTON_HEIGHT_VALUE);
    }

    private void showAllBallotBoxesButton() {
        showAllBallotBoxes = new Button("Show All BallotBoxes");
        showAllBallotBoxes.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        showAllBallotBoxes.setMinHeight(ViewGUI.MIN_BUTTON_HEIGHT_VALUE);
    }

    private void showAllCitizensButton() {
        showAllCitizens = new Button("Show All Citizens");
        showAllCitizens.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        showAllCitizens.setMinHeight(ViewGUI.MIN_BUTTON_HEIGHT_VALUE);
    }

    private void showAllPartiesButton() {
        showAllParties = new Button("Show All Parties");
        showAllParties.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        showAllParties.setMinHeight(ViewGUI.MIN_BUTTON_HEIGHT_VALUE);
    }

    private void beginElectionsButton() {
        beginElections = new Button("Begin Elections");
        beginElections.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        beginElections.setMinHeight(ViewGUI.MIN_BUTTON_HEIGHT_VALUE);
    }

    private void showResultsButton() {
        showResults = new Button("Show Results");
        showResults.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        showResults.setMinHeight(ViewGUI.MIN_BUTTON_HEIGHT_VALUE);
    }

    public void addEventHandlerToAddBallotBoxButton(EventHandler<ActionEvent> event) {
        addBallotBox.setOnAction(event);
    }
    public void addEventHandlerToAddCitizenButton(EventHandler<ActionEvent> event) {
        addCitizens.setOnAction(event);
    }

    public void addEventHandlerToAddPartyButton(EventHandler<ActionEvent> event) {
        addParty.setOnAction(event);
    }

    public void addEventHandlerToAddCandidateButton(EventHandler<ActionEvent> event) {
        addCandidate.setOnAction(event);
    }

    public void addEventHandlerToShowAllBallotBoxesButton(EventHandler<ActionEvent> event) {
        showAllBallotBoxes.setOnAction(event);
    }

    public void addEventHandlerToShowAllCitizensButton(EventHandler<ActionEvent> event) {
        showAllCitizens.setOnAction(event);
    }

    public void addEventHandlerToShowAllPartiesButton(EventHandler<ActionEvent> event) {
        showAllParties.setOnAction(event);
    }

    public void addEventHandlerToBeginElectionsButton(EventHandler<ActionEvent> event) {
        beginElections.setOnAction(event);
    }

    public void addEventHandlerToShowResultsButton(EventHandler<ActionEvent> event) {
        showResults.setOnAction(event);
    }
}