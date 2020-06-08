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

public class BallotBoxMenu extends InputMenu {

    private HBox hbAddress;
    private TextField tfAddress;
    private RadioButton rbRegular, rbCorona, rbArmy, rbArmyCorona;
    private ToggleGroup tgBallotBoxType;
    private VBox vbType;

    public BallotBoxMenu(Stage stage) {
        super(stage);
        menu.setTitle("Ballot Box Menu");

        setAddressField();
        setBallotBoxType();
        mainFrame.getChildren().addAll(hbAddress, vbType);
        mainFrame.setAlignment(Pos.CENTER);
    }

    private void setAddressField() {

        hbAddress = new HBox();
//        Text txtAddress = new Text("Address:");
        tfAddress = new TextField();
        tfAddress.setPromptText("Enter Your Address");
        tfAddress.setFocusTraversable(false);

        hbAddress.getChildren().add(tfAddress);
//        hbAddress.setAlignment(Pos.CENTER_LEFT);
    }

    private void setBallotBoxType() {
//        hbType = new HBox();
        vbType = new VBox();
        VBox typeButtons = new VBox();
        Text txtType = new Text("BallotBox Type:");
        tgBallotBoxType = new ToggleGroup();
//        tfType = new TextField();
//        tfType.setPromptText("");
        rbRegular = new RadioButton("Regular");
        rbRegular.setToggleGroup(tgBallotBoxType);

        rbCorona = new RadioButton("Corona");
        rbCorona.setToggleGroup(tgBallotBoxType);

        rbArmy = new RadioButton("Army");
        rbArmy.setToggleGroup(tgBallotBoxType);

        rbArmyCorona = new RadioButton("ArmyCorona");
        rbArmyCorona.setToggleGroup(tgBallotBoxType);

        typeButtons.getChildren().addAll(rbRegular, rbCorona, rbArmy, rbArmyCorona);
        typeButtons.setSpacing(ViewGUI.RADIO_BUTTON_SPACING);

        for(int i = 0; i < typeButtons.getChildren().size(); i++){
//            VBox.setMargin(typeButtons.getChildren().get(i), new Insets(0, 10, 0, 50));
        }

        vbType.getChildren().addAll(txtType, typeButtons);
        vbType.setAlignment(Pos.CENTER_LEFT);
        vbType.setSpacing(ViewGUI.BUTTON_SPACING);
    }


}
