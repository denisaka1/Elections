package view.MainPaneView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import view.ViewGUI;
import view.showMenu.Main;

public class MainPane extends Main {

    protected Button submit;
    protected HBox hbSubmit;
    protected Font buttonsFont;

    public MainPane()  {
        super();
        createSubmitButton();
    }

/*    public Button getSubmit() {
        return submit;
    }*/

/*    @Override
    public VBox update() {
        super.update();
//        mainView.getChildren().add(hbSubmit);

        return mainView;
    }*/

    private void createSubmitButton() {
        hbSubmit = new HBox();
        buttonsFont = Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14);
        submit = new Button("Submit");
        submit.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        submit.setFont(buttonsFont);
        hbSubmit.getChildren().add(submit);
    }

    public void eventSubmitButton(EventHandler<ActionEvent> event) {
        submit.setOnAction(event);
    }
}
