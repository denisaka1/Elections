package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ViewGUI {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final double MIN_BUTTON_WIDTH_VALUE = 150.d;
    public static final double BUTTON_SPACING = 10.d;
    public static final double RADIO_BUTTON_SPACING = 10.d;
//    private ImageView flag = setImage("./src/flag.png", stage); // add different image at the same path and change its name
//    public static final String pathToImage = "./src/flag.png"; // add different image at the same path and change its name
    public static final String pathToImage = "./src/test1.jpg"; // add different image at the same path and change its name
    private Scene theScene;
    private Button addBallotBox, addCitizens, addParty, addCandidate,
            showAllBallotBoxes, showAllCitizens, showAllParties,
            beginElections, showResults;

    public ViewGUI(Stage stage) {
        stage.setTitle("Election Interface");

        ImageView flag = setImage(pathToImage, stage);

        assignButtons();

        BorderPane border = new BorderPane();
        VBox mainFrame = new VBox();

        mainFrame.getChildren().addAll(addBallotBox, addCitizens, addParty, addCandidate,
                showAllBallotBoxes, showAllCitizens, showAllParties,
                beginElections, showResults);
        mainFrame.setSpacing(BUTTON_SPACING); // creates spaces between buttons

        // bind the flag to stage


        border.getChildren().add(flag);
        border.setCenter(mainFrame);
        mainFrame.setAlignment(Pos.CENTER);

        theScene = new Scene(border, WIDTH, HEIGHT);

        stage.setScene(theScene);
        stage.show();
    }

    public static ImageView setImage(String pathToImage, Stage stage) {
        ImageView flag = null;
        try {
            flag = new ImageView(new Image(new FileInputStream(pathToImage)));

            // bind the flag to stage
            flag.fitWidthProperty().bind(stage.widthProperty());
            flag.fitHeightProperty().bind(stage.heightProperty());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
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
        addBallotBox.setMinWidth(MIN_BUTTON_WIDTH_VALUE);
    }

    private void addCitizenButton() {
        addCitizens = new Button("Add Citizen");
        addCitizens.setMinWidth(MIN_BUTTON_WIDTH_VALUE);
    }

    private void addPartyButton() {
        addParty = new Button("Add Party");
        addParty.setMinWidth(MIN_BUTTON_WIDTH_VALUE);
    }

    private void addCandidateButton() {
        addCandidate = new Button("Add Candidate");
        addCandidate.setMinWidth(MIN_BUTTON_WIDTH_VALUE);
    }

    private void showAllBallotBoxesButton() {
        showAllBallotBoxes = new Button("Show All BallotBoxes");
        showAllBallotBoxes.setMinWidth(MIN_BUTTON_WIDTH_VALUE);
    }

    private void showAllCitizensButton() {
        showAllCitizens = new Button("Show All Citizens");
        showAllCitizens.setMinWidth(MIN_BUTTON_WIDTH_VALUE);
    }

    private void showAllPartiesButton() {
        showAllParties = new Button("Show All Parties");
        showAllParties.setMinWidth(MIN_BUTTON_WIDTH_VALUE);
    }

    private void beginElectionsButton() {
        beginElections = new Button("Begin Elections");
        beginElections.setMinWidth(MIN_BUTTON_WIDTH_VALUE);
    }

    private void showResultsButton() {
        showResults = new Button("Show Results");
        showResults.setMinWidth(MIN_BUTTON_WIDTH_VALUE);
    }

    public void addEventHandlerToAddBallotBoxButton(EventHandler<ActionEvent> event) {
        addBallotBox.setOnAction(event);
    }

    public void addEventHandlerToAddCitizen(EventHandler<ActionEvent> event) {
        addCitizens.setOnAction(event);
    }

    public void addEventHandlerToAddParty(EventHandler<ActionEvent> event) {
        addParty.setOnAction(event);
    }

    public void addEventHandlerToAddCandidate(EventHandler<ActionEvent> event) {
        addCandidate.setOnAction(event);
    }

    public void addEventHandlerToShowAllBallotBoxes(EventHandler<ActionEvent> event) {
        showAllBallotBoxes.setOnAction(event);
    }

    public void addEventHandlerToShowAllCitizens(EventHandler<ActionEvent> event) {
        showAllCitizens.setOnAction(event);
    }

    public void addEventHandlerToShowAllParties(EventHandler<ActionEvent> event) {
        showAllParties.setOnAction(event);
    }

    public void addEventHandlerToBeginElections(EventHandler<ActionEvent> event) {
        beginElections.setOnAction(event);
    }

    public void addEventHandlerToShowResults(EventHandler<ActionEvent> event) {
        showResults.setOnAction(event);
    }
}
