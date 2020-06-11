package view.MainPaneView;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import view.MainPane;
import view.ViewGUI;

public class AddParty extends MainPane {
    private HBox hbName, hbSection, hbCreateDate;
    private VBox vbSection;
    private TextField tfName;
    private ComboBox day, month, year;
    private RadioButton rightSection, leftSection, centerSection;
    private ToggleGroup tg;

    public AddParty() {
        super();
        setHeadline();
        setFields();
    }

    private void setHeadline() {
        headline.setText("Add Party");
    }

    private void setFields() {
        setNameField();
        setCreateDateField();
        setSectionField();
        createSubmitButton();
    }

    private void setNameField() {
        hbName = new HBox();
        tfName = new TextField();
        tfName.setPromptText("Enter Party Name");
        tfName.setFont(buttonsFont);
        tfName.setMinWidth(ViewGUI.TEXT_INPUT_WIDTH_VALUE);
        hbName.getChildren().addAll(tfName);
    }

    private void setCreateDateField() {
        hbCreateDate = new HBox();
        Text txtCreateDate = new Text("Create Date :");
        txtCreateDate.setFont(buttonsFont);

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

        hbCreateDate.getChildren().addAll(txtCreateDate, day, month, year);
        hbCreateDate.setSpacing(ViewGUI.SPACING);
    }

    private void setSectionField() {
        vbSection = new VBox();
        hbSection = new HBox();
        tg = new ToggleGroup();
        Text sectionTxt = new Text("Section :");
        sectionTxt.setFont(buttonsFont);

        rightSection = new RadioButton("Right");
        rightSection.setFont(buttonsFont);
        rightSection.setToggleGroup(tg);

        centerSection = new RadioButton("Center");
        centerSection.setFont(buttonsFont);
        centerSection.setToggleGroup(tg);

        leftSection = new RadioButton("Left");
        leftSection.setFont(buttonsFont);
        leftSection.setToggleGroup(tg);

        vbSection.getChildren().addAll(rightSection, centerSection, leftSection);
        vbSection.setMargin(centerSection, new Insets(5, 0, 0, 0));
        vbSection.setMargin(leftSection, new Insets(5, 0, 0, 0));

        hbSection.getChildren().addAll(sectionTxt, vbSection);
        hbSection.setSpacing(15);
    }

    @Override
    public VBox update() {
        mainView.getChildren().clear();
        mainView.getChildren().addAll(headline, hbName, hbCreateDate, hbSection, hbSubmit);
        mainView.setMargin(headline, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbName, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbCreateDate, new Insets(0, 0, 0, 20));
        mainView.setMargin(hbSection, new Insets(0, 0, 0, 20));
        mainView.setMargin(hbSubmit, new Insets(10, 0, 0, 20));

        return mainView;
    }
}
