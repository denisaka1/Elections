package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.MainPaneView.MainPane;
import view.MainPaneView.WelcomeMenu;
import view.showMenu.Main;

public class ViewGUI {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;
    public static final double TEXT_INPUT_WIDTH_VALUE = 300.d;
    public static final double MIN_BUTTON_WIDTH_VALUE = 180.d;
    public static final double MIN_BUTTON_HEIGHT_VALUE = 30.d;
    public static final double RADIO_BUTTON_SPACING = 10.d;
    public static final double SPACING = 5.d;
//    private TextField tfYear;
    private VBox mainView;
    private MenuButtons menuButtons;
    private BorderPane borderPane;
    private MenuBar menuBar;
    private Menu helpMenu, fileMenu;
    private MenuItem help, about, exit, main;
    private WelcomeMenu welcomeMenu;

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
        welcomeMenu = new WelcomeMenu();
        mainView = welcomeMenu.update();

/*        Main main = new Main();
        main.setHeadline("Welcome to the MAIN MENU!");*/

        borderPane.setCenter(mainView);

        // Scene
        Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void clear() {
        mainView.getChildren().clear();
    }

    public void update(MainPane newMainView) {
        mainView.getChildren().clear();
        mainView.getChildren().add(newMainView.update());
    }

    public void update(Main newMainView) {
        mainView.getChildren().clear();
        mainView.getChildren().add(newMainView.update());
    }

    public String getMonthText() {
        return welcomeMenu.getMonthText();
    }

    public String getYearText() {
        return welcomeMenu.getYearText();
    }
/*    public TextField getMonthTextField() {
        return welcomeMenu.getMonthTextField();
    }

    public TextField getYearTextField() {
        return welcomeMenu.getYearTextField();
    }*/

/*    public void setMainMenu() {
        // FIXME: should enter year before you can do anything else
        // main menu Window
//        mainView.getChildren().clear();
        MainPane main = new MainPane();
        main.setHeadline("Welcome to Election App");

        tfYear = new TextField();
        tfYear.setPromptText("Enter Current Year");
        tfYear.setFont(main.buttonsFont);
        tfYear.setMinWidth(ViewGUI.TEXT_INPUT_WIDTH_VALUE);
        tfYear.setFocusTraversable(false);


        mainView = main.update();
        mainView.getChildren().add(tfYear);
        mainView.setMargin(tfYear, new Insets(10, 0, 0, 20));
//        return main;
    }*/

    public MenuButtons getMenuButtons() {
        return menuButtons;
    }

    public WelcomeMenu getWelcomeMenu() {
         return welcomeMenu;
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

    public void addEventSubmitButton(EventHandler<ActionEvent> event) {
        welcomeMenu.getSubmitButton().setOnAction(event);
    }
}