package view.MainPaneView;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import view.ViewGUI;

public class AddCitizen extends MainPane {
    private HBox hbName, hbID, hbBirthYear, hbIsolation, hbBallotBoxNumber;
    private VBox toggleIsolation;
    private TextField tfName, tfID, tfIsolation, tfBallotBoxNumber;
    private RadioButton inIsolation, notInIsolation;
    private ToggleGroup tg;
    private ComboBox day, month, year, ballotBox;
    private int electionYear;

    public AddCitizen(int year) {
        super();
        setHeadline("Add Citizen");
        electionYear = year;
        setFields();
    }

    private void setFields() {
        setNameField();
        setIDField();
        setBirthYearField();
        setIsolationField();
        setBallotBoxNumberField();
    }

    private void setNameField() {
        hbName = new HBox();
//        Text txtID = new Text("Name:");
        tfName = new TextField();
        tfName.setPromptText("Enter Your Name");
        tfName.setFont(buttonsFont);
        tfName.setMinWidth(ViewGUI.TEXT_INPUT_WIDTH_VALUE);
        hbName.getChildren().addAll(tfName);
    }

    private void setIDField() {
        hbID = new HBox();
//        Text txtID = new Text("ID:");
        tfID = new TextField();
        tfID.setPromptText("Enter Your ID");
        tfID.setFont(buttonsFont);
        tfID.setMinWidth(ViewGUI.TEXT_INPUT_WIDTH_VALUE);
        hbID.getChildren().addAll(tfID);
    }

    private void setBirthYearField() {
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
        for (int i = 1900; i <= (electionYear - 18); i++)
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
    }

    private void setBallotBoxNumberField() { // FIXME: add Alert if the BallotBoxNumber empty
        hbBallotBoxNumber = new HBox();
//        Text txtBallotBoxNumber = new Text("BallotBox Number:");
        ballotBox = new ComboBox();
        ballotBox.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        ballotBox.setPromptText("Choose BallotBox");
        ballotBox.setStyle("-fx-font: 14px \"Tahoma\";");
        ballotBox.getEditor().setFont(buttonsFont);
        hbBallotBoxNumber.getChildren().addAll(ballotBox);
    }

    public void updateBallotBoxes(ComboBox ballotBox) {
        hbBallotBoxNumber.getChildren().clear();
        ballotBox.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        ballotBox.setPromptText("Choose BallotBox");
        ballotBox.setStyle("-fx-font: 14px \"Tahoma\";");
        ballotBox.getEditor().setFont(buttonsFont);
        hbBallotBoxNumber.getChildren().addAll(ballotBox);
    }

    public VBox getMainView() {
        return mainView;
    }

    public int getSelectedYear() {
        return Integer.parseInt(year.getSelectionModel().getSelectedItem().toString());
    }

    public String getName() {
        return tfName.getText();
    }

    public int getSelectedBallotBox() {
        return Integer.parseInt(ballotBox.getSelectionModel().getSelectedItem().toString().split(" - ")[0]);
    }

    public String getID() {
        return tfID.getText();
    }

    public int getDay() {
        return Integer.parseInt(day.getSelectionModel().getSelectedItem().toString());
    }

    public int getMonth() {
        return Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());
    }

    public int getYear() {
        return Integer.parseInt(year.getSelectionModel().getSelectedItem().toString());
    }

    public boolean getIsolation() {
        if (inIsolation.isSelected())
            return true;
        return false;
    }

    public int getIsolationDays() {
        return Integer.parseInt(tfIsolation.getText());
    }

    public void isolationDaysVisible() {
        if (inIsolation.isSelected())
            tfIsolation.setVisible(true);
        else
            tfIsolation.setVisible(false);
    }

    public void addEventIsoRadio(ChangeListener<Toggle> chl) {
        tg.selectedToggleProperty().addListener(chl);
    }

    public void addEventYearComboBox(ChangeListener<Integer> chl) {
        year.getSelectionModel().selectedItemProperty().addListener(chl);
    }

    @Override
    public VBox update() {
        super.update();
        mainView.getChildren().addAll(hbName, hbID, hbBirthYear, hbIsolation, hbBallotBoxNumber, hbSubmit);
        mainView.setMargin(hbName, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbID, new Insets(0, 0, 0, 20));
        mainView.setMargin(hbBirthYear, new Insets(0, 0, 0, 20));
        mainView.setMargin(hbIsolation, new Insets(0, 0, 0, 20));
        mainView.setMargin(hbBallotBoxNumber, new Insets(0, 0, 0, 20));
        mainView.setMargin(hbSubmit, new Insets(10, 0, 0, 20));

        return mainView;
    }
}
