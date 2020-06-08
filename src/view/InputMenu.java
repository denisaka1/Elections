package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class InputMenu extends Menu{

    protected VBox mainFrame;
    private Button submit;
    protected HBox hbSubmit;

    public InputMenu(Stage stage) {
        super(stage);

        mainFrame = new VBox();
        createSubmitButton();

        mainFrame.setSpacing(ViewGUI.BUTTON_SPACING);
        mainFrame.setAlignment(Pos.CENTER);

        border.setCenter(mainFrame);
        border.setBottom(hbSubmit);
    }

    protected void createSubmitButton() {
        hbSubmit = new HBox();

        hbSubmit.setAlignment(Pos.CENTER);
//        hbSubmit.setSpacing(ViewGUI.BUTTON_SPACING);

        submit = new Button("Submit");
        submit.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);

        hbSubmit.getChildren().add(submit);
    }

}
