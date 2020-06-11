package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.MainPaneView.Main;

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
    private MenuBar menuBar;
    private Menu helpMenu, fileMenu;
    private MenuItem help, about, exit, main;

    public ViewGUI(Stage stage) {
        stage.setTitle("Election Interface");
        borderPane = new BorderPane();

        // Menu bar
        menuBar = new MenuBar();
        // Help
        helpMenu = new Menu("Help");
        help = new MenuItem("View Help");
        about = new MenuItem("About");
        helpMenu.getItems().addAll(help, about);
        // File
        fileMenu = new Menu("View");
        main = new MenuItem("Main");
        exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(main, new SeparatorMenuItem(), exit);
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        borderPane.setTop(menuBar);

        // Interface Menu
        menuButtons = new MenuButtons(borderPane);

        // Main View
        mainView = new Main().update();
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

    public void addEventCloseButton(EventHandler<ActionEvent> event) {
        exit.setOnAction(event);
    }

    public void addEventMainButton(EventHandler<ActionEvent> event) {
        main.setOnAction(event);
    }

    public void addEventHelpButton(EventHandler<ActionEvent> event) {
        help.setOnAction(event);
    }

    public void addEventAboutButton(EventHandler<ActionEvent> event) {
        about.setOnAction(event);
    }
}