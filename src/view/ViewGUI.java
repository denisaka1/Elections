package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewGUI {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;
    public static final double TEXT_INPUT_WIDTH_VALUE = 300.d;
    public static final double MIN_BUTTON_WIDTH_VALUE = 180.d;
    public static final double MIN_BUTTON_HEIGHT_VALUE = 30.d;
    public static final double RADIO_BUTTON_SPACING = 10.d;
    public static final double SPACING = 5.d;
    private VBox mainView;
    private MenuButtons menuButtons;
    private BorderPane borderPane;

    public ViewGUI(Stage stage) {
        stage.setTitle("Election Interface");
        borderPane = new BorderPane();

        // Menu bar
        MenuBar menuBar = new MenuBar();
        // Help
        Menu helpMenu = new Menu("Help");
        MenuItem help = new MenuItem("Help");
        MenuItem about = new MenuItem("About");
        helpMenu.getItems().addAll(help, about);
        // Exit
        Menu quit = new Menu("Quit");
        menuBar.getMenus().addAll(helpMenu, quit);

        borderPane.setTop(menuBar);

        // Interface Menu
        menuButtons = new MenuButtons(borderPane);

        // Main View
        mainView = new VBox();
        mainView.setAlignment(Pos.TOP_LEFT);
        Text text = new Text("Welcome");
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 16));
        mainView.getChildren().add(text);
        borderPane.setCenter(mainView);

        // Scene
        Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void update(MainPane newMainView) {
        mainView.getChildren().clear();
        mainView.getChildren().add(newMainView.update());
    }

    public MenuButtons getMenuButtons() {
        return menuButtons;
    }
}