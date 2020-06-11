package view.MainPaneView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import view.MainPane;
import view.ViewGUI;

public class AddCitizen extends MainPane {
    private HBox hbName, hbID, hbBirthYear, hbIsolation, hbBallotBoxNumber;
    private VBox toggleIsolation;
    private TextField tfName, tfID, tfIsolation, tfBallotBoxNumber;
    private RadioButton inIsolation, notInIsolation;
    private ToggleGroup tg;
    private ComboBox day, month, year, ballotBox;

    public AddCitizen() {
        super();
        setHeadline();
        setFields();
    }

    private void setHeadline() {
        headline.setText("Add Citizen");
    }

    private void setFields() {
        setNameField();
        setIDField();
        setBirthYearField();
        setIsolationField();
        setBallotBoxNumberField();
        createSubmitButton();
    }
    private void setNameField() { // FIXME: add Alert if the Name  is not correct
        hbName = new HBox();
//        Text txtID = new Text("Name:");
        tfName = new TextField();
        tfName.setPromptText("Enter Your Name");
        tfName.setFont(buttonsFont);
        tfName.setMinWidth(ViewGUI.TEXT_INPUT_WIDTH_VALUE);
        hbName.getChildren().addAll(tfName);
    }

    private void setIDField() { // FIXME: add Alert if the ID is not correct
        hbID = new HBox();
//        Text txtID = new Text("ID:");
        tfID = new TextField();
        tfID.setPromptText("Enter Your ID");
        tfID.setFont(buttonsFont);
        tfID.setMinWidth(ViewGUI.TEXT_INPUT_WIDTH_VALUE);
        hbID.getChildren().addAll(tfID);
    }

    private void setBirthYearField() { // FIXME: add Alert if the BirthYear is not correct
        hbBirthYear = new HBox();
        Text txtBirthYear = new Text("BirthYear:");
        txtBirthYear.setFont(buttonsFont);

        day = new ComboBox();
        month = new ComboBox();
        year = new ComboBox();

        // Day
        day.setPromptText("Day");
        for (int i = 1; i <= 31; i++)
            day.getItems().add(i);

        // Month
        month.setPromptText("Month");
        for (int i = 1; i <= 12; i++)
            month.getItems().add(i);

        // Year
        year.setPromptText("Year");
        for (int i = 1900; i <= 2002; i++) // FIXME: take year from election - 18
            year.getItems().add(i);

        hbBirthYear.getChildren().addAll(txtBirthYear, day, month, year);
        hbBirthYear.setSpacing(ViewGUI.SPACING);
    }

    private void setIsolationField() {
        hbIsolation = new HBox();
        tg = new ToggleGroup();
        toggleIsolation = new VBox();
        Text txtIsolation = new Text("In Isolation?");
        txtIsolation.setFont(buttonsFont);

        tfIsolation = new TextField();
        tfIsolation.setPromptText("How Many Days?");
        tfIsolation.setFont(buttonsFont);
        tfIsolation.setMaxWidth(150);
        tfIsolation.setVisible(false);

        inIsolation = new RadioButton("Yes");
        inIsolation.setFont(buttonsFont);
        inIsolation.setToggleGroup(tg);

        notInIsolation = new RadioButton("No");
        notInIsolation.setFont(buttonsFont);
        notInIsolation.setToggleGroup(tg);
        notInIsolation.setSelected(true);

        toggleIsolation.getChildren().addAll(inIsolation, notInIsolation);
        toggleIsolation.setMargin(notInIsolation, new Insets(5, 0, 0, 0));

        hbIsolation.getChildren().addAll(txtIsolation, toggleIsolation, tfIsolation);
        hbIsolation.setSpacing(15);

        addChangeListenerToToggleGroup(chl);
    }

    private void setBallotBoxNumberField() { // FIXME: add Alert if the BallotBoxNumber is not correct
        hbBallotBoxNumber = new HBox();
//        Text txtBallotBoxNumber = new Text("BallotBox Number:");
        ballotBox = new ComboBox();
        ballotBox.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        ballotBox.setPromptText("Choose BallotBox");
        ballotBox.getItems().add("Ballot Box 1"); // FIXME: add legal ballot boxes
        ballotBox.getItems().add("Ballot Box 2");
        ballotBox.getItems().add("Ballot Box 3");
        ballotBox.setStyle("-fx-font: 14px \"Tahoma\";");
        hbBallotBoxNumber.getChildren().addAll(ballotBox);
    }

    ChangeListener<Toggle> chl = new ChangeListener<Toggle>() {
        @Override
        public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
            if (inIsolation.isSelected())
                tfIsolation.setVisible(true);
            else
                tfIsolation.setVisible(false);
        }
    };


    public void addChangeListenerToToggleGroup(ChangeListener<Toggle> chl) {
        tg.selectedToggleProperty().addListener(chl);
    }

    @Override
    public VBox update() {
        mainView.getChildren().clear();
        mainView.getChildren().addAll(headline, hbName, hbID, hbBirthYear, hbIsolation, hbBallotBoxNumber, hbSubmit);
        mainView.setMargin(headline, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbName, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbID, new Insets(0, 0, 0, 20));
        mainView.setMargin(hbBirthYear, new Insets(0, 0, 0, 20));
        mainView.setMargin(hbIsolation, new Insets(0, 0, 0, 20));
        mainView.setMargin(hbBallotBoxNumber, new Insets(0, 0, 0, 20));
        mainView.setMargin(hbSubmit, new Insets(10, 0, 0, 20));

        return mainView;
    }
}
