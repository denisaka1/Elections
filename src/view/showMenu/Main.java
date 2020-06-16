package view.showMenu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import view.ViewGUI;

public class Main {
//    protected VBox content;
    protected Text headline;
    protected VBox mainView;
    protected Font headlineFont;

    public Main() {
        mainView = new VBox(ViewGUI.SPACING);
        mainView.setAlignment(Pos.TOP_LEFT);
        headline = new Text();
        headline.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 16));
    }

    public void setHeadline(String s) {
        headline.setText(s);
    }



//    @Override
    public VBox update() {
        mainView.getChildren().clear();
        mainView.getChildren().add(headline);
        mainView.setMargin(headline, new Insets(10, 0, 0, 20));


        return mainView;
    }
}
