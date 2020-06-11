package view.MainPaneView;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import view.MainPane;
import view.ViewGUI;

public class AddBallotBox extends MainPane {
    private HBox hbAddress;
    private TextField tfAddress;
    private RadioButton rbRegular, rbCorona, rbArmy, rbArmyCorona;
    private ToggleGroup tgBallotBoxType;
    private VBox vbType;

    public AddBallotBox() {
        super();
        setHeadline();
        setFields();
    }

    private void setFields() {
        setAddressField();
        setBallotBoxType();
        createSubmitButton();
    }

    private void setHeadline() {
        headline.setText("Add Ballot Box");
    }

    private void setAddressField() {
        hbAddress = new HBox();
//        Text txtAddress = new Text("Address:");
        tfAddress = new TextField();
        tfAddress.setPromptText("Enter Your Address");
        tfAddress.setFont(buttonsFont);
        tfAddress.setMinWidth(ViewGUI.TEXT_INPUT_WIDTH_VALUE);
        tfAddress.setFocusTraversable(false);

        hbAddress.getChildren().add(tfAddress);
    }

    private void setBallotBoxType() {
        vbType = new VBox();
        VBox typeButtons = new VBox();
        Text txtType = new Text("BallotBox Type :");
        txtType.setFont(buttonsFont);
        tgBallotBoxType = new ToggleGroup();
//        tfType = new TextField();
//        tfType.setPromptText("");
        rbRegular = new RadioButton("Regular");
        rbRegular.setFont(buttonsFont);
        rbRegular.setToggleGroup(tgBallotBoxType);

        rbCorona = new RadioButton("Corona");
        rbCorona.setToggleGroup(tgBallotBoxType);
        rbCorona.setFont(buttonsFont);

        rbArmy = new RadioButton("Army");
        rbArmy.setToggleGroup(tgBallotBoxType);
        rbArmy.setFont(buttonsFont);

        rbArmyCorona = new RadioButton("ArmyCorona");
        rbArmyCorona.setToggleGroup(tgBallotBoxType);
        rbArmyCorona.setFont(buttonsFont);

        typeButtons.getChildren().addAll(rbRegular, rbCorona, rbArmy, rbArmyCorona);
        typeButtons.setSpacing(ViewGUI.RADIO_BUTTON_SPACING);

        VBox.setMargin(txtType, new Insets(0, 0, 10, 0));

        vbType.getChildren().addAll(txtType, typeButtons);
    }

    @Override
    public VBox update() {
        mainView.getChildren().clear();
        mainView.getChildren().addAll(headline, hbAddress, vbType, hbSubmit);
        mainView.setMargin(headline, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbAddress, new Insets(10, 0, 0, 20));
        mainView.setMargin(vbType, new Insets(10, 0, 0, 20));
        mainView.setMargin(hbSubmit, new Insets(10, 0, 0, 20));
        return mainView;
    }
}
