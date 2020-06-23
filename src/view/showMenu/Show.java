package view.showMenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import view.ViewGUI;

public class Show {
    protected Text headline;
    protected VBox mainView;
    protected Font headLineFont = Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 16);
    protected ScrollPane scrollPane;
    protected VBox scrollPaneVB;
//    protected Insets defaultSpacing = new Insets(10, 0, 0, 20);

    public Show() {
        mainView = new VBox(ViewGUI.SPACING);
        mainView.setAlignment(Pos.TOP_LEFT);
        headline = new Text();
        headline.setFont(headLineFont);
        scrollPaneVB = new VBox(ViewGUI.SPACING);
        scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    }

    public void setHeadline(String s) {
        headline.setText(s);
    }

    protected void assignScrollPane() {
        scrollPane.setContent(scrollPaneVB);
        scrollPane.setStyle("-fx-background-color:transparent; -fx-min-height: 470px;");
        mainView.getChildren().add(scrollPane);
    }

//    @Override
    public VBox update() {
        mainView.getChildren().clear();
        mainView.getChildren().add(headline);
        mainView.setMargin(headline, ViewGUI.DEFAULT_INSETS);
//        mainView.getChildren().add(scrollPane);

        return mainView;
    }
}
