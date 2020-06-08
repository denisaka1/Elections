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

public class CitizenMenu extends InputMenu {

    private HBox hbName, hbID, hbBirthYear, hbIsolation, hbBallotBoxNumber;
    private VBox toggleIsolation;
    private TextField tfName, tfID, tfBirthYear, tfIsolation, tfBallotBoxNumber;
    private RadioButton inIsolation, notInIsolation;
    private ToggleGroup tg;

    public CitizenMenu(Stage stage) {
        super(stage);
        menu.setTitle("Citizen Menu");

        setFields();
        mainFrame.getChildren().addAll(hbName, hbID, hbBirthYear, hbIsolation, hbBallotBoxNumber);
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
        Text txtID = new Text("Name:");
        tfName = new TextField();
        hbName.getChildren().addAll(txtID, tfName);
        hbName.setAlignment(Pos.CENTER);
    }

    private void setIDField() { // FIXME: add Alert if the ID is not correct
        hbID = new HBox();
        Text txtID = new Text("ID:");
        tfID = new TextField();
        hbID.getChildren().addAll(txtID, tfID);
        hbID.setAlignment(Pos.CENTER);
    }

    private void setBirthYearField() { // FIXME: add Alert if the BirthYear is not correct
        hbBirthYear = new HBox();
        Text txtBirthYear = new Text("BirthYear:");
        tfBirthYear = new TextField();
        hbBirthYear.getChildren().addAll(txtBirthYear, tfBirthYear);
        hbBirthYear.setAlignment(Pos.CENTER);
    }

    private void setIsolationField() { // FIXME: RadioButtons -> make work
        hbIsolation = new HBox();
        tg = new ToggleGroup();
        toggleIsolation = new VBox();
        Text txtID = new Text("Isolation:");
//        tfIsolation = new TextField();

        inIsolation = new RadioButton("Yes");
        inIsolation.setToggleGroup(tg);

        notInIsolation = new RadioButton("No");
        notInIsolation.setToggleGroup(tg);

        toggleIsolation.getChildren().addAll(inIsolation, notInIsolation);

//        hbIsolation.getChildren().addAll(txtID, tfIsolation, toggleIsolation);
        hbIsolation.getChildren().add(txtID);
        hbIsolation.setAlignment(Pos.CENTER);
    }

    private void setBallotBoxNumberField() { // FIXME: add Alert if the BallotBoxNumber is not correct
        hbBallotBoxNumber = new HBox();
        Text txtID = new Text("BallotBoxNumber:");
        tfBallotBoxNumber = new TextField();
        hbBallotBoxNumber.getChildren().addAll(txtID, tfBallotBoxNumber);
        hbBallotBoxNumber.setAlignment(Pos.CENTER);
    }

}
