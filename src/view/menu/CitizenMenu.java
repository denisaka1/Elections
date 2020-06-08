package view.menu;

import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.InputMenu;
import view.ViewGUI;

public class CitizenMenu extends InputMenu {

    private HBox hbName, hbID, hbBirthYear, hbIsolation, hbBallotBoxNumber;
    private VBox toggleIsolation, vbIsolation;
    private TextField tfName, tfID, tfBirthYear, tfIsolation, tfBallotBoxNumber;
    private RadioButton inIsolation, notInIsolation;
    private ToggleGroup tg;

    public CitizenMenu(Stage stage) {
        super(stage);
        menu.setTitle("Citizen Menu");

        setFields();
        mainFrame.getChildren().addAll(hbName, hbID, hbBirthYear, vbIsolation, hbBallotBoxNumber);
        mainFrame.setAlignment(Pos.CENTER_LEFT);
    }

    private void setFields() {
        setNameField();
        setIDField();
        setBirthYearField();
        setIsolationField();
        setBallotBoxNumberField();
    }

    private void setNameField() { // FIXME: add Alert if the Name  is not correct
        hbName = new HBox();
//        Text txtID = new Text("Name:");
        tfName = new TextField();
        tfName.setPromptText("Enter Your Name");
        hbName.getChildren().addAll(tfName);
        hbName.setAlignment(Pos.CENTER);
    }

    private void setIDField() { // FIXME: add Alert if the ID is not correct
        hbID = new HBox();
//        Text txtID = new Text("ID:");
        tfID = new TextField();
        tfID.setPromptText("Enter Your ID");
        hbID.getChildren().addAll(tfID);
        hbID.setAlignment(Pos.CENTER);
    }

    private void setBirthYearField() { // FIXME: add Alert if the BirthYear is not correct
        hbBirthYear = new HBox();
//        Text txtBirthYear = new Text("BirthYear:");
        tfBirthYear = new TextField();
        tfBirthYear.setPromptText("Enter Your Birth Year");
//        tfBirthYear.set
        hbBirthYear.getChildren().addAll(tfBirthYear);
        hbBirthYear.setAlignment(Pos.CENTER);
    }

    private void setIsolationField() {
        hbIsolation = new HBox();
        tg = new ToggleGroup();
        toggleIsolation = new VBox();
        vbIsolation = new VBox();
        Text txtIsolation = new Text("In Isolation?");

        tfIsolation = new TextField();
        tfIsolation.setPromptText("How Many Days?");

        inIsolation = new RadioButton("Yes");
        inIsolation.setToggleGroup(tg);

        notInIsolation = new RadioButton("No");
        notInIsolation.setToggleGroup(tg);

        toggleIsolation.getChildren().addAll(inIsolation, notInIsolation);

        hbIsolation.getChildren().addAll(txtIsolation, toggleIsolation);
        hbIsolation.setSpacing(45);
        hbIsolation.setAlignment(Pos.CENTER);

        vbIsolation.getChildren().addAll(hbIsolation, tfIsolation);
        vbIsolation.setAlignment(Pos.CENTER);
        vbIsolation.setSpacing(ViewGUI.BUTTON_SPACING);
    }

    private void setBallotBoxNumberField() { // FIXME: add Alert if the BallotBoxNumber is not correct
        hbBallotBoxNumber = new HBox();
//        Text txtBallotBoxNumber = new Text("BallotBox Number:");
        tfBallotBoxNumber = new TextField();
        tfBallotBoxNumber.setPromptText("Enter BallotBox Number");
        hbBallotBoxNumber.getChildren().addAll(tfBallotBoxNumber);
        hbBallotBoxNumber.setAlignment(Pos.CENTER);
    }

}
