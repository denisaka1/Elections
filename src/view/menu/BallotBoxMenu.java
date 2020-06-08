package view.menu;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.InputMenu;

public class BallotBoxMenu extends InputMenu {

    private HBox hbAddress, hbType;
    private TextField tfID, tfType;

    public BallotBoxMenu(Stage stage) {
        super(stage);
        menu.setTitle("Ballot Box Menu");

        setAddressField();
        setBallotBoxType();
        mainFrame.getChildren().addAll(hbAddress, hbType);



    }

    private void setAddressField() {
        hbAddress = new HBox();
        Text txtID = new Text("Address:");
        tfID = new TextField();
        hbAddress.getChildren().addAll(txtID, tfID);
        hbAddress.setAlignment(Pos.CENTER);
    }

    private void setBallotBoxType() {
        // FIXME: enter numbers (1 ,2 ,3 ,4) or enter type (Regular, Corona, Army, ArmyCorona)
        hbType = new HBox();
        Text txtID = new Text("BallotBox Type:");
        tfType = new TextField();
        hbType.getChildren().addAll(txtID, tfType);
        hbType.setAlignment(Pos.CENTER);
    }


}
