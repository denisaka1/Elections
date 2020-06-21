package view.showMenu;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import view.ViewGUI;

public class Main {
    protected Text headline;
    protected VBox mainView;
    protected Font headLineFont = Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 16);
    ScrollPane scrollPane;
//    protected Insets defaultSpacing = new Insets(10, 0, 0, 20);

    public Main() {
        mainView = new VBox(ViewGUI.SPACING);
        mainView.setAlignment(Pos.TOP_LEFT);
        headline = new Text();
        headline.setFont(headLineFont);
        scrollPane = new ScrollPane();
    }

    public void setHeadline(String s) {
        headline.setText(s);
    }

//    @Override
    public VBox update() {
        mainView.getChildren().clear();
        scrollPane.setContent(headline); // FIXME: continue
        mainView.getChildren().add(scrollPane);
//        mainView.setMargin(scrollPane, ViewGUI.DEFAULT_INSETS);

        return mainView;
    }
}
