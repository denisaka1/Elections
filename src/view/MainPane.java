package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public abstract class MainPane {
    protected VBox mainView;
    private Button submit;
    protected HBox hbSubmit;
    protected Text headline;
    protected Font buttonsFont, headlineFont;

    public MainPane()  {
        mainView = new VBox(ViewGUI.SPACING);
        mainView.setAlignment(Pos.TOP_LEFT);
        buttonsFont = Font.font("Tahoma", FontWeight.LIGHT, FontPosture.REGULAR, 14);
        headlineFont = Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 16);
        headline = new Text();
        headline.setFont(headlineFont);
    }

    public VBox update() {
        return mainView;
    }

    protected void createSubmitButton() {
        hbSubmit = new HBox();
        submit = new Button("Submit");
        submit.setMinWidth(ViewGUI.MIN_BUTTON_WIDTH_VALUE);
        submit.setFont(buttonsFont);
        hbSubmit.getChildren().add(submit);
    }
}
