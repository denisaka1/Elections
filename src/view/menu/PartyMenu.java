package view.menu;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.InputMenu;

public class PartyMenu extends InputMenu {

    private HBox hbName, hbSection, hbYear, hbMonth, hbDay;
    private TextField tfName, tfSection, tfYear, tfMonth, tfDay;

    public PartyMenu(Stage stage) {
        super(stage);
        menu.setTitle("Party Menu");

        // TODO: add fields: Name, Section(With RadionButtons), Year, Month, Day

    }

    private void setNameField() {
        hbName = new HBox();
        Text txtName = new Text("Name:");
        tfName = new TextField();
//        tfName.set
    }
}
