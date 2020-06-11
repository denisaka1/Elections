package view.MainPaneView;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import view.MainPane;

public class Main extends MainPane {
    private VBox content;

    public Main() {
        super();
        setHeadline();
        setContent();
    }

    private void setHeadline() {
        headline.setText("Election");
    }

    private void setContent() {
        content = new VBox();
        Text text = new Text("Bla Bla Bla");
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 16));
        content.getChildren().add(text);
    }

    @Override
    public VBox update() {
        mainView.getChildren().clear();
        mainView.getChildren().addAll(headline, content);
        mainView.setMargin(headline, new Insets(10, 0, 0, 20));
        mainView.setMargin(content, new Insets(10, 0, 0, 20));

        return mainView;
    }
}
